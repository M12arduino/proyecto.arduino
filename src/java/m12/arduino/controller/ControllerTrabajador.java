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
//@RequestMapping(value="/formTrabajadorAlta.htm")
public class ControllerTrabajador {

    @RequestMapping(method = RequestMethod.GET)
    public void inicio(ModelMap model) {
        Trabajador trab = new Trabajador();
        model.addAttribute("trabajadorForm", trab);
        System.out.println("In get");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addTrabajador(@ModelAttribute("trabajadorForm")Trabajador trabajador,ModelMap model) {
        System.out.println("In post" + trabajador.getNombre());
        return "trabajadorDetalle.htm";
    }
    
}
