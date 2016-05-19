/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.HashMap;
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

    private final DaoRobotImpl dR = new DaoRobotImpl();

    public Robot buscarRobot(String nombre) {
        return dR.buscarRobot(nombre);
    }

    public Robot buscarRobot(Object... vars) {
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dR.buscarRobot(condiciones);
    }

    public List<Robot> listarRobots() {
        return dR.obtenerListaRobots();
    }

    public List<Robot> listarRobots(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dR.obtenerListaRobots(condiciones);
    }

    public boolean insertarRobot(Robot rob) {
        dR.guardarRobot(rob);
        return true;
    }

    public Robot actualizarEquipo(Robot rob) {
        return dR.actualizarRobot(rob);
    }
        public Map<String, Object> constructConditions(Object... str) {
        Map<String, Object> conditions = new TreeMap<String, Object>();
        for (int i = 0; i <= str.length - 2; i += 2) {
            if (str[i] != null & str[i + 1] != null) {
                if (!str[i].equals("") & !str[i + 1].equals("")) {
                    conditions.put((String) str[i], str[i + 1]);
                    System.out.println("I:" + str[i] + "i+1:" + str[i + 1]);
                }
            }
        }
        return conditions;
    }
}
