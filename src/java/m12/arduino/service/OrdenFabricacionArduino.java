/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import m12.arduino.domain.Accion;
import m12.arduino.domain.Prioridad;

/**
 * Clase OrdenFabricacionArduino
 * @author Enric, Pablo, Jordi y Oscar
 */
public class OrdenFabricacionArduino {
    
     // ATTR
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Codigo
     */
    @Pattern(regexp = "(OF[0-9]{3})", message = "Formato del codigo de la Orden de fabricacion incorrecto")
    private String codigo;
    
    /**
     * Descripcion
     */
    @Size(min = 1, max = 144, message = "La descripcion tiene un maximo de 144 caracteres")
    private String descripcion;
    
    /**
     * Prioridad
     */
    @NotNull(message = "Es obligatorio establecer una prioridad")
    private Prioridad proridad;
    
    /**
     * Lista de acciones
     */
    private List<Accion> acciones;

    /**
     * Constructor vacio
     */
    public OrdenFabricacionArduino() {
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
     * Getter de la priodidad
     * @return prioridad
     */
    public Prioridad getProridad() {
        return proridad;
    }

    /**
     * Setter de la prioridad
     * @param proridad prioridad
     */
    public void setProridad(Prioridad proridad) {
        this.proridad = proridad;
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
     * Metodo toString para devolver informacion del objeto OrdenFabricacionArduino
     * @return información del objeto OrdenFabricacionArduino
     */
    @Override
    public String toString() {
        return "OrdenFabricacionArduino{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", proridad=" + proridad + ", acciones=" + acciones + '}';
    }
}
