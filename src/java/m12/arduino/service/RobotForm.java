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
    private long id;
    private String nombre;
    private String lugar;
    private float coorX;
    private float coorY;
    private EstadoRobot estado;

    // GESETS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
