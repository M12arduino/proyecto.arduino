package m12.arduino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Clase Equipo Inplementa Serializable y Maketable
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class Equipo implements Serializable, Maketable {

    private static final long serialVersionUID = -9193035208662365731L;

    // ATTR
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Identificador de equipo
     */
    @Pattern(regexp = "([A-Z]{2}[0-9]{4})", message = "Formato del id del equipo incorrecto")
    private String id_equipo;

    /**
     * Nombre
     */
    @Size(min = 1, max = 50, message = "El nombre tiene un maximo de 50 caracteres")
    private String nombre;

    /**
     * Lista de trabajadores
     */
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "equipo")
    @JsonIgnore
    private List<Trabajador> trabajadores;

    /**
     * Lista de ordenes de fabricacion
     */
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "equipo")
    @JsonIgnore
    private List<OrdenFabricacion> ordenes;

    {
        ordenes = new ArrayList<OrdenFabricacion>();
        trabajadores = new ArrayList<Trabajador>();
    }

    /**
     * Getter de lista de ordenes
     *
     * @return lista de ordenes
     */
    public List<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    /**
     * Setter de lista de ordenes
     *
     * @param ordenes lista de ordenes
     */
    public void setOrdenes(List<OrdenFabricacion> ordenes) {
        this.ordenes = ordenes;
    }

    /**
     * Getter de identificador
     *
     * @return identificador
     */
    public long getId() {
        return id;
    }

    /**
     * Setter de identificador
     *
     * @param id identificador
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter de indentificador de equipo
     *
     * @return indentificador de equipo
     */
    public String getId_equipo() {
        return id_equipo;
    }

    /**
     * Setter de indentificador de equipo
     *
     * @param id_equipo indentificador de equipo
     */
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * Getter del nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     *
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gettere de lista de trabajadores
     *
     * @return lista de trabajadores
     */
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    /**
     * Setter de lista de trabajadores
     *
     * @param trabajadores lista de trabajadores
     */
    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    /**
     * Metodo para añadir trabajador a la lista de trabajadores
     *
     * @param treb trabajador a añadir a la lista de trabajadores
     * @return objeto Trabajador añadido a la lista
     */
    public Trabajador addTrabajador(Trabajador treb) {
        this.getTrabajadores().add(treb);
        treb.setEquipo(this);
        return treb;
    }

    /**
     * Metodo toString para mostrar información del objeto.
     *
     * @return un String con información del objeto.
     */
    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", id_equipo=" + id_equipo + ", nombre=" + nombre + ", trabajadores=" + trabajadores + ", ordenes=" + ordenes + '}';
    }

    /**
     * Metodo para añadir ordenes a la lista de ordenes de fabricacion
     *
     * @param orden orden de fabricacion
     */
    public void addOrden(OrdenFabricacion orden) {
        this.getOrdenes().add(orden);
        orden.setEquipo(this);
    }

    /**
     * Metodo para la devolucion de los campos de equipo
     *
     * @return campos de equipo
     */
    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Nombre"));
    }

    /**
     * Metodo para la devolucion de la informacion de equipo
     *
     * @return informacion de equipo
     */
    @Override
    @JsonIgnore
    public List<String> getInfo() {
        return new ArrayList(Arrays.asList(this.getId(), this.getId_equipo(), this.getNombre()));
    }

    /**
     * Getter de clave primaria
     *
     * @return identificador
     */
    @Override
    @JsonIgnore
    public long getPK() {
        return this.getId();
    }

    /**
     * Metodo de nombre completo
     *
     * @return identificador de equipo + nombre (nombre completo)
     */
    @Override
    @JsonIgnore
    public String getFullName() {
        return this.getId_equipo() + " - " + this.getNombre();
    }

}
