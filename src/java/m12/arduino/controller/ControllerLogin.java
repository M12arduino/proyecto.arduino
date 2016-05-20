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

    @RequestMapping("/login")
    public String initSesion() {
        return "login";

    }
    
    @RequestMapping("/invalidCredentials")
    public String errorLogin() {
        return "invalidCredentials";

    }
    
    @RequestMapping("/main")
    public String initMenu() {
        return "main";

    }

    @RequestMapping(value = "/admin")
    public String adminPage() {

        return "welcome";
    }

}
