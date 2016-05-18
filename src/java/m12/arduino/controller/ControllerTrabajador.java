package m12.arduino.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.dao.HibernateUtil;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Maketable;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.ServiceTrabajador;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Controller
@RequestMapping("/trabajador")
public class ControllerTrabajador {

    private ServiceTrabajador sT = new ServiceTrabajador();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("trabajadorAlta", "command", new Trabajador());
        mV.addObject("categorias", CategoriaTrabajador.values());
        return mV;
    }

    @RequestMapping(value = "/insertar")
    public ModelAndView addTrabajador(Trabajador trabajador) {

        try {
            sT.insertarTrabajador(trabajador);
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
        return new ModelAndView("welcome");

    }
    @RequestMapping(value="/administrar")
    public ModelAndView administrarTrabajador(){
        ModelAndView mV = new ModelAndView("trabajadorCrud","command",new Trabajador());
        mV.addObject("categorias",CategoriaTrabajador.values());
        return mV;
    }
    

    @RequestMapping(value = "/tabla")
    public ModelAndView printTable() {
        ModelAndView mV = new ModelAndView("trabajadorTabla");
        mV.addObject("listado", sT.listaTrabajadores());
        return mV;
    }
    @RequestMapping(value = "/buscar")
    public @ResponseBody String buscaTrabajadorAjax(@ModelAttribute("nif") String nif) {
        String response = "";
       Trabajador treb = sT.buscaTrabajador(nif);
        try {
            response= treb.toJson();
        } catch (IOException ex) {
            response = ex.getMessage();
        }
        return response;
    }

}
