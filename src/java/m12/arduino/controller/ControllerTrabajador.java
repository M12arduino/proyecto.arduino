package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.dao.HibernateUtil;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.Maketable;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceTrabajador;
import m12.arduino.service.TrabajadorCrudForm;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controlador para los objetos trabajador
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/trabajador")
public class ControllerTrabajador {

    private ServiceTrabajador sT = new ServiceTrabajador();
    private ServiceEquipo sE = new ServiceEquipo();
    
    /**
     * Metodo formulario de alta de Trabajadores
     * @return Devuelve un objeto ModelAndView (formulario) llamado trabajadorAlta con 
     * una lista de categorias y un objeto Trabajador vacio.
     */
    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("trabajadorAlta", "command", new Trabajador());
        mV.addObject("categorias", CategoriaTrabajador.values());
        return mV;
    }

    /**
     * Metodo para insertar trabajadores en la base de datos.
     * @param trabajador objeto Trabajador con los datos del trabajador a 
     * insertar en la base de datos.
     * @return Devuelve un objeto ModelAndView (vista) con los datos del 
     * trabajador insertado.
     */
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
    
    /**
     * Metodo para actualizar trabajadores de la base de datos.
     * @param tcf objeto TrabajadorCrudForm con los datos del trabajador a 
     * eliminar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value="/actualizar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String actualizarTrabajador(@RequestBody TrabajadorCrudForm tcf){
        String msg = "";
        try {
            Trabajador t = new Trabajador();
            t.setId_trab(tcf.getId_trab());
            t.setNif(tcf.getNif());
            t.setNombre(tcf.getNombre());
            t.setPassword(tcf.getPassword());
            t.setMovil(tcf.getMovil());
            t.setEquipo(tcf.getEquipo());
            t.setCategoria(tcf.getCategoria());
            sT.actualizarTrabajador(t);
            msg = "<div class=\"alert alert-success\">El empleado se ha actualizado correctamente</div>";
        } catch (Exception e) {
            msg = "<div class=\"alert alert-error\">Fallo al actualizar empleado</div>";
        }
        return msg;
    }
    
    /**
     * Metodo para eliminar trabajadores de la base de datos.
     * @param tcf objeto TrabajadorCrudForm con los datos del trabajador a 
     * eliminar de la base de datos.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value="/eliminar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String eliminarTrabajador(@RequestBody TrabajadorCrudForm tcf){
        String msg = "";
        try {
            Trabajador t = new Trabajador();
            t.setId_trab(tcf.getId_trab());
            sT.eliminarTrabajador(t);
            msg = "<div class=\"alert alert-success\">El empleado se ha eliminado correctamente</div>";
        } catch (Exception e) {
            msg = "<div class=\"alert alert-error\">Fallo al eliminar empleado</div>";
        }
        return msg;
    }
    
    /**
     * Metodo para mostrar el editor de trabajadores.
     * @return Devuelve un objeto ModelAndView (formulario) llamado trabajadorCrud
     * con un objeto vacio TrabajadorCrudForm para introducir los datos a cambiar, o elimiar 
     * del trabajador.
     */
    @RequestMapping(value="/administrar")
    public ModelAndView administrarTrabajador(){
        ModelAndView mV = new ModelAndView("trabajadorCrud","command",new TrabajadorCrudForm());
        mV.addObject("categorias",CategoriaTrabajador.values());
        return mV;
    }
    
    /**
     * Metodo para mostrar en una tabla los trabajadores de la base de datos.
     * @return Devuelve un objeto ModelAndView (vista) con los trabajadores de la
     * base de datos.
     */
    @RequestMapping(value = "/tabla")
    public ModelAndView printTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sT.listarTrabajadores());
        return mV;
    }
    
    /**
     * Metodo para buscar trabajadores en la base de datos.
     * @param trabajador objeto Trabajador con los datos de los trabajadores a
     * buscar.
     * @return Devuelve un String con los trabajadores que coinciden con los 
     * parámetros del formulario.
     */
    @RequestMapping(value = "/buscar",method = RequestMethod.POST)
    public @ResponseBody String buscaTrabajadorAjax(@RequestBody Trabajador trabajador) {
        String nif = trabajador.getNif();
        String nombre = trabajador.getNombre();
        CategoriaTrabajador categoria = trabajador.getCategoria();
        if (categoria == CategoriaTrabajador.INDEFINIDO) categoria = null;
        String response = null;
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
    
    
//    @RequestMapping(value = "/trabajadores",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
//    public @ResponseBody String listaTrabajadorAjax() {
//        String response = "";
//        List<Trabajador> trab = sT.listarTrabajadores();
//        if(trab !=null){
//        try {
//             ObjectMapper mapperObj = new ObjectMapper();
//             response = mapperObj.writeValueAsString(trab);
//        } catch (IOException ex) {
//            response = ex.getMessage();
//        } 
//        }else{
//            response = null;
//        }
//
//        return response;
//    }

    /**
     * Metodo formulario de perfil.
     * @return Devuelve un objeto ModelAndView (formulario) con los datos del trabajador 
     * logueado y un objeto TrabajadorCrudFoem vacio.
     */
    @RequestMapping(value = "/miPerfil")
    public ModelAndView miPerfil() {
        ModelAndView mV = new ModelAndView("PerfilUsuario", "command", new TrabajadorCrudForm());
        String myName = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabajador trab = sT.buscarTrabajador(myName);
        mV.addObject("myTrab", trab);
        return mV;
    }

    /**
     * Metodo para la actualización de perfil.
     * @param tcf objeto TrabajadorCrudForm con los datos a actualizar en el 
     * perfil.
     * @return Devuelve un objeto ModelAndView (vista) te redirije a la home
     * después de actualizar los datos.
     */
    @RequestMapping(value = "/actualizarPerfil", method = RequestMethod.POST)
    public ModelAndView actualizarPerfil(TrabajadorCrudForm tcf) {
        ModelAndView mV = new ModelAndView("main");
 
        Trabajador t = new Trabajador();
        t.setId_trab(tcf.getId_trab());
        t.setNif(tcf.getNif());
        t.setNombre(tcf.getNombre());
        t.setPassword(tcf.getPassword());
        t.setMovil(tcf.getMovil());
        t.setEquipo(sE.buscarEquipo(tcf.getId_equipo()));
        t.setCategoria(tcf.getCategoria());
        
        sT.actualizarTrabajador(t);

        return mV;
    }
}   
