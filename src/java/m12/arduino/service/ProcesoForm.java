/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.ArrayList;
import java.util.List;
import m12.arduino.domain.Accion;


/**
 * Clase ProcesoForm
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ProcesoForm {
    
    // ATTR
    /**
     * Identificador
     */
    private Long id;
    
    /**
     * Codigo
     */
    private String codigo;
    
    /**
     * Descripcion
     */
    private String descripcion;
    
    /**
     * Lista de acciones
     */
    private List<Accion> acciones;
    
    /**
     * JSon con acciones
     */
    private String accionesJSON;

    /**
     * Constructor vacio
     */
    public ProcesoForm() {
    }

    /**
     * Getter de la lista de acciones
     * @return lista de acciones
     */
    public List<Accion> getAcciones() {
        return acciones;
    }

    /**
     * Setter de la lista de acciones
     * @param acciones lista de acciones
     */
    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    /**
     * Getter del identificador
     * @return identificador
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter del identificador
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter del codigo
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del codigo
     * @param codigo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de la descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion
     * @param descripcion descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del JSon de acciones
     * @return JSon de acciones
     */
    public String getAccionesJSON() {
        return accionesJSON;
    }

    /**
     * Setter del JSon de acciones
     * @param accionesJSON JSon de acciones
     */
    public void setAccionesJSON(String accionesJSON) {
        this.accionesJSON = accionesJSON;
    }

    /**
     * Metodo toString para devolver informacion del objeto ProcesoForm
     * @return información del objeto ProcesoForm
     */
    @Override
    public String toString() {
        return "ProcesoForm{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", acciones=" + acciones + ", accionesJSON=" + accionesJSON + '}';
    }
}
