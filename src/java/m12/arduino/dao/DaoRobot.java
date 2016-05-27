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
 * Controlador implementable para los objetos Robot.
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface DaoRobot {

    /**
     * Metodo implementable para buscar un robot en la base de datos.
     * @param codigo String con el codigo del robot a buscar.
     * @return Devuelve un Objeto Robot correspondiente al codigo proporcionado.
     */
    public Robot buscarRobot(String codigo);
    
    /**
     * Metodo implementable para buscar robots en la base de datos.
     * @param whereMap objeto Map con la información para buscar robots. 
     * @return Devuelve un Objeto Robot que coincide con la información proporcionada.
     */
    public Robot buscarRobot(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los robots de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * robots. 
     * @return Devuelve un objeto List de los robots que coinciden con la 
     * información proporcionada.
     */
    public List<Robot> obtenerListaRobots(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los robots de la base de datos.
     * @return Devuelve un Objeto List con los robots de la base de datos.
     */
    public List<Robot> obtenerListaRobots();

    /**
     * Metodo implementable para guardar robots en la base de datos.
     * @param rob objeto Robot a guardar.
     * @return Devuelve el objeto Robot guardado.
     */
    public Robot guardarRobot(Robot rob);

    /**
     * Metodo implementable para actualizar robots de la base de datos.
     * @param rob objeto Robot a actualizar.
     * @return Devuelve el objeto Robot actualizado.
     */
    public Robot actualizarRobot(Robot rob);
    
    /**
     * Metodo implementable para eliminar robots de la base de datos.
     * @param rob objeto Robot a eliminar.
     */
    public void eliminarRobot(Robot rob);

}
