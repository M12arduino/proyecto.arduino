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
    private long id;
    private String id_equipo;
    private String nombre;
    private List<Trabajador> trabajadores;
    private List<String> nifs;
    private String codigo_orden;
    private String fullName;

    public EquipoForm() {
    }
    
    
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
