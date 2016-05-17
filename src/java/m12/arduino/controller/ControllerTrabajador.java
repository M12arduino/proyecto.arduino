package m12.arduino.controller;

import m12.arduino.dao.HibernateUtil;
import m12.arduino.domain.CategoriaTrabajador;
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
        ModelAndView mV = new ModelAndView("trabajadorAlta","command",new Trabajador());
        mV.addObject("categorias", CategoriaTrabajador.values());
        return mV;
    }

    
    @RequestMapping(value = "/insertar")
   public ModelAndView addTrabajador(Trabajador trabajador) {
       try{
           sT.insertarTrabajador(trabajador);
       }catch(HibernateException he){
           System.out.println(he.getMessage());
       }
        return new ModelAndView("welcome");
         
    }
    /*@ResponseBody
    @RequestMapping(value = "/search/api/getSearchResult")
    public AjaxResponseBody buscaTrabajadorAjax(@RequestBody String nif) {
	AjaxResponseBody result = new AjaxResponseBody();
	return result;

    }
    
   @RequestMapping(value= "/editar")
   public ModelAndView editTrabajador(){
       
       return new ModelAndView("t")
   }*/
    
}
