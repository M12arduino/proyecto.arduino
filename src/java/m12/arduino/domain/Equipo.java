package m12.arduino.domain;

import java.util.List;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, nom, treballadors
@author Jordi
*/
public class Equipo {

    // ATTR
    private long id_equipo;
    private String nombre;
    private List<Trabajador> trabajadores;

    public Equipo() {
    }

    
    public long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
