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
            Proceso p = new Proceso();
            p.setId(pf.getId());
            p.setCodigo(pf.getCodigo());
            p.setDescripcion(pf.getDescripcion());
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
            p.setId(pf.getId());
            sP.eliminarProceso(p);
            msg = "Proces deleted";
        } catch (Exception e) {
            msg = "delete fail "+e.getMessage();
        }
        return msg;
    }
    
    @RequestMapping(value = "/buscarProceso", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String buscaProcesoAjax(@RequestBody ProcesoForm pf) {
        String codigo = pf.getCodigo();
        System.out.println("codigo");
        String descripcion = pf.getDescripcion();
        String response = null;
        //List<Proceso> proc = sP.listarProcesos("codigo",codigo,"descripcion",descripcion);
        List<Proceso> proc = sP.listarProcesos();
        if(proc != null){
            System.out.println("not null");
        try {
             ObjectMapper mapperObj = new ObjectMapper();
             response = mapperObj.writeValueAsString(proc);
        } catch (IOException ex) {
            response = ex.getMessage();
        } 
        }else{
            System.out.println("null");
            response = null;
        }

        return response;
    }
    
    @RequestMapping(value = "administrar")
    public ModelAndView administraCrudRobot() {
        ModelAndView mV = new ModelAndView("procesoCrud", "command", new ProcesoForm());
        return mV;
    }
}
