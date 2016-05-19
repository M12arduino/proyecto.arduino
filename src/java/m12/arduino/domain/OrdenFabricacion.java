package m12.arduino.domain;

import java.util.Calendar;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, descripció, prioritat, data, procés, quantitat,
robot que la desenvoluparà, estat (pendent, iniciada, realitzada, no realitzada,
cancel·lada)
@author Grupo 3 Arduino
*/
public class OrdenFabricacion {

    // ATTR
    private long id;
    private String codigo;
    private String descripcion;
    private Prioridad proridad;
    private Calendar fecha;
    private Proceso proceso;
    private int cantidad;
    private Robot robot;
    private EstadoOrden estado;
    
    {
        estado = EstadoOrden.PENDIENTE;
        fecha = Calendar.getInstance();
        System.out.println(fecha.toString());
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
