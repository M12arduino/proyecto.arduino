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
     * Metodo formulario de alta
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
     * 
     * @param eq es un formulario EquipoForm con los datos del Equipo a insertar
     * @return 
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

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarEquipo(@RequestBody EquipoForm eqForm) {
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
        } catch (Exception e) {
            response = "<div class=\"alert alert-error\">Ha habido un problema al actualizar el equipo</div>";
        }
        return response;
    }

    @RequestMapping(value = "/eliminar", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody
    String eliminarEquipo(@RequestBody EquipoForm eqForm) {
        String msg = "";
        try {
            Equipo eq = new Equipo();
            eq = sE.buscarEquipo(eqForm.getId_equipo());
            for (Trabajador trab : eq.getTrabajadores()) {
                trab.setEquipo(null);
                sT.actualizarTrabajador(trab);
            }
            sE.eliminarEquipo(eq);
            msg = "equipo eliminado";
        } catch (Exception e) {
            msg = "fallo al eliminar equipo " + e.getMessage();
        }
        return msg;
    }

    @RequestMapping("/asignarOrden")
    public ModelAndView asignarOrden() {
        EquipoForm eF = new EquipoForm();
        ModelAndView mV = new ModelAndView("equipoAsignarOrden", "command", eF);
        mV.addObject("equipos", sE.listarEquipos());
        mV.addObject("ordenes", sO.listarOrdenes("estado", EstadoOrden.INDEFINIDO)); // Nomes es poden assignar ordres no assignades anteriorment (Indefinido)
        return mV;
    }

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

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public @ResponseBody
    String buscaEquipo(@RequestBody EquipoForm eqForm) {
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

    @RequestMapping(value = "/trabajadores", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody
    String devuelveTrabajadoresAjax(@RequestBody EquipoForm eqForm) {
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
    
    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sE.listarEquipos());
        return mV;
    }
}
