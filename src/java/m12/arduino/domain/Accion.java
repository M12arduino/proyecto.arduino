package m12.arduino.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Range;

/**
 * Clase Accion Implementa Serializable
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
@Entity
public class Accion implements Serializable {

    private static final long serialVersionUID = -1008905165777384338L;

    // ATTR
    /**
     * Identificador de accion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_accion;

    /**
     * Posicion X
     */
    @Range(min = 0, max = 9999)
    private int posX;

    /**
     * Posicion Y
     */
    @Range(min = 0, max = 9999)
    private int posY;

    /**
     * Posicion Z
     */
    @Range(min = 0, max = 9999)
    private int posZ;

    /**
     * Estado de la pinza True = abierto False = cerrado
     */
    
    private boolean abrirPinza;

    /**
     * Proceso al que está asignada la accion
     */
    @ManyToOne
    @JsonIgnore
    private Proceso proceso;

    /**
     * Getter de identificador de accion
     *
     * @return el Identificador de accion
     */
    public long getId_accion() {
        return id_accion;
    }

    /**
     * Setter de identificador de accion
     *
     * @param id_accion long con el identificador de accion
     */
    public void setId_accion(long id_accion) {
        this.id_accion = id_accion;
    }

    /**
     * Getter de posicion X
     *
     * @return integer con la posicion X
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Setter de posicion X
     *
     * @param posX integer con la posicion X
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Getter de posicion Y
     *
     * @return integer con la posicion Y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Setter de posicion Y
     *
     * @param posY integer con la posicion Y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Getter de posicion Z
     *
     * @return integer con la posicion Z
     */
    public int getPosZ() {
        return posZ;
    }

    /**
     * Setter de posicion Z
     *
     * @param posZ integer con la posicion Z
     */
    public void setPosZ(int posZ) {
        this.posZ = posZ;
    }

    /**
     * Getter de Pinza
     *
     * @return un Boolean con el estado de la pinza
     */
    public boolean isAbrirPinza() {
        return abrirPinza;
    }

    /**
     * Setter de pinza
     *
     * @param abrirPinza Boolean con el estado de la pinza True = abierto False
     * = cerrado
     */
    public void setAbrirPinza(boolean abrirPinza) {
        this.abrirPinza = abrirPinza;
    }

    /**
     * Getter de proceso
     *
     * @return el objeto Proceso al que esta asignada la accion
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * Setter del proceso
     *
     * @param proceso objeto Proceso al que esta asignada la accion
     */
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * Metodo toString para mostrar información del objeto.
     *
     * @return un String con información del objeto.
     */
    @Override
    public String toString() {
        String state = (abrirPinza) ? "abierta" : "cerrada";
        return "Accion: {X = " + posX + ", Y = " + posY + ", Z = " + posZ + ", Pinza = " + state + '}';
    }
}
