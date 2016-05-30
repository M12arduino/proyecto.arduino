/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;


import m12.arduino.domain.Maketable;
import m12.arduino.service.ServiceEquipo;
import m12.arduino.service.ServiceOrdenFabricacion;
import m12.arduino.service.ServiceProceso;
import m12.arduino.service.ServiceRobot;
import m12.arduino.service.ServiceTrabajador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para para las vistas detalle.
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/detalle")
public class ControllerDetalle {

    private ServiceTrabajador sT = new ServiceTrabajador();
    private ServiceEquipo sE = new ServiceEquipo();
    private ServiceOrdenFabricacion sO = new ServiceOrdenFabricacion();
    private ServiceProceso sP = new ServiceProceso();
    private ServiceRobot sR = new ServiceRobot();

    /**
     * Metodo que muestra la vista detalle.
     * @param unique atributo unico para la busqueda en la base de datos.
     * @param type tipo de objeto a buscar.
     * @return Devuelve un objeto ModelAndView (vista) llamado detalleObjetoTabla
     * con los detalles del objeto buscado.
     */
    @RequestMapping(value=("/detalle"), method = RequestMethod.GET)
    public ModelAndView mostrarDetalle(@RequestParam Long unique, @RequestParam String type) {
        Long pk = unique;
        Character tObj = type.charAt(0);
        ModelAndView mV = new ModelAndView("detalleObjetoTabla");
        Maketable m = null;
        switch (tObj) {
            case 'T':
                System.out.println("SE FORMO LA GOSADEEERAA");
                m = sT.buscarTrabajador("id_trab", pk);
                break;
            case 'E':
                m = sE.buscarEquipo("id", pk);
                break;
            case 'O':
                m = sO.buscarOrden("id", pk);
                break;
            case 'P':
                m = sP.buscarProceso("id", pk);
                break;
            case 'R':
                m = sR.buscarRobot("id", pk);
                break;

        }
        mV.addObject("objeto", m);
        return mV;
    }

}
