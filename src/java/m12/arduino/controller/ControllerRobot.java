/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Ubicacion;
import m12.arduino.service.RobotForm;
import m12.arduino.service.ServiceRobot;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Couto
 */
@Controller
@RequestMapping("/robot")
public class ControllerRobot {
    
    private ServiceRobot sR = new ServiceRobot();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("robotAlta","command",new RobotForm());
        mV.addObject("estados", EstadoRobot.values());
        return mV;
    }

    
    @RequestMapping(value = "/insertar")
   public ModelAndView addRobot(RobotForm rf) {
       try{
           Robot r = new Robot();
           r.setNombre(rf.getNombre());
           r.getUbicacion().setLugar(rf.getLugar());
           r.getUbicacion().setCoorX(rf.getCoorX());
           r.getUbicacion().setCoorY(rf.getCoorY());
           r.setEstado(rf.getEstado());
           sR.insertarRobot(r);
       }catch(HibernateException he){
           System.out.println(he.getMessage());
       }
        return new ModelAndView("welcome");
         
    }
    
}
