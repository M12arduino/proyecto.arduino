/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import m12.arduino.domain.Equipo;

/**
 *
 * @author enric
 */
public interface DaoEquipo {
    
    public Equipo guardaActualizaEquipo(Equipo eq);
}
