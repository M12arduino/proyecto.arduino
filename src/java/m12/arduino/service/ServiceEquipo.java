/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import m12.arduino.dao.DaoEquipoImpl;
import m12.arduino.domain.Equipo;

/**
 *
 * @author enric
 */
public class ServiceEquipo {
    private DaoEquipoImpl dE = new DaoEquipoImpl();
    
    public boolean insertarEquipo(Equipo eq){
        dE.guardaActualizaEquipo(eq);
        return true;
    }
    public Equipo buscarEquipo(String nombre){
        return dE.buscarEquipo(nombre);
    }
    public Equipo actualizaEquipo(Equipo eq){
        return dE.actualizaEquipo(eq);
    }
    public Equipo mergeEquipo(Equipo eq){
        return dE.mergeEquipo(eq);
    }

}
