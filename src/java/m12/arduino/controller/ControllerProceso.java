/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import m12.arduino.domain.Accion;

import m12.arduino.service.ProcesoForm;
import m12.arduino.service.ServiceProceso;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Couto
 */
@Controller
@RequestMapping("/proceso")
public class ControllerProceso {

    private ServiceProceso sP = new ServiceProceso();

    @RequestMapping("/alta")
    public ModelAndView formularioInicial() {
        ModelAndView mV = new ModelAndView("procesoAlta", "command", new ProcesoForm());
        return mV;
    }

    @RequestMapping(value = "/insertar")
    public String addProceso(ProcesoForm pf) {
        System.out.println(pf.getAccionesJSON());
        ObjectMapper mapper = new ObjectMapper();

        List<Accion> acciones = null;
        try {
            acciones = mapper.readValue(pf.getAccionesJSON(), new TypeReference<List<Accion>>(){});
        } catch (IOException ex) {
            Logger.getLogger(ControllerProceso.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        for (Accion accion : acciones) {
            System.out.println(accion.toString());
        }
        return "welcome";
    }

}
