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

    @RequestMapping("/main")
    public String initMenu() {
        if (true) {
            return "login";
        } else {
            return "main";
        }
    }

    @RequestMapping(value = "/admin")//, method = RequestMethod.GET)
    public String adminPage() {

        return "welcome";
    }

    @RequestMapping(value = "/accesDenegat")//, method = RequestMethod.GET)
    public String novaPage() {

        return "accesDenegat";
    }

    @RequestMapping(value = "/usuariRegistrat")//, method = RequestMethod.GET)
    public String usuariRegistratPage() {

        return "usuariRegistrat";
    }

}
