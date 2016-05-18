/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;
import m12.arduino.domain.Trabajador;

/**
 *
 * @author enric
 */
public class EquipoForm {
    private long id_equipo;
    private String nombre;
    private List<String> nifs;

    public EquipoForm() {
    }

    
    public long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getNifs() {
        return nifs;
    }

    public void setNifs(List<String> nifs) {
        this.nifs = nifs;
    }
    
    
}
