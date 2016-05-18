/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
            if (aux == null) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Robot buscarRobotByX(Object... params) {
        Map<String,Object> conditions = constructConditions(params);
        Robot res = new Robot();
        try {
            res = dR.buscarRobotByX(conditions);
        } catch (Exception e) {
            System.out.println("fail");
        }
        return res;
    }
 
    public List<Robot> listaRobot() {
        return dR.obtenListaRobot();
    }

    public Map<String, Object> constructConditions(Object... str) {
        Map<String, Object> conditions = new TreeMap<String, Object>();
        for (int i = 0; i < str.length - 1; i += 2) {
            if (str[i] != null & !str[i].equals("") & str[i + 1] != null & !str[i + 1].equals("")) {
                conditions.put((String) str[i], str[i + 1]);
            }
            i++;
        }
        return conditions;
    }
}
