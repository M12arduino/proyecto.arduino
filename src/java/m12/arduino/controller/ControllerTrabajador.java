package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.dao.HibernateUtil;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Maketable;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.ServiceTrabajador;
import m12.arduino.service.TrabajadorCrudForm;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        Trabajador aux = null;
        try {
            aux = sT.insertarTrabajador(trabajador);
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
        ModelAndView mV = new ModelAndView("detalleObjeto");
        mV.addObject("objeto",aux);
        return mV;

    }
    @RequestMapping(value="/actualizar")
    public ModelAndView actualizarTrabajador(Trabajador trabajador){
        
        try {
            sT.actualizarTrabajador(trabajador);
        } catch (Exception e) {
        }
        return new ModelAndView("welcome");
    }
    
    @RequestMapping(value="/eliminar")
    public ModelAndView eliminarTrabajador(Trabajador trabajador){
        try {
            sT.eliminarTrabajador(trabajador);
        } catch (Exception e) {
        }
        return new ModelAndView("welcome");
    }
    @RequestMapping(value="/administrar")
    public ModelAndView administrarTrabajador(){
        ModelAndView mV = new ModelAndView("trabajadorCrud","command",new TrabajadorCrudForm());
        mV.addObject("categorias",CategoriaTrabajador.values());
        return mV;
    }
    @RequestMapping(value = "/tabla")
    public ModelAndView printTable() {
        ModelAndView mV = new ModelAndView("trabajadorTabla");
        mV.addObject("listado", sT.listarTrabajadores());
        return mV;
    }
    @RequestMapping(value = "/buscar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String buscaTrabajadorAjax(@RequestBody Trabajador trabajador) {
        String nif = trabajador.getNif();
        String nombre = trabajador.getNombre();
        CategoriaTrabajador categoria = trabajador.getCategoria();
        if (categoria == CategoriaTrabajador.INDEFINIDO) categoria = null;
        String response = "";
        List<Trabajador> trab = sT.listarTrabajadores("nif",nif,"nombre",nombre,"categoria",categoria);
        //List<Trabajador> trab = sT.listarTrabajadores();
        if(trab !=null){
        try {
             ObjectMapper mapperObj = new ObjectMapper();
             response = mapperObj.writeValueAsString(trab);
        } catch (IOException ex) {
            response = ex.getMessage();
        } 
        }else{
            response = null;
        }

        return response;
    }

}
