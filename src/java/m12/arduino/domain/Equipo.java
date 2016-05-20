package m12.arduino.domain;

import java.io.Serializable;
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
public class Equipo implements Serializable {
    private static final long serialVersionUID = -9193035208662365731L;

    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String id_equipo;
    private String nombre;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER,mappedBy="equipo")
    @JsonIgnore
    private List<Trabajador> trabajadores;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER,mappedBy = "equipo")
    private List<OrdenFabricacion> ordenes;
    
    {
        ordenes = new ArrayList<OrdenFabricacion>();
        trabajadores = new ArrayList<Trabajador>();
    }

    public List<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenFabricacion> ordenes) {
        this.ordenes = ordenes;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
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
        this.getTrabajadores().add(treb);
        treb.setEquipo(this);
        return treb;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", id_equipo=" + id_equipo + ", nombre=" + nombre + ", trabajadores=" + trabajadores + ", ordenes=" + ordenes + '}';
    }
    
}
