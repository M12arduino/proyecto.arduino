/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Equipo;

/**
 * Controlador implementable para los objetos equipo
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface DaoEquipo {

    /**
     * Metodo implementable para buscar un equipo en la base de datos.
     * @param id_equipo String con el id_equipo del equipo a buscar.
     * @return Devuelve un Objeto Equipo correspondiente al id_equipo proporcionado.
     */
    public Equipo buscarEquipo(String id_equipo);
    
    /**
     * Metodo implementable para buscar equipos en la base de datos.
     * @param whereMap objeto Map con la información para buscar equipos. 
     * @return Devuelve un Objeto Equipo que coincide con la información proporcionada.
     */
    public Equipo buscarEquipo(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los equipos de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * equipos. 
     * @return Devuelve un objeto List de los equipos que coinciden con la 
     * información proporcionada.
     */
    public List<Equipo> obtenerListaEquipos(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los equipos de la base de datos.
     * @return Devuelve un Objeto List con los equipos de la base de datos.
     */
    public List<Equipo> obtenerListaEquipos();

    /**
     * Metodo implementable para guardar equipos en la base de datos.
     * @param equ objeto Equipo a guardar.
     * @return Devuelve el objeto Equipo guardado.
     */
    public Equipo guardarEquipo(Equipo equ);

    /**
     * Metodo implementable para actualizar equipos de la base de datos.
     * @param equ objeto Equipo a actualizar.
     * @return Devuelve el objeto Equipo actualizado.
     */
    public Equipo actualizarEquipo(Equipo equ);
    
    /**
     * Metodo implementable para eliminar equipos de la base de datos.
     * @param equ objeto Equipo a eliminar.
     */
    public void eliminarEquipo(Equipo equ);

}
