/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import m12.arduino.domain.Equipo;
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
    
    @RequestMapping("alta")
    public ModelAndView initFormAlta(){
        ModelAndView mV = new ModelAndView("equipoAlta","command",new Equipo());
        return mV;
    }
    
    @RequestMapping("insertar")
    public ModelAndView insertarEquipo(){
        
        return new ModelAndView("welcome");
    }
    
}
