/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.Robot;
import m12.arduino.service.ProcesoForm;
import m12.arduino.service.ServiceProceso;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ModelAndView mV = new ModelAndView("procesoAlta","command",new ProcesoForm());
        return mV;
    }

    
    @RequestMapping(value = "/insertar")
   public ModelAndView addProceso(ProcesoForm pf) {
       try{
       }catch(HibernateException he){
           System.out.println(he.getMessage());
       }
        return new ModelAndView("welcome");
         
    }
    
}

