package m12.arduino.controller;

import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Prioridad;
import m12.arduino.service.OrdenFabricacionForm;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView addProceso(OrdenFabricacionForm ofF) {
        
        OrdenFabricacion oF = new OrdenFabricacion();
        oF.setCodigo(ofF.getCodigo());
        oF.setDescripcion(ofF.getDescripcion());
        oF.setProridad(ofF.getPrioridad());
        oF.setProceso(sP.buscarProceso(ofF.getCodigo_proceso()));
        oF.setCantidad(ofF.getCantidad());
        oF.setRobot(sR.buscarRobot(ofF.getNombre_robot()));
        sO.insertarOrden(oF);
        ModelAndView mV = new ModelAndView("ordenFabricacionDetalle");        
        mV.addObject("ordenFabricacion", oF);
        return mV;
    }
}
