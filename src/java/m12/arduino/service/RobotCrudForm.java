/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import m12.arduino.domain.EstadoRobot;

/**
 *
 * @author enric
 */
public class RobotCrudForm {

    private long id_robot;
    private String nombre;
    private String lugar;
    private float coorX;
    private float coorY;
    private EstadoRobot estado;
    private EstadoRobot estadoSearch;

    public RobotCrudForm() {
    }

    public long getId_robot() {
        return id_robot;
    }

    public void setId_robot(long id_robot) {
        this.id_robot = id_robot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getCoorX() {
        return coorX;
    }

    public void setCoorX(float coorX) {
        this.coorX = coorX;
    }

    public float getCoorY() {
        return coorY;
    }

    public void setCoorY(float coorY) {
        this.coorY = coorY;
    }

    public EstadoRobot getEstado() {
        return estado;
    }

    public void setEstado(EstadoRobot estado) {
        this.estado = estado;
    }

    public EstadoRobot getEstadoSearch() {
        return estadoSearch;
    }

    public void setEstadoSearch(EstadoRobot estadoSearch) {
        this.estadoSearch = estadoSearch;
    }
    
}
