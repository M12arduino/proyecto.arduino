/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.IOException;
import java.util.List;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.EstadoRobot;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Trabajador;
import m12.arduino.domain.Ubicacion;
import m12.arduino.service.RobotForm;
import m12.arduino.service.ServiceRobot;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Couto
 */
@Controller
@RequestMapping("/robot")
public class ControllerRobot {

    private ServiceRobot sR = new ServiceRobot();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("robotAlta", "command", new RobotForm());
        mV.addObject("estados", EstadoRobot.values());
        return mV;
    }

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
            sR.insertarRobot(r);
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
        return new ModelAndView("welcome");

    }
    
    @RequestMapping(value="/actualizar")
    public ModelAndView actualizarRobot(RobotForm rf){
        
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
        } catch (Exception e) {
        }
        return new ModelAndView("welcome");
    }
    
    @RequestMapping(value="/eliminar")
    public ModelAndView eliminarRobot(RobotForm rf){
        try {
            Robot r = new Robot();
            r.setId(rf.getId());
//            r.setId_robot(rf.getId_robot());
//            r.setNombre(rf.getNombre());
//            r.getUbicacion().setLugar(rf.getLugar());
//            r.getUbicacion().setCoorX(rf.getCoorX());
//            r.getUbicacion().setCoorY(rf.getCoorY());
//            r.setEstado(rf.getEstado());
            sR.eliminarRobot(r);
        } catch (Exception e) {
        }
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/buscarRobot",headers = {"Content-type=application/json"}, method = RequestMethod.POST)
    public @ResponseBody String buscaRobotAjax(@RequestBody RobotForm robot) {
        String id_robot = robot.getId_robot();
        String nombre = robot.getNombre();
        String lugar = robot.getLugar();
        EstadoRobot estado = robot.getEstado();
        if (estado == EstadoRobot.INDEFINIDO) estado = null;
        String response = "";
        List<Robot> rob = sR.listarRobots("id_robot",id_robot,"nombre",nombre,"lugar",lugar,"estado",estado);
        
//        List<Trabajador> trab = sT.listarTrabajadores();
          //List<Robot> rob = sR.listarRobots();
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
}
