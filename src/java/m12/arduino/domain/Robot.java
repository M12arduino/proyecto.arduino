package m12.arduino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Clase Robot
 * Inplementa Serializable y Maketable
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class Robot implements Serializable, Maketable {

    private static final long serialVersionUID = 3679568141321204536L;

    // ATTR
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Identificador del robot
     */
    private String id_robot;
    
    /**
     * Nombre
     */
    private String nombre;
    
    /**
     * Ubicacion
     */
    @Embedded
    private Ubicacion ubicacion;
    
    /**
     * Estado del robot
     */
    @Enumerated (value = EnumType.STRING)
    private EstadoRobot estado;
    
    /**
     * Lista de ordenes de fabricacion (TreeSet)
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "robot")
    private Set<OrdenFabricacion> ordenes;

    {
        ordenes = new TreeSet();
        ubicacion = new Ubicacion();
    }

    /**
     * Getter de la coordenada X
     * @return coordenada X
     */
    public float getCoorX() {
        return this.getUbicacion().getCoorX();
    }

    /**
     * Getter de la coordenada Y
     * @return coordenada Y
     */
    public float getCoorY() {
        return this.getUbicacion().getCoorY();
    }

    /**
     * Getter de la lista de ordenes
     * @return lista de ordenes (TreeSet)
     */
    public Set<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    /**
     * Setter de la lista de ordenes
     * @param ordenes lista de ordenes (TreeSet)
     */
    public void setOrdenes(Set<OrdenFabricacion> ordenes) {
        this.ordenes = ordenes;
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
     * Getter del identificador del robot
     * @return identificador del robot
     */
    public String getId_robot() {
        return id_robot;
    }

    /**
     * Setter del identificador del robot
     * @param id_robot identificador del robot
     */
    public void setId_robot(String id_robot) {
        this.id_robot = id_robot;
    }

    /**
     * Gatter del nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la ubicacio del robot
     * @return ubicacion del robot
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * Setter de la ubicacion del robot
     * @param ubicacion ubicacion del robot
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Getter del estado del robot
     * @return estado del robot
     */
    public EstadoRobot getEstado() {
        return estado;
    }

    /**
     * Setter del estado del robot
     * @param estado estado del robot
     */
    public void setEstado(EstadoRobot estado) {
        this.estado = estado;
    }

    /**
     * Metodo para añadir ordenes de fabricacion a la lista de ordenes de fabricacion
     * @param oF orden de fabricacion a añadir
     */
    public void addOrden(OrdenFabricacion oF) {
        this.getOrdenes().add(oF);
    }

    /**
     * Metodo para la devolucion de los campos del robot
     * @return campos del robot
     */
    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Nombre", "Ubicacion", "Estado"));
    }

    /**
     * Metodo para la devolucion de informacion del robot
     * @return informacion del robot
     */
    @Override
    @JsonIgnore
    public List<String> getInfo() {
        return new ArrayList(Arrays.asList(this.getId(), this.getId_robot(), this.getNombre(), this.getUbicacion().toString(), this.getEstado()));
    }

    /**
     * Getter de clave primaria
     * @return identificador
     */
    @Override
    @JsonIgnore
    public long getPK() {
        return this.getId();
    }
    
    /**
     * Metodo de nombre completo
     * @return id del robot + nombre (nombre completo)
     */
    @Override
    public String getFullName() {
        return this.getId_robot() + " - " + this.getNombre();
    }
}
