/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;
import m12.arduino.domain.Trabajador;

/**
 * Clase EquipoForm
 * @author Enric, Pablo, Jordi y Oscar
 */
public class EquipoForm {
    
    /**
     * Identificador
     */
    private long id;
    
    /**
     * Identificador de equipo
     */
    private String id_equipo;
    
    /**
     * Nombre
     */
    private String nombre;
    
    /**
     * Lista de trabajadores
     */
    private List<Trabajador> trabajadores;
    
    /**
     * Lista de nif's
     */
    private List<String> nifs;
    
    /**
     * Código de la orden de fabricación
     */
    private String codigo_orden;
    
    /**
     * Nombre completo
     */
    private String fullName;

    /**
     * Constructor vacio
     */
    public EquipoForm() {
    }
    
    /**
     * Getter de la lista de trabajadores
     * @return lista de trabajadores
     */
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    /**
     * Setter de la lista de trabajadores
     * @param trabajadores lista de trabajadores
     */
    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    /**
     * Getter del identificador
     * @return identificador
     */
    public long getId() {
        return id;
    }

    /**
     * Setter del identificador
     * @param id identificador
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter del codigo de la orden de fabricación
     * @return codigo de la orden de fabricación
     */
    public String getCodigo_orden() {
        return codigo_orden;
    }

    /**
     * Setter del codigo de la orden de fabricación
     * @param codigo_orden codigo de la orden de fabricación
     */
    public void setCodigo_orden(String codigo_orden) {
        this.codigo_orden = codigo_orden;
    }
    
    /**
     * Getter del identificador del equipo
     * @return identificador del equipo
     */
    public String getId_equipo() {
        return id_equipo;
    }

    /**
     * Setter del identificador del equipo
     * @param id_equipo identificador del equipo
     */
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * Getter del nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la lista de nif's
     * @return lista de nif's
     */
    public List<String> getNifs() {
        return nifs;
    }

    /**
     * Setter de la lista de nif's
     * @param nifs lista de nif's
     */
    public void setNifs(List<String> nifs) {
        this.nifs = nifs;
    }

    /**
     * Metodo toString para devolver informacion del objeto EquipoForm
     * @return información del objeto EquipoForm
     */
    @Override
    public String toString() {
        return "EquipoForm{" + "id=" + id + ", id_equipo=" + id_equipo + ", nombre=" + nombre + ", trabajadores=" + trabajadores + ", nifs=" + nifs + ", codigo_orden=" + codigo_orden + ", fullName=" + fullName + '}';
    }
}
