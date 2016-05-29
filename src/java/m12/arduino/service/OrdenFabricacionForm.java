package m12.arduino.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import m12.arduino.domain.Prioridad;
import org.hibernate.validator.constraints.Range;

/**
 * Clase OrdenFabricacionForm
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public class OrdenFabricacionForm {

    /**
     * Identificador
     */
    private Long id;

    /**
     * Codigo
     */
    @Pattern(regexp = "(OF[0-9]{3})", message = "Formato del codigo de la Orden de fabricacion incorrecto")
    private String codigo;

    /**
     * Descripcion
     */
    @Size(min = 1, max = 144, message = "La descripcion tiene un maximo de 144 caracteres")
    private String descripcion;

    /**
     * Prioridad
     */
    @NotNull(message = "Es obligatorio establecer una prioridad")
    private Prioridad prioridad;

    /**
     * Identificador del equipo
     */
    @Pattern(regexp = "([A-Z]{2}[0-9]{4})", message = "Formato del id del equipo incorrecto")
    private Long equipo_id;

    /**
     * Codigo del proceso
     */
    @Pattern(regexp = "(P[0-9]{3})", message = "Formato del codigo de proceso incorrecto")
    private String codigo_proceso;

    /**
     * Cantidad
     */
    @Range(min = 1, max = 1000, message = "La cantidad debe ser superior a 0 e inferior a 1000")
    private int cantidad;

    /**
     * Identificador del robot
     */
    @Pattern(regexp = "([A-Za-z0-9]{0,10)", message = "Formato del id del robot incorrecto")
    private String id_robot;

    /**
     * Identificador del proceso
     */
    private long codigo_proceso_id;

    /**
     * Identificador del robot
     */
    private long id_robot_id;

    /**
     * Codigo del eje
     */
    private String codigo_eje;

    /**
     * Codigo de cancelacion
     */
    private String codigo_can;

    /**
     * Constructor vacio
     */
    public OrdenFabricacionForm() {
    }

    /**
     * Getter del codigo del eje
     *
     * @return codigo del eje
     */
    public String getCodigo_eje() {
        return codigo_eje;
    }

    /**
     * Setter del codigo del eje
     *
     * @param codigo_eje codigo del eje
     */
    public void setCodigo_eje(String codigo_eje) {
        this.codigo_eje = codigo_eje;
    }

    /**
     * Getter del codigo de cancelacion
     *
     * @return codigo de cancelacion
     */
    public String getCodigo_can() {
        return codigo_can;
    }

    /**
     * Setter del codigo del cancelacion
     *
     * @param codigo_can codigo de cancelacion
     */
    public void setCodigo_can(String codigo_can) {
        this.codigo_can = codigo_can;
    }

    /**
     * Getter del identificador del proceso
     *
     * @return identificador del proceso
     */
    public long getCodigo_proceso_id() {
        return codigo_proceso_id;
    }

    /**
     * Setter del identificador del proceso
     *
     * @param codigo_proceso_id identificador del proceso
     */
    public void setCodigo_proceso_id(long codigo_proceso_id) {
        this.codigo_proceso_id = codigo_proceso_id;
    }

    /**
     * Getter del identificador del robot
     *
     * @return identificador del robot
     */
    public long getId_robot_id() {
        return id_robot_id;
    }

    //fecha y estado assignadas por defecto
    /**
     * Setter del identificador del robot
     *
     * @param id_robot_id identificador del robot
     */
    public void setId_robot_id(long id_robot_id) {
        this.id_robot_id = id_robot_id;
    }

    /**
     * Getter de identificador
     *
     * @return identificador
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter del identificador
     *
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter del identificador del equipo
     *
     * @return identificador del equipo
     */
    public Long getEquipo_id() {
        return equipo_id;
    }

    /**
     * Setter del identificador del equipo
     *
     * @param equipo_id identificador del equipo
     */
    public void setEquipo_id(Long equipo_id) {
        this.equipo_id = equipo_id;
    }

    /**
     * Getter del codigo
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del codigo
     *
     * @param codigo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de la descripcion
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion
     *
     * @param descripcion descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de la prioridad
     *
     * @return prioridad
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * Setter de la prioridad
     *
     * @param prioridad prioridad
     */
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Getter de la cantidad
     *
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter de la cantidad
     *
     * @param cantidad cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Getter del codigo del proceso
     *
     * @return codigo del proceso
     */
    public String getCodigo_proceso() {
        return codigo_proceso;
    }

    /**
     * Setter del codigo del proceso
     *
     * @param codigo_proceso codigo del proceso
     */
    public void setCodigo_proceso(String codigo_proceso) {
        this.codigo_proceso = codigo_proceso;
    }

    /**
     * Getter del identificador del robot
     *
     * @return identificador del robot
     */
    public String getId_robot() {
        return id_robot;
    }

    /**
     * Setter del identificador del robot
     *
     * @param id_robot identificador del robot
     */
    public void setId_robot(String id_robot) {
        this.id_robot = id_robot;
    }

    /**
     * Metodo toString para devolver informacion del objeto OrdenFabricacionForm
     *
     * @return información del objeto OrdenFabricacionForm
     */
    @Override
    public String toString() {
        return "OrdenFabricacionForm{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", equipo_id=" + equipo_id + ", codigo_proceso=" + codigo_proceso + ", cantidad=" + cantidad + ", id_robot=" + id_robot + ", codigo_proceso_id=" + codigo_proceso_id + ", id_robot_id=" + id_robot_id + ", codigo_eje=" + codigo_eje + ", codigo_can=" + codigo_can + '}';
    }
}
