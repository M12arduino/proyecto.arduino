package m12.arduino.domain;

import java.io.Serializable;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
codi, nom, ubicació (lloc i/o coordenades), estat (lliure, ocupat,
desconnectat, local)
@author Jordi
*/
public class Robot implements Serializable {

    // ATTR
    private long id_robot;
    private String nombre;
    private Ubicacion ubicacion;
    private EstadoRobot estado;

    public Robot() {
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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoRobot getEstado() {
        return estado;
    }

    public void setEstado(EstadoRobot estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Robot{" + "id_robot=" + id_robot + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", estado=" + estado + '}';
    }
    
}
