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
    private String id_equipo;
    private String nombre;
    private List<String> nifs;
    private String codigo_orden;

    public EquipoForm() {
    }

    public String getCodigo_orden() {
        return codigo_orden;
    }

    public void setCodigo_orden(String codigo_orden) {
        this.codigo_orden = codigo_orden;
    }
    
    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
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
