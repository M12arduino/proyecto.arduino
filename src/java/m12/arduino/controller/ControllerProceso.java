/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.domain.Accion;
import m12.arduino.domain.Proceso;

import m12.arduino.service.ProcesoForm;
import m12.arduino.service.ServiceProceso;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Couto
 */
@Controller
@RequestMapping("/proceso")
public class ControllerProceso {

    private ServiceProceso sP = new ServiceProceso();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("procesoAlta", "command", new ProcesoForm());
        return mV;
    }

    @RequestMapping(value = "/insertar")
    public ModelAndView addProceso(ProcesoForm pf) {
        System.out.println(pf.getAccionesJSON());
        ObjectMapper mapper = new ObjectMapper();
        List<Accion> acciones;
        Proceso aux = null;
        try {
            acciones = mapper.readValue(pf.getAccionesJSON(), new TypeReference<List<Accion>>() {});
            Proceso pro = new Proceso();
            pro.setCodigo(pf.getCodigo());
            pro.setDescripcion(pf.getDescripcion());
            pro.setAcciones(acciones);
            for (Accion accion : acciones) {
                accion.setProceso(pro);
            }
            aux = sP.insertarProceso(pro);
        } catch (IOException ex) {
            Logger.getLogger(ControllerProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModelAndView mV = new ModelAndView("detalleObjeto");
        mV.addObject("objeto",aux);
        return mV;
    }
    
    @RequestMapping(value="/actualizar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String actualizarProceso(@RequestBody ProcesoForm pf){
        String msg = "";
        try {
            Proceso p = sP.buscarProceso("id",pf.getId());
            p.setCodigo(pf.getCodigo());
            p.setDescripcion(pf.getDescripcion());
            List<Accion> acciones = pf.getAcciones();
            for (Accion acc : acciones){
                p.addAccion(acc);
            }
            sP.actualizarProceso(p);
            msg = "Proces updated";
        } catch (Exception e) {
            msg = "updated fail "+e.getMessage();
        }
        return msg;
    }
    
    @RequestMapping(value="/eliminar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String eliminarProceso(@RequestBody ProcesoForm pf){
        String msg = "";
        try {
            Proceso p = new Proceso();
            p = sP.buscarProceso(pf.getCodigo());
            sP.eliminarProceso(p);
            msg = "<div class=\"alert alert-succes\">El Proceso se ha eliminado correctamente</div>";
        } catch (ConstraintViolationException e) {
            msg = "<div class=\"alert alert-danger\">El Proceso no se pudo eliminar porque hay ordenes de fabricacion utilizandolo</div>";
        }
        return msg;
    }
    
    @RequestMapping(value = "/buscarProceso", method = RequestMethod.POST)
    public @ResponseBody String buscaProcesoAjax(@RequestBody ProcesoForm pf) {
        String codigo = pf.getCodigo();
        String descripcion = pf.getDescripcion();
        String response = "";
        List<Proceso> proc = sP.listarProcesos("codigo",codigo,"descripcion",descripcion);
        //List<Proceso> proc = sP.listarProcesos();
        try {
             ObjectMapper mapperObj = new ObjectMapper();
             response = mapperObj.writeValueAsString(proc);
        } catch (IOException ex) {
            response = ex.getMessage();
        } 

        return response;
    }
    
    @RequestMapping(value = "administrar")
    public ModelAndView administraCrudRobot() {
        ModelAndView mV = new ModelAndView("procesoCrud", "command", new ProcesoForm());
        return mV;
    }
    
    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sP.listarProcesos());
        return mV;
    }
}
