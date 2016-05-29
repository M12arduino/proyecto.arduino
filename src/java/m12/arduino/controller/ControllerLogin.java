package m12.arduino.controller;

import m12.arduino.domain.Trabajador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 * Controlador para el login
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
public class ControllerLogin {

    /**
     * Metodo de control de logueo (no logueado)
     * @return Devuelve un String "login" que es interpretado por el archivo
     * security y redirige a la pantalla login.
     */
    @RequestMapping("/login")
    public String initSesion() {
        return "login";

    }
    
    /**
     * Metodo de control de logueo (no autorizado)
     * @return Devuelve un String "invalidCredentials" que es interpretado por el archivo
     * security y redirige a la pantalla invalidCredentials.
     */
    @RequestMapping("/invalidCredentials")
    public String errorLogin() {
        return "invalidCredentials";

    }
    
    /**
     * Metodo de control de logueo (autorizado nivel usuario)
     * @return Devuelve un String "main" que es interpretado por el archivo
     * security y redirige a la pantalla main.
     */
    @RequestMapping("/main")
    public String initMenu() {
        return "main";

    }

    /**
     * Metodo de control de logueo (autorizado nivel administrador)
     * @return Devuelve un String "admin" que es interpretado por el archivo
     * security y redirige a la pantalla welcome.
     */
    @RequestMapping(value = "/admin")
    public String adminPage() {

        return "welcome";
    }

}
