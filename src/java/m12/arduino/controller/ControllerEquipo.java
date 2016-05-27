/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import m12.arduino.dao.DaoTrabajadorImpl;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.EquipoForm;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceTrabajador;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para los objetos Equipo
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/equipo")
public class ControllerEquipo {

    private ServiceTrabajador sT = new ServiceTrabajador();
    private ServiceEquipo sE = new ServiceEquipo();
    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();

    /**
     * Metodo formulario de alta de equipos.
     * @return Devuelve un objeto ModelAndView (formulario) llamado equipoAlta con 
     * un objeto EquipoForm vacio y una lista de trabajadores. 
     */
    @RequestMapping("alta")
    public ModelAndView initFormAlta() {
        ModelAndView mV = new ModelAndView("equipoAlta", "command", new EquipoForm());
        mV.addObject("listaTrabajadores", sT.listarTrabajadores());
        return mV;
    }

    /**
     * Metodo para insertar equipos en la base de datos
     * @param eq Objeto EquipoForm con los datos del Equipo a insertar
     * @return Devuelve un objeto ModelAndView (vista) llamado detalleObjeto 
     * con los datos del Equipo insertado.
     */
    @RequestMapping("insertar")
    public ModelAndView insertarEquipo(EquipoForm eq) {
        Equipo res = new Equipo();
        Trabajador treb;
        res.setId_equipo(eq.getId_equipo());
        res.setNombre(eq.getNombre());
        //Insertar equipo para generar un ID
        sE.insertarEquipo(res);
        //Recuperar objeto Equipo con ID generado
        res = sE.buscarEquipo(eq.getId_equipo());
        if (eq.getNifs() != null) {
            for (String str : eq.getNifs()) {
                //Buscar trabajador segun datos del formulario
                treb = sT.buscarTrabajador(str);
                //Programacion defensiva
                res.addTrabajador(treb);
                //Actualizar Trabajador
                sT.actualizarTrabajador(treb);
            }
        }

        ModelAndView mV = new ModelAndView("detalleObjeto");
        mV.addObject("objeto", res);
        return mV;
    }

    /**
     * Metodo para actializar equipos de la base de datos.
     * @param eqForm Objeto EquipoForm con los datos del equipo a actualizar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    public @ResponseBody String actualizarEquipo(@RequestBody EquipoForm eqForm) {
        Equipo eq = new Equipo();
        eq.setId(eqForm.getId());
        eq.setId_equipo(eqForm.getId_equipo());
        eq.setNombre(eqForm.getNombre());
        eq.setTrabajadores(eqForm.getTrabajadores());
        String response = "";
        try {
            List<Trabajador> actual = sE.buscarEquipo(eqForm.getId_equipo()).getTrabajadores();
            for (Trabajador trab : actual) {
                if (!eq.getTrabajadores().contains(trab)) {
                    trab.setEquipo(null);
                    sT.actualizarTrabajador(trab);
                }
            }
            for (Trabajador trab : eq.getTrabajadores()) {
                trab.setEquipo(eq);
                sT.actualizarTrabajador(trab);
            }
            sE.actualizarEquipo(eq);
            response = "<div class=\"alert alert-success\">El equipo se ha actualizado correctamente</div>";
        } catch (ConstraintViolationException e) {
            response = "<div class=\"alert alert-danger\">Ha habido un problema al actualizar el equipo, tiene alguna orden encargada</div>";
        }
        return response;
    }

    /**
     * Metodo para eliminar equipos de la base de datos.
     * @param eqForm objeto EquipoForm con los datos del equipo a eliminar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value = "/eliminar", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String eliminarEquipo(@RequestBody EquipoForm eqForm) {
        String msg = "";
        try {
            Equipo eq = new Equipo();
            eq = sE.buscarEquipo(eqForm.getId_equipo());
            for (Trabajador trab : eq.getTrabajadores()) {
                trab.setEquipo(null);
                sT.actualizarTrabajador(trab);
            }
            sE.eliminarEquipo(eq);
            msg = "<div class=\"alert alert-success\">El equipo se ha eliminado correctamente</div>";
        } catch (ConstraintViolationException e) {
            msg  = "<div class=\"alert alert-danger\">Ha habido un problema al eliminar el equipo, tiene alguna orden encargada</div>";
        }
        return msg;
    }

    /**
     * Metodo para asignar ordenes a equipos.
     * @return Devuelve un objeto ModelAndView (vista) llamado equipoAsignarOrden
     * con un objeto vacio EquipoForm y dos deplegables, (equipos y ordenes) 
     * para poder seleccionarlos.
     */
    @RequestMapping("/asignarOrden")
    public ModelAndView asignarOrden() {
        EquipoForm eF = new EquipoForm();
        ModelAndView mV = new ModelAndView("equipoAsignarOrden", "command", eF);
        mV.addObject("equipos", sE.listarEquipos());
        mV.addObject("ordenes", sO.listarOrdenes("estado", EstadoOrden.INDEFINIDO)); // Nomes es poden assignar ordres no assignades anteriorment (Indefinido)
        return mV;
    }

