/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m12.arduino.dao.DaoEquipoImpl;
import m12.arduino.domain.Equipo;

/**
 * Clase ServiceEquipo que se apoya en la clase DaoEquipoImpl
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ServiceEquipo {
    
    /**
     * Objeto DaoEquipoImpl para el trato de datos
     */
    private final DaoEquipoImpl dE = new DaoEquipoImpl();

    /**
     * Metodo para la busqueda de equipos por identificador
     * @param id_equipo identificador del equipo a buscar
     * @return Devuelve un Objeto Equipo que coincide con el identificador proporcionado.
     */
    public Equipo buscarEquipo(String id_equipo) {
        return dE.buscarEquipo(id_equipo);
    }

    /**
     * Metodo para la busqueda de equipos por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un Objeto Equipo que coincide con los parametros proporcionados.
     */
    public Equipo buscarEquipo(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dE.buscarEquipo(condiciones);
    }

    /**
     * Metodo para listar los equipos
     * @return Devuelve un objeto List con los Equipos
     */
    public List<Equipo> listarEquipos() {
        return dE.obtenerListaEquipos();
    }

    /**
     * Metodo para listar los equipos filtrados por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un objeto List de los equipos que coinciden 
     * con los parametros proporcionados.
     */
    public List<Equipo> listarEquipos(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dE.obtenerListaEquipos(condiciones);
    }

    /**
     * Metodo para insertar equipos.
     * @param equ objeto Equipo a insertar.
     * @return Devuelve el objeto Equipo guardado.
     */
    public Equipo insertarEquipo(Equipo equ) {
        return dE.guardarEquipo(equ);
    }

    /**
     * Metodo para actualizar un equipo.
     * @param equ equipo a actualizar
     * @return Devuelve el objeto Equipo actualizado.
     */
    public Equipo actualizarEquipo(Equipo equ) {
        return dE.actualizarEquipo(equ);
    }

    /**
     * Metodo para eliminar un equipo.
     * @param equ objeto Equipo a eliminar.
     */
    public void eliminarEquipo(Equipo equ) {
        dE.eliminarEquipo(equ);
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
