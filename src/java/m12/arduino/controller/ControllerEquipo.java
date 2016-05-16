/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;


import java.util.ArrayList;
import java.util.List;
import m12.arduino.dao.DaoTrabajadorImpl;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceTrabajador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author enric
 */
@Controller
@RequestMapping("/equipo")
public class ControllerEquipo {
    
    private ServiceTrabajador sT = new ServiceTrabajador();
    private ServiceEquipo sE = new ServiceEquipo();
    
    @RequestMapping("alta")
    public ModelAndView initFormAlta(){
        ModelAndView mV = new ModelAndView("equipoAlta","command",new Equipo());
       // System.out.println(dT.obtenListaTrabajador());
        mV.addObject("listaTrabajadores", sT.listaTrabajador());
        return mV;
    }
    
    @RequestMapping("insertar")
    public ModelAndView insertarEquipo(Equipo eq){
        System.out.println(eq);
        sE.insertarEquipo(eq);
        return new ModelAndView("welcome");
    }
    
}
