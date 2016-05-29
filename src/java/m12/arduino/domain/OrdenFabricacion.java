package m12.arduino.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Clase OrdenFabricacion
 * Inplementa Serializable, Comparable y Maketable
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class OrdenFabricacion implements Serializable, Comparable, Maketable {

    private static final long serialVersionUID = 7674836498685381771L;

    // ATTR
    /**
     * Identificador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * codigo
     */
    private String codigo;
    
    /**
     * Descripcion
     */
    private String descripcion;
    
    /**
     * Prioridad
     */
    @Enumerated (value = EnumType.STRING)
    private Prioridad proridad;
    
    /**
     * Fecha
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    
    /**
     * Proceso
     */
    @ManyToOne
    private Proceso proceso;
    
    /**
     * Cantidad
     */
    private int cantidad;
    
    /**
     * Robot
     */
    @ManyToOne
    private Robot robot;
    
    /**
     * estado de la orden
     */
    private EstadoOrden estado;
    
    /**
     * Equipo
     */
    @ManyToOne
    private Equipo equipo;
    
    /**
     * Trabajador
     */
    @ManyToOne
    private Trabajador trabajador;

    {        
        estado = EstadoOrden.INDEFINIDO;
        fecha = Calendar.getInstance();
        System.out.println(fecha.toString());
    }

    /**
     * Getter de trabajador
     * @return el trabajador
     */
    public Trabajador getTrabajador() {
        return trabajador;
    }

    /**
     * Setter de trabajador
     * @param trabajador trabajador
     */
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    /**
     * Getter del equipo
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Setter del equipo
     * @param equipo equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Getter de indentificado
     * @return identificador
     */
    public long getId() {
        return id;
    }

    /**
     * Setter de identificador
     * @param id identificador
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter de codigo
     * @return docigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter de codigo
     * @param codigo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion
     * @param descripcion descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de prioridad
     * @return prioridad
     */
    public Prioridad getProridad() {
        return proridad;
    }

    /**
     * Setter de prioridad
     * @param proridad prioridad
     */
    public void setProridad(Prioridad proridad) {
        this.proridad = proridad;
    }
    
    /**
     * Getter de fecha en formato Calendar
     * @return fecha en formato Calendar
     */
    @JsonIgnore
    public Calendar getFechaFormat() {
        return fecha;
    }
    
    /**
     * Getter de fecha en formato String
     * @return fecha en formato String
     */
    public String getFecha() {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate = formatter.format(fecha.getTime());
        return currentDate;
    }

    /**
     * Setter de fecha en formato Calendar
     * @param fecha fecha en formato Calendar
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter de proceso
     * @return proceso
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * Setter de proceso
     * @param proceso proceso
     */
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * Getter de cantidad
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter de cantidad
     * @param cantidad cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Getter de robot
     * @return robot
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * Setter de robot
     * @param robot robot
     */
    public void setRobot(Robot robot) {
        this.robot = robot;
        robot.addOrden(this);
    }
    
    /**
     * Getter de estado de la orden
     * @return estado de la orden
     */
    public EstadoOrden getEstado() {
        return estado;
    }

    /**
     * Setter de estado de la orden
     * @param estado estado de la orden
     */
    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    /**
     * Metodo toString para mostrar información de la orden
     * @return información de la orden
     */
    @Override
    public String toString() {
        String strEq = "No associado";
        if (equipo != null) {
            strEq = equipo.getNombre();
        }
        return "OrdenFabricacion{" + "id=" + id + ", codigo=" + codigo + ", "
                + "descripcion=" + descripcion + ", proridad=" + proridad + ", "
                + "fecha=" + fecha.getTime() + ", proceso=" + proceso.getCodigo() + ", "
                + "cantidad=" + cantidad + ", robot=" + robot.getFullName() + ", "
                + "estado=" + estado + ", equipo=" + strEq + '}';
    }

    /**
     * Metodo compareTo para ordenar las ordenes
     * 
     * Ordenacion: En primer lugar por prioridad, si éstas coinciden, por fecha y 
     * si éstas TAMBIÉN coinciden, ordenará por ID que es imposible que coincida.
     * 
     * @param o objeto a comparar para la ordenacion
     * @return resultado de la comparacion para la ordenacion
     */
    @Override
    public int compareTo(Object o) {
        OrdenFabricacion oF = (OrdenFabricacion) o;
        if (this.getProridad() != oF.getProridad()) {                           // Si no coinciden ordenarà por prioridad
            return this.getProridad().getCode() - oF.getProridad().getCode();   
        } else {
            if (this.getFechaFormat().equals(oF.getFechaFormat())) {                        // Si coinciden las fechas, ordenará por id
                return (int) (this.getId() - oF.getId());
            } else {                                                            // Sinó, ordenará por fecha
                return this.getFechaFormat().compareTo(oF.getFechaFormat());
            }
        }
    }

    /**
     * HashCode
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 43 * hash + (this.descripcion != null ? this.descripcion.hashCode() : 0);
        hash = 43 * hash + (this.proridad != null ? this.proridad.hashCode() : 0);
        hash = 43 * hash + (this.fecha != null ? this.fecha.hashCode() : 0);
        hash = 43 * hash + (this.proceso != null ? this.proceso.hashCode() : 0);
        hash = 43 * hash + this.cantidad;
        hash = 43 * hash + (this.robot != null ? this.robot.hashCode() : 0);
        hash = 43 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 43 * hash + (this.equipo != null ? this.equipo.hashCode() : 0);
        return hash;
    }

    /**
     * Equals
     * @param obj objeto a igualar
     * @return resultado boolean según la igualación
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdenFabricacion other = (OrdenFabricacion) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if ((this.descripcion == null) ? (other.descripcion != null) : !this.descripcion.equals(other.descripcion)) {
            return false;
        }
        if (this.proridad != other.proridad) {
            return false;
        }
        if (this.fecha != other.fecha && (this.fecha == null || !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.proceso != other.proceso && (this.proceso == null || !this.proceso.equals(other.proceso))) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.robot != other.robot && (this.robot == null || !this.robot.equals(other.robot))) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.equipo != other.equipo && (this.equipo == null || !this.equipo.equals(other.equipo))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para la devolucion de los campos de la orden de fabricacion
     * @return campos de la orden de fabricacion
     */
    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Descripcion", "Prioridad", "Fecha", "Proceso", "Cantidad", "Robot", "Estado", "Equipo"));
    }
  
    /**
     * Metodo para la devolucion de la informacion de la orden de fabricacion
     * @return informacion de la orden de fabricacion
     */
    @Override
    @JsonIgnore
    public List<String> getInfo() {
        String strEq = "No associado";
        if (equipo != null) {
            strEq = equipo.getFullName();
        }
        return new ArrayList(Arrays.asList(this.getId(), this.getCodigo(), this.getDescripcion(), this.getProridad(), this.getFecha(), this.getProceso().getFullName(), this.getCantidad(), this.getRobot().getFullName(), this.getEstado(), strEq));
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
     * @return texto "Orden -" + codigo de la orden de fabricacion (nombre completo)
     */
    @Override
    @JsonIgnore
    public String getFullName() {
        return "Orden - " + this.getCodigo();
    }

    
}
