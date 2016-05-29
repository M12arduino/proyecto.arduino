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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Clase Proceso
 * Inplementa Serializable y Maketable
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class Proceso implements Serializable, Maketable {

    private static final long serialVersionUID = -370493739408314348L;

    // ATTR
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Codigo
     */
    private String codigo;
    
    /**
     * Descripcion
     */
    private String descripcion;
    
    /**
     * Lista de acciones
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "proceso", orphanRemoval = true)
    private List<Accion> acciones;
    
    /**
     * Lista de ordenes de fabricacion
     */
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "proceso")
    @JsonIgnore
    private List<OrdenFabricacion> ordenes;

    {
        acciones = new ArrayList();
    }

    /**
     * Getter de lista de ordenes
     * @return lista de ordenes
     */
    public List<OrdenFabricacion> getOrdenes() {
        return ordenes;
    }

    /**
     * Setter de lista de ordenes
     * @param ordenes lista de ordenes
     */
    public void setOrdenes(List<OrdenFabricacion> ordenes) {
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
     * Getter del codigo
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del codigo
     * @param codigo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de la descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion
     * @param descripcion descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de la lista de acciones
     * @return lista de acciones
     */
    public List<Accion> getAcciones() {
        return acciones;
    }

    /**
     * Setter de la lista de acciones
     * @param acciones lista de acciones
     */
    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    /**
     * Metodo para añadir acciones a la lista de acciones
     * @param ac accion a añadir
     */
    public void addAccion(Accion ac) {
        this.getAcciones().add(ac);
        ac.setProceso(this);
    }

    /**
     * Metodo toString para mostrar la información del proceso
     * @return informacion del proceso
     */
    @Override
    public String toString() {
        return "Proceso{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", acciones=" + acciones + '}';
    }

    /**
     * Metodo para la devolucion de los campos del proceso
     * @return campos del proceso
     */
    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Descripcion", "Acciones"));
    }

    /**
     * Metodo para la devolucion de la indormacion del proceso
     * @return informacion del proceso
     */
    @Override
    @JsonIgnore
    public List<String> getInfo() {
        String strAcciones = "";
        for (Accion accion : acciones) {
            strAcciones += accion.toString() + "<br />";
        }
        return new ArrayList(Arrays.asList(this.getId(), this.getCodigo(), this.getDescripcion(), strAcciones));
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
     * @return el texto "Proceso -" + codigo del proceso (nombre completo)
     */
    @Override
    @JsonIgnore
    public String getFullName() {
        return "Proceso - " + this.getCodigo();
    }

}
