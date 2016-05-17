/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;
import m12.arduino.dao.DaoRobotImpl;
import m12.arduino.domain.Robot;


/**
 *
 * @author couto
 */
public class ServiceRobot {
    
    private DaoRobotImpl dR = new DaoRobotImpl();
    
    public boolean insertarRobot(Robot rob) {
        Robot auxRob = this.dR.buscarRobot(rob.getNombre());
        if (auxRob == null) {
            Robot aux = dR.guardaActualizaRobot(rob);
            if (aux == null) return false; else return true;
        } else {
            return false;
        }
    }
    
    public List<Robot> listaRobot(){
        return dR.obtenListaRobot();
    }
    
}
