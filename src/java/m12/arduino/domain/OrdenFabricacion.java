package m12.arduino.domain;

import java.io.Serializable;
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

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016
 codi, descripció, prioritat, data, procés, quantitat,
 robot que la desenvoluparà, estat (pendent, iniciada, realitzada, no realitzada,
 cancel·lada)
 @author Grupo 3 Arduino
 */
@Entity
public class OrdenFabricacion implements Serializable, Comparable, Maketable {

    private static final long serialVersionUID = 7674836498685381771L;

    // ATTR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    @Enumerated (value = EnumType.STRING)
    private Prioridad proridad;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    @ManyToOne
    private Proceso proceso;
    private int cantidad;
    @ManyToOne
    private Robot robot;
    private EstadoOrden estado;
    @ManyToOne
    private Equipo equipo;
    @ManyToOne
    private Trabajador trabajador;

    {        
        estado = EstadoOrden.INDEFINIDO;
        fecha = Calendar.getInstance();
        System.out.println(fecha.toString());
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getProridad() {
        return proridad;
    }

    public void setProridad(Prioridad proridad) {
        this.proridad = proridad;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
        robot.addOrden(this);
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

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

    @Override
    public int compareTo(Object o) {
        OrdenFabricacion oF = (OrdenFabricacion) o;
        if (this.getProridad() != oF.getProridad()) {                           // Si no coinciden ordenarà por prioridad
            return this.getProridad().getCode() - oF.getProridad().getCode();   
        } else {
            if (this.getFecha().equals(oF.getFecha())) {                        // Si coinciden las fechas, ordenará por id
                return (int) (this.getId() - oF.getId());
            } else {                                                            // Sinó, ordenará por fecha
                return this.getFecha().compareTo(oF.getFecha());
            }
        }
        // Ordenacion: En primer lugar por prioridad, si éstas coinciden, por fecha y 
        // si éstas TAMBIÉN coinciden, ordenará por ID que es imposible que coincida.
    }

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

    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Descripcion", "Prioridad", "Fecha", "Proceso", "Cantidad", "Robot", "Estado", "Equipo"));
    }
  
    @Override
    @JsonIgnore
    public List<String> getInfo() {
        String strEq = "No associado";
        if (equipo != null) {
            strEq = equipo.getFullName();
        }
        return new ArrayList(Arrays.asList(this.getId(), this.getCodigo(), this.getDescripcion(), this.getProridad(), this.getFecha(), this.getProceso().getFullName(), this.getCantidad(), this.getRobot().getFullName(), this.getEstado(), strEq));
    }

    @Override
    @JsonIgnore
    public long getPK() {
        return this.getId();
    }

    @Override
    @JsonIgnore
    public String getFullName() {
        return "Orden - " + this.getCodigo();
    }

    
}
