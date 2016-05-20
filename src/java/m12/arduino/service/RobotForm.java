package m12.arduino.service;

import m12.arduino.domain.EstadoRobot;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class RobotForm {

    // ATTR
    private Long id;
    private String id_robot;
    private String nombre;
    private String lugar;
    private float coorX;
    private float coorY;
    private EstadoRobot estado;
    private EstadoRobot estadoSearch;
    
    // GESETS
    public Long getId() {    
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoRobot getEstadoSearch() {
        return estadoSearch;
    }

    public void setEstadoSearch(EstadoRobot estadoSearch) {
        this.estadoSearch = estadoSearch;
    }

    public String getId_robot() {
        return id_robot;
    }

    public void setId_robot(String id_robot) {
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
}
