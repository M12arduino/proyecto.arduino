package m12.arduino.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import m12.arduino.domain.EstadoRobot;
import org.hibernate.validator.constraints.Range;

/**
 * Clase RobotForm
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public class RobotForm {

    // ATTR
    /**
     * Identificador
     */
    private Long id;

    /**
     * Identificador de robot
     */
    @Pattern(regexp = "([A-Za-z0-9]{0,10)", message = "Formato del id del robot incorrecto")
    private String id_robot;

    /**
     * Nombre
     */
    @Size(min = 1, max = 50, message = "El nombre tiene un maximo de 50 caracteres")
    private String nombre;

    /**
     * Lugar
     */
    @Size(min = 1, max = 50, message = "El nombre tiene un maximo de 50 caracteres")
    private String lugar;

    /**
     * Coordenada X
     */
    @Range(min = 0, max = 10000, message = "La coordenada 'X' debe ser positiva y hasta 9999,99")
    private float coorX;

    /**
     * Coordenada Y
     */
    @Range(min = 0, max = 10000, message = "La coordenada 'Y' debe ser positiva y hasta 9999,99")
    private float coorY;

    /**
     * Estado del robot
     */
    @NotNull(message = "Es obligado seleccionar un Estado de robot")
    private EstadoRobot estado;

    /**
     * Estado a buscar
     */
    private EstadoRobot estadoSearch;

    /**
     * Constructor vacio
     */
    public RobotForm() {
    }

    // GESETS
    /**
     * Getter del identificador
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
     * Getter del estado a buscar
     *
     * @return estado a buscar
     */
    public EstadoRobot getEstadoSearch() {
        return estadoSearch;
    }

    /**
     * Setter del estado a buscar
     *
     * @param estadoSearch estado a buscar
     */
    public void setEstadoSearch(EstadoRobot estadoSearch) {
        this.estadoSearch = estadoSearch;
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
     * Getter del lugar
     *
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Setter del lugar
     *
     * @param lugar lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Getter de la coordenada X
     *
     * @return coordenada X
     */
    public float getCoorX() {
        return coorX;
    }

    /**
     * Setter de la coordenada X
     *
     * @param coorX coordenada X
     */
    public void setCoorX(float coorX) {
        this.coorX = coorX;
    }

    /**
     * Getter de la coordenada Y
     *
     * @return coordenada Y
     */
    public float getCoorY() {
        return coorY;
    }

    /**
     * Setter de la coordenada Y
     *
     * @param coorY coordenada Y
     */
    public void setCoorY(float coorY) {
        this.coorY = coorY;
    }

    /**
     * Getter del estado del robot
     *
     * @return estado del robot
     */
    public EstadoRobot getEstado() {
        return estado;
    }

    /**
     * Setter del estado del robot
     *
     * @param estado estado del robot
     */
    public void setEstado(EstadoRobot estado) {
        this.estado = estado;
    }

    /**
     * Metodo toString para devolver informacion del objeto RobotForm
     *
     * @return información del objeto RobotForm
     */
    @Override
    public String toString() {
        return "RobotForm{" + "id=" + id + ", id_robot=" + id_robot + ", nombre=" + nombre + ", lugar=" + lugar + ", coorX=" + coorX + ", coorY=" + coorY + ", estado=" + estado + ", estadoSearch=" + estadoSearch + '}';
    }
}
