package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Prioridad;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.OrdenFabricacionForm;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
@Controller
@RequestMapping("/ordenFabricacion")
public class ControllerOrdenFabricacion {
    
    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private ServiceProceso sP = new ServiceProceso();
    private ServiceRobot sR = new ServiceRobot();
    
    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("ordenFabricacionAlta", "command", new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        return mV;
    }
    
    @RequestMapping(value = "/insertar")
    public ModelAndView addOrden(OrdenFabricacionForm ofF) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        OrdenFabricacion oF = new OrdenFabricacion();
        oF.setCodigo(ofF.getCodigo());
        oF.setDescripcion(ofF.getDescripcion());
        oF.setProridad(ofF.getPrioridad());
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        oF.setProceso(sP.buscarProceso(ofF.getCodigo_proceso()));
        oF.setCantidad(ofF.getCantidad());
        System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        oF.setRobot(sR.buscarRobot(ofF.getId_robot()));
        System.out.println("0000000000000000000000000000000000000000");
        OrdenFabricacion orden = sO.insertarOrden(oF);
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        ModelAndView mV = new ModelAndView("ordenFabricacionDetalle");        
        mV.addObject("ordenFabricacion", orden);
        return mV;
    }
    
    @RequestMapping(value="/actualizar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String actualizarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF){
        String msg = "";
        try {
            OrdenFabricacion of = new OrdenFabricacion();
            of.setId(ofF.getId());
            of.setCodigo(ofF.getCodigo());
            of.setDescripcion(ofF.getDescripcion());
            of.setCantidad(ofF.getCantidad());
            of.setProceso(sP.buscarProceso(ofF.getCodigo_proceso()));
            of.setProridad(ofF.getPrioridad());
            of.setRobot(sR.buscarRobot(ofF.getId_robot()));
            sO.actualizarOrden(of);
            msg = "Fabrication Order updated";
        } catch (Exception e) {
            msg = "updated fail "+e.getMessage();
        }
        return msg;
    }
    
    @RequestMapping(value="/eliminar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String eliminarOrdenFabricacion(@RequestBody OrdenFabricacionForm ofF){
        String msg = "";
        try {
            OrdenFabricacion of = new OrdenFabricacion();
            of.setId(ofF.getId());
            sO.eliminarOrden(of);
            msg = "Fabrication Order deleted";
        } catch (Exception e) {
            msg = "delete fail "+e.getMessage();
        }
        return msg;
    }
    
    @RequestMapping(value="/administrar")
    public ModelAndView administrarOrdenFabricacion(){
        ModelAndView mV = new ModelAndView("ordenFabricacionCrud","command",new OrdenFabricacionForm());
        mV.addObject("prioridades", Prioridad.values());
        mV.addObject("procesos", sP.listarProcesos());
        mV.addObject("robots", sR.listarRobots());
        return mV;
    }
    
    @RequestMapping(value = "/buscar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String buscaOrdenFabricacionAjax(@RequestBody OrdenFabricacionForm ofF) {
        String codigo = ofF.getCodigo();
        String descripcion = ofF.getDescripcion();
        Prioridad prioridad = ofF.getPrioridad();
        if (prioridad == Prioridad.INDEFINIDO) prioridad = null;
        String response = null;
        //List<OrdenFabricacion> OF = sO.listarOrdenes("codigo",codigo,"descripcion",descripcion);
        List<OrdenFabricacion> OF = sO.listarOrdenes();
        if(OF !=null){
        try {
            ObjectMapper mapperObj = new ObjectMapper();
            response = mapperObj.writeValueAsString(OF);
            System.out.println("Response: "+response);
        } catch (IOException ex) {
            response = ex.getMessage();
        } 
        }else{
            response = null;
        }

        return response;
    }
}
