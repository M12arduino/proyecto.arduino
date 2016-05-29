/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.Prioridad;

/**
 * Clase TareasEquipoForm
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public class TareasEquipoForm {

    /**
     * Codigo
     */
    private String codigo;

    /**
     * Descripcion
     */
    private String descripcion;

    /**
     * Prioridad
     */
    private Prioridad prioridad;

    /**
     * Proceso
     */
    private String proceso;

    /**
     * Robot
     */
    private String robot;

    /**
     * Estado
     */
    private EstadoOrden estado;

    /**
     * Equipo
     */
    private String equipo;

    /**
     * Constructor vacio
     */
    public TareasEquipoForm() {
    }

    /**
     * Getter del codigo
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del codigo
     *
     * @param codigo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de la descripcion
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion
     *
     * @param descripcion descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de la prioridad
     *
     * @return prioridad
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * Setter de la prioridad
     *
     * @param prioridad prioridad
     */
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Getter del Proceso
     *
     * @return proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * Setter del proceso
     *
     * @param proceso proceso
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    /**
     * Geter del robot
     *
     * @return robot
     */
    public String getRobot() {
        return robot;
    }

    /**
     * Setter del robot
     *
     * @param robot robot
     */
    public void setRobot(String robot) {
        this.robot = robot;
    }

    /**
     * Getter del estado
     *
     * @return estado
     */
    public EstadoOrden getEstado() {
        return estado;
    }

    /**
     * Setter del estado
     *
     * @param estado estado
     */
    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    /**
     * Getter del equipo
     *
     * @return equipo
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * Setter del equipo
     *
     * @param equipo equipo
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    /**
     * Metodo toString para devolver informacion del objeto TareasEquipoForm
     *
     * @return información del objeto TareasEquipoForm
     */
    @Override
    public String toString() {
        return "TareasEquipoForm{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", proceso=" + proceso + ", robot=" + robot + ", estado=" + estado + ", equipo=" + equipo + '}';
    }
}
