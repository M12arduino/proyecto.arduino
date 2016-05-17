/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;


import java.util.ArrayList;
import java.util.List;
import m12.arduino.dao.DaoTrabajadorImpl;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.Trabajador;
import m12.arduino.service.EquipoForm;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceTrabajador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author enric
 */
@Controller
@RequestMapping("/equipo")
public class ControllerEquipo {
    
    private ServiceTrabajador sT = new ServiceTrabajador();
    private ServiceEquipo sE = new ServiceEquipo();
    
    @RequestMapping("alta")
    public ModelAndView initFormAlta(){
        ModelAndView mV = new ModelAndView("equipoAlta","command",new EquipoForm());
        mV.addObject("listaTrabajadores", sT.listaTrabajador());
        return mV;
    }
    
    @RequestMapping("insertar")
    public ModelAndView insertarEquipo(EquipoForm eq){
        Equipo res = new Equipo();
        Trabajador treb = new Trabajador(); 
        res.setId_equipo(eq.getId_equipo());
        res.setNombre(eq.getNombre());
        //Insertar equipo para generar un ID
        sE.insertarEquipo(res);
        //Recuperar objeto Equipo con ID generado
        res = sE.buscarEquipo(eq.getNombre());
        for (String str : eq.getNifs()){         
            //Buscar trabajador segun datos del formulario
            treb = sT.buscaTrabajador(str);
            //Programacion defensiva
            res.addTrabajador(treb);
            //Actualizar Trabajador
            sT.actualizaTrabajdor(treb);
        }
        
        return new ModelAndView("welcome");
    }
    
}
