package m12.arduino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
codi, nom, ubicació (lloc i/o coordenades), estat (lliure, ocupat,
desconnectat, local)
@author Jordi
*/
@Entity
public class Robot implements Serializable {
    
    private static final long serialVersionUID = 3679568141321204536L;

    // ATTR
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String id_robot;
    private String nombre;
    @Embedded
    private Ubicacion ubicacion;
    private EstadoRobot estado;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy = "robot")
    private Set<OrdenFabricacion> ordenes;

    {
        ordenes = new TreeSet();
        ubicacion = new Ubicacion();
    }

    public Set<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Set<OrdenFabricacion> ordenes) {
        this.ordenes = ordenes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
    public String getFullName(){
        return this.getId_robot()+" - "+this.getNombre();
    }
    
    public void addOrden(OrdenFabricacion oF) {
        this.getOrdenes().add(oF);
    }
}
