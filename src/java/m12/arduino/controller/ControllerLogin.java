package m12.arduino.controller;

import m12.arduino.domain.Trabajador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/

@Controller
public class ControllerLogin {
    
    @RequestMapping("/index")
    public ModelAndView initForm(){
        //Trabajador trab = new Trabajador();
        return new ModelAndView("welcome"); 
            
    }
    
    @RequestMapping("/main")
    public ModelAndView initMenu(){
        return new ModelAndView("main");
    }
    
    @RequestMapping("/login/auth")
    public ModelAndView loginAuth(){
        //Trabajador trab = new Trabajador();
        return new ModelAndView("welcome"); 
            
    }
    
    @RequestMapping(value="trabajadorDetalle",method = RequestMethod.POST)
    public String addTrabajador(@ModelAttribute("trabajadorForm")Trabajador trabajador,ModelMap model){
        
        
        return "trabajadorDetalle";
    }
}
