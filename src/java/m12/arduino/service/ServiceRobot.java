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
 * Clase ServiceRobot que se apoya en la clase DaoRobotImpl
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ServiceRobot {

    /**
     * Objeto DaoRobotImpl para el trato de datos
     */
    private final DaoRobotImpl dR = new DaoRobotImpl();

    /**
     * Metodo para buscar un robot por identificador de robot.
     * @param id_robot String con el id_robot del robot a buscar.
     * @return Devuelve un Objeto Robot correspondiente al id_robot proporcionado.
     */
    public Robot buscarRobot(String id_robot) {
        return dR.buscarRobot(id_robot);
    }

    /**
     * Metodo para buscar un robot por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un Objeto Robot que corresponde con los parametros proporcionados.
     */
    public Robot buscarRobot(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dR.buscarRobot(condiciones);
    }

    /**
     * Metodo para listar los robots.
     * @return Devuelve un Objeto List con los robots.
     */
    public List<Robot> listarRobots() {
        return dR.obtenerListaRobots();
    }

    /**
     * Metodo para listar los robots filtrados por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un objeto List de los robots que coinciden con los 
     * parametros proporcionados.
     */
    public List<Robot> listarRobots(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dR.obtenerListaRobots(condiciones);
    }

    /**
     * Metodo para insertar robots.
     * @param rob objeto Robot a insertar.
     * @return Devuelve el objeto Robot insertado.
     */
    public Robot insertarRobot(Robot rob) {
        return dR.guardarRobot(rob);
    }

    /**
     * Metodo para actualizar un robot.
     * @param rob objeto Robot a actualizar.
     * @return Devuelve el objeto Robot actualizado.
     */
    public Robot actualizarRobot(Robot rob) {
        return dR.actualizarRobot(rob);
    }
    
    /**
     * Metodo para eliminar un robot.
     * @param rob objeto Robot a eliminar.
     */
    public void eliminarRobot(Robot rob) {
        dR.eliminarRobot(rob);
    }

    /**
     * Metodo que construye el Map a partir de los parametros que recibe
     * @param str parametros de busqueda
     * @return Devuelve un objeto Map hecho a partir de los parametros
     */
    public Map<String, Object> constructConditions(Object... str) {
        Map<String, Object> conditions = new HashMap<String, Object>();
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
