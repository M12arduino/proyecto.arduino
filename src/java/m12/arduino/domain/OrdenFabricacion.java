package m12.arduino.domain;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

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
public class OrdenFabricacion implements Serializable {

    private static final long serialVersionUID = 7674836498685381771L;

    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
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
    
    {
        estado = EstadoOrden.PENDIENTE;
        fecha = Calendar.getInstance();
        System.out.println(fecha.toString());
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
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OrdenFabricacion{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", proridad=" + proridad + ", fecha=" + fecha + ", proceso=" + proceso + ", cantidad=" + cantidad + ", robot=" + robot + ", estado=" + estado + '}';
    }
}
