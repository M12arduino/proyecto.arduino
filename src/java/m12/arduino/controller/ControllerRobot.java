/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.OrdenFabricacion;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Ubicacion;
import m12.arduino.service.RobotForm;
import m12.arduino.service.ServiceRobot;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para los objetos robot
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/robot")
public class ControllerRobot {

    private ServiceRobot sR = new ServiceRobot();

    /**
     * Metodo formulario de alta de robots.
     * @return Devuelve un objeto ModelAndView (formulario) llamado robotAlta con 
     * un objeto RobotForm vacio.
     */
    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("robotAlta", "command", new RobotForm());
        mV.addObject("estados", EstadoRobot.values());
        return mV;
    }

    /**
     * Metodo para insertar robots en la base de datos.
     * @param rf Objeto RobotForm con los datos del robot a insertar.
     * @return Devuelve un objeto ModelAndView (vista) llamado detalleObjeto 
     * con los datos del robot insertado.
     */
    @RequestMapping(value = "/insertar")
    public ModelAndView addRobot(RobotForm rf) {
        try {
            Robot r = new Robot();
            r.setId_robot(rf.getId_robot());
            r.setNombre(rf.getNombre());
            r.getUbicacion().setLugar(rf.getLugar());
            r.getUbicacion().setCoorX(rf.getCoorX());
            r.getUbicacion().setCoorY(rf.getCoorY());
            r.setEstado(rf.getEstado());
            Robot rob = sR.insertarRobot(r);
            ModelAndView mV = new ModelAndView("detalleObjeto");
            mV.addObject("objeto", rob);
            return mV;
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            return new ModelAndView("error");
        }
    }
    
    /**
     * Metodo para actualizar robots de la base de datos.
     * @param rf objeto RobotForm con los datos del robot a actualizar.
     * @return Devuelve un String metido en un div con la confirmación de como 
     * ha finalizado la operación.
     */
    @RequestMapping(value="/actualizar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String actualizarRobot(@RequestBody RobotForm rf){
        String msg = "";
        try {
            Robot r = new Robot();
            r.setId(rf.getId());
            r.setId_robot(rf.getId_robot());
            r.setNombre(rf.getNombre());
            r.getUbicacion().setLugar(rf.getLugar());
            r.getUbicacion().setCoorX(rf.getCoorX());
            r.getUbicacion().setCoorY(rf.getCoorY());
            r.setEstado(rf.getEstado());
            sR.actualizarRobot(r);
            msg = "<div class=\"alert alert-success\">El Robot se ha actualizado correctamente</div>";
        } catch (Exception e) {
            msg = "<div class=\"alert alert-danger\">Error al actualizar Robot</div>";
        }
        return msg;
    }
    
    /**
     * Metodo para eliminar robots de la base de datos.
     * @param rf objeto RobotForm con los datos del robot a eliminar.
     * @return Devuelve un String metido en un div con la confirmación de como
     * ha finalizado la operación.
     */
    @RequestMapping(value="/eliminar",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String eliminarRobot(@RequestBody RobotForm rf){
        String msg = "";
        try {
            Robot r = new Robot();
            r.setId(rf.getId());
            sR.eliminarRobot(r);
            msg = "<div class=\"alert alert-success\">El Robot se ha eliminado correctamente</div>";;
        } catch (ConstraintViolationException e) {
            msg = "<div class=\"alert alert-danger\">Error al eliminar Robot, esta siendo usado en alguna orden</div>";
        }
        return msg;
    }
 
    /**
     * Metodo para buscar robots en la base de datos.
     * @param rf objeto RobotForm con los datos del robot a eliminar.
     * @return Devuelve un String con los procesos que coinciden con los 
     * parámetros del formulario.
     */
    @RequestMapping(value = "/buscarRobot", method = RequestMethod.POST)
    public @ResponseBody String buscaRobotAjax(@RequestBody RobotForm rf) {
        String id_robot = rf.getId_robot();
        String nombre = rf.getNombre();
        String lugar = rf.getLugar();
        EstadoRobot estado = rf.getEstado();
        if (estado == EstadoRobot.INDEFINIDO) estado = null;
        String response = null;
        List<Robot> rob = sR.listarRobots("id_robot",id_robot,"nombre",nombre,"lugar",lugar,"estado",estado);
        if(rob !=null){
                   try {
             ObjectMapper mapperObj = new ObjectMapper();
             response = mapperObj.writeValueAsString(rob);
        } catch (IOException ex) {
            response = ex.getMessage();
        } 
        }else{
            response = null;
        }

        return response;
    }

    /**
     * Metodo para mostrar el editor de robots.
     * @return Devuelve un objeto ModelAndView (formulario) llamado robotCrud
     * con un objeto vacio RobotForm para introducir los datos a cambiar, o elimiar 
     * del robot.
     */
    @RequestMapping(value = "administrar")
    public ModelAndView administraCrudRobot() {
        ModelAndView mV = new ModelAndView("robotCrud", "command", new RobotForm());
        mV.addObject("estados", EstadoRobot.values());
        return mV;
    }

    /*@RequestMapping(value = "/buscar", headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody
    String buscaRobotAjax(@RequestBody Robot robot) {
        String id_robot = robot.getId_robot();
        String nombre = trabajador.getNombre();
        CategoriaTrabajador categoria = trabajador.getCategoria();
        if (categoria == CategoriaTrabajador.INDEFINIDO) {
            categoria = null;
        }
        String response = "";
        List<Robot> trab = sR.listarRobots("nif", nif, "nombre", nombre, "categoria", categoria);
        //List<Trabajador> trab = sT.listarTrabajadores();
        if (trab != null) {
            try {
                ObjectMapper mapperObj = new ObjectMapper();
                response = mapperObj.writeValueAsString(trab);
            } catch (IOException ex) {
                response = ex.getMessage();
            }
        } else {
            response = null;
        }

        return response;
    }*/
    
    // TO DELETE IN THE FUTURE
//    @RequestMapping("/detalleList")
//    public ModelAndView detalleList() {
//        Robot r = sR.buscarRobot("Rob00");
//        String str = "";
//        for (OrdenFabricacion orden : r.getOrdenes()) {
//            str += orden.toString() + "<br />";
//        }
//        ModelAndView mV = new ModelAndView("robotDetalle");
//        mV.addObject("string", str);
//        return mV;
//    }
    
    /**
     * Metodo para mostrar en una tabla los robots de la base de datos.
     * @return Devuelve un objeto ModelAndView (vista) con los robots de la
     * base de datos.
     */
    @RequestMapping("/tabla")
    public ModelAndView makeTable() {
        ModelAndView mV = new ModelAndView("tableMaker");
        mV.addObject("listado", sR.listarRobots());
        return mV;
    }
}
