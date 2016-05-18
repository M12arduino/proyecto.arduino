package m12.arduino.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, nom, treballadors
@author Jordi
*/
@Entity
public class Equipo {

    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long id_equipo;
    private String nombre;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy="equipo")
    @JsonIgnore
    private List<Trabajador> trabajadores;
   
    
    {
        trabajadores = new ArrayList<Trabajador>();
    }
    
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
    
    public Trabajador addTrabajador(Trabajador treb){
        treb.setEquipo(this);
        this.getTrabajadores().add(treb);
        return treb;
    }
    @Override
    public String toString() {
        return "Equipo{" + "id_equipo=" + id_equipo + ", nombre=" + nombre + ", trabajadores=" + trabajadores + '}';
    }
    
    
}
