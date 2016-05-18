/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Robot;

/**
 *
 * @author couto
 */
public interface DaoRobot {

    public Robot buscarRobot(String nombre);
    
    public Robot buscarRobot(Map<String, Object> whereMap);

    public List<Robot> obtenerListaRobots(Map<String, Object> whereMap);

    public List<Robot> obtenerListaRobots();

    public Robot guardarRobot(Robot rob);

    public Robot actualizarRobot(Robot rob);

}