    /**
     * Metodo para asignar ordenes a equipos.
     * @param eF objeto EquipoForm con los datos de la orden y el equipo.
     * @return un objeto ModelAndView (vista) con los detalles de la orden y el 
     * equipo.
     */
    @RequestMapping("/altaOrden")
    public ModelAndView altaOrden(EquipoForm eF) {
        ModelAndView mV = new ModelAndView("detalleObjeto");
        Equipo e = sE.buscarEquipo(eF.getId_equipo());
        OrdenFabricacion orden = sO.buscarOrden(eF.getCodigo_orden());
        e.addOrden(orden);
        //sE.actualizarEquipo(e);
        orden.setEstado(EstadoOrden.PENDIENTE);
        sO.actualizarOrden(orden);
        mV.addObject("objeto", orden);
        return mV;
    }

    /**
     * Metodo para mostrar el editor de equipos.
     * @return Devuelve un objeto ModelAndView (formulario) llamado equipoCrud
     * con un objeto vacio EquipoForm para introducir los datos a cambiar, o elimiar 
     * del equipo.
     */
    @RequestMapping("/administrar")
    public ModelAndView administrarEquipo() {
        return new ModelAndView("equipoCrud", "command", new EquipoForm());
    }
//, headers = {"Content-type=application/json"}
 /*     @RequestMapping(value = "/buscar", method = RequestMethod.POST)
     public @ResponseBody
     String buscaEquipo() {
     String str = "hola";

     return str;
     }*/

    /**
     * Metodo para buscar equipos en la base de datos.
     * @param eqForm objeto EquipoForm con los datos de los equipos a buscar.
     * @return Devuelve un String con los equipos que coinciden con los parámetros
     * del formulario.
     */
    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public @ResponseBody String buscaEquipo(@RequestBody EquipoForm eqForm) {
        String id_equipo = eqForm.getId_equipo();
        String nombre = eqForm.getNombre();
        String response = null;
        List<Equipo> eq = sE.listarEquipos("id_equipo", id_equipo, "nombre", nombre);
        if (eq != null) {
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(eq);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
        } else {
            response = null;
        }

        return response;
    }

    /**
     * Metodo para buscar trabajadores en la base de datos.
     * @param eqForm objeto EquipoForm con los datos del equipo.
     * @return Devuelve un objeto String con los datos de los trabajadores 
     * pertenecientes al equipo facilitado en el formulario.
     */
    @RequestMapping(value = "/trabajadores", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String devuelveTrabajadoresAjax(@RequestBody EquipoForm eqForm) {
        String id_equipo = eqForm.getId_equipo();
        String response = "";
        Equipo eq = sE.buscarEquipo(id_equipo);
        List<Trabajador> res = eq.getTrabajadores();
        if (res != null) {
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(res);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
        } else {
            response = null;
        }

        return response;
    }
    
    /**
     * Metodo para mostrar en una tabla los equipos de la base de datos.
     * @return Devuelve un objeto ModelAndView (vista) con los equipos de la
     * base de datos.
     */
    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sE.listarEquipos());
        return mV;
    }
}
