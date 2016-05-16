package m12.arduino.controller;

import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.ServiceTrabajador;
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

    @RequestMapping("/trabajador/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("trabajadorAlta","command",new Trabajador());
        mV.addObject("categorias", CategoriaTrabajador.values());
        return mV;
    }

    @RequestMapping(value = "/darAltaTrabajador", method = {RequestMethod.POST})
    public void addTrabajador(Trabajador trabajador, ModelMap model) {
        ServiceTrabajador.insertarTrabajador(trabajador);
    }
    
}
