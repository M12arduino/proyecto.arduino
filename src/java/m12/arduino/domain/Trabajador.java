package m12.arduino.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Clase Trabajador Inplementa Serializable y Maketable
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class Trabajador implements Serializable, Maketable {

    private static final long serialVersionUID = -2083851459317235842L;

    // ATTR
    /**
     * Identificador del trabajador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_trab;

    /**
     * Nif
     */
    // @Pattern(regexp = "(^\\d{8})([\\s-]?)([a-zA-Z]$)", message = "Format del DNI incorrecte")
    private String nif;

    /**
     * Nombre
     */
    @Size(min = 1, max = 50, message = "El nombre tiene un maximo de 50 caracteres")
    private String nombre;

    /**
     * Movil
     */
    @Pattern(regexp = "(^[6-7])(\\d{8})$", message = "Formato del MOBIL incorrecto")
    private String movil;

    /**
     * Password
     */
    @Size(min = 4, max = 20, message = "La contraseña ha de tener entre 4 y 20 caracteres")
    private String password;

    /**
     * Categoria del trabajador
     */
    @Enumerated(value = EnumType.STRING)
    private CategoriaTrabajador categoria;

    /**
     * Equipo
     */
    @ManyToOne
    private Equipo equipo;

    /**
     * Lista de ordenes de fabricacion
     */
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "trabajador")
    @JsonIgnore
    private List<OrdenFabricacion> ordenes;

    // GESETS
    /**
     * Getter de la lista de ordenes de fabricacion
     *
     * @return lista de ordenes de fabricacion
     */
    public List<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    /**
     * Setter de la lista de ordenes de fabricacion
     *
     * @param ordenes lista de ordenes de fabricacion
     */
    public void setOrdenes(List<OrdenFabricacion> ordenes) {
        this.ordenes = ordenes;
    }

    /**
     * Getter de equipo
     *
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Setter de equipo
     *
     * @param equipo equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Getter del identificador del trabajador
     *
     * @return identificador del trabajador
     */
    public long getId_trab() {
        return id_trab;
    }

    /**
     * Setter del identificador del trabajador
     *
     * @param id_trab identificador del trabajador
     */
    public void setId_trab(long id_trab) {
        this.id_trab = id_trab;
    }

    /**
     * Getter de la categoria
     *
     * @return categoria
     */
    public CategoriaTrabajador getCategoria() {
        return categoria;
    }

    /**
     * Setter de la categoria
     *
     * @param categoria categoria
     */
    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }

    /**
     * Getter del nif
     *
     * @return nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter del nif
     *
     * @param nif nif
     */
    public void setNif(String nif) {
        this.nif = nif;
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
     * Getter del movil
     *
     * @return movil
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Setter del movil
     *
     * @param movil movil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Getter del password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter del password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // OTHER METHODS
    /**
     * Metodo toString para devolver la informacion del trabajador
     *
     * @return la informacion del trabajador
     */
    @Override
    public String toString() {
        String eqName = "No definido";
        if (equipo != null) {
            eqName = equipo.getFullName();
        }
        return "Trabajador{" + "id_trab=" + id_trab + ", nif=" + nif + ", nombre=" + nombre + ", movil=" + movil + ", password=" + password + ", categoria=" + categoria + ", equipo=" + eqName + '}';
    }

    /**
     * Metodo de conversion a JSon
     *
     * @return String parseado
     * @throws IOException eb casi de fallo del parseo
     */
    public String toJson() throws IOException {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = mapperObj.writeValueAsString(this);
        return jsonStr;
    }

    /**
     * Metodo para devolver los campos del trabajador
     *
     * @return campos del trabajador
     */
    @JsonIgnore
    @Override
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Nif", "Nombre", "Movil", "Categoria", "Equipo"));
    }

    /**
     * Metodo para devolver la informacion del trabajador
     *
     * @return informacion del trabajador
     */
    @JsonIgnore
    @Override
    public List<String> getInfo() {
        String eqName = "No definido";
        if (equipo != null) {
            eqName = equipo.getNombre();
        }
        return new ArrayList(Arrays.asList(id_trab, nif, nombre, movil, categoria.toString(), eqName));
    }

    /**
     * Metodo para la clave primaria
     *
     * @return identificador del trabajador
     */
    @JsonIgnore
    @Override
    public long getPK() {
        return id_trab;
    }

    /**
     * Metodo de nombre completo
     *
     * @return nombre del trabajador (nombre completo)
     */
    @Override
    @JsonIgnore
    public String getFullName() {
        return this.getNombre();
    }

    /**
     * Metodo para añadir ordenes de fabricacion a la lista de ordenes de
     * fabricacion
     *
     * @param orden orden de fabricacion a añadir
     */
    public void addOrden(OrdenFabricacion orden) {
        this.ordenes.add(orden);
        orden.setTrabajador(this);
    }
}
