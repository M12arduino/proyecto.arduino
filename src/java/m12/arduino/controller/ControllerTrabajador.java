package m12.arduino.controller;

import m12.arduino.domain.Trabajador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Controller
public class ControllerTrabajador {

    @RequestMapping("/trabajador/form")
    public ModelAndView formularioInicial() {
        System.out.println("In form inicial");
        //return "trabajadorAlta";
        ModelAndView model =  new ModelAndView("trabajadorAlta", "trabajador", new Trabajador());
        return model;
    }
    @RequestMapping("/trabajador/id")
    public ModelAndView formularioInicia2l() {
        System.out.println("In form inicial");
        //return "trabajadorAlta";
        ModelAndView model =  new ModelAndView("welcome", "command", new Trabajador());
        return model;
    }

    @RequestMapping(value = "/darAltaTrabajador", method = RequestMethod.POST)
    public String addTrabajador(Trabajador trabajador, ModelMap model) {
        System.out.println("In post" + trabajador.getNombre());
        model.addAttribute("trabajador", trabajador);
        return "trabajadorDetalle.htm";
    }

}
