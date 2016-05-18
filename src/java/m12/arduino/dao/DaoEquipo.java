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
 *
 * @author enric
 */
public interface DaoEquipo {

    public Equipo buscarEquipo(String nombre);
    
    public Equipo buscarEquipo(Map<String, Object> whereMap);

    public List<Equipo> obtenerListaEquipos(Map<String, Object> whereMap);

    public List<Equipo> obtenerListaEquipos();

    public Equipo guardarEquipo(Equipo equ);

    public Equipo actualizarEquipo(Equipo equ);

}
