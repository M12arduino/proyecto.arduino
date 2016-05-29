package m12.arduino.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Clase Ubicacion
 * Inplementa Serializable
 * @author Enric, Pablo, Jordi y Oscar
 */
@Embeddable
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 925372681339531834L;

    // ATTR
    /**
     * Lugar
     */
    private String lugar;
    
    /**
     * Coordenada X
     */
    private float coorX;
    
    /**
     * Coordenada Y
     */
    private float coorY;

    /**
     * Getter de lugar
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Setter de lugar
     * @param lugar lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Getter de la coordenada X
     * @return coordenada X
     */
    public float getCoorX() {
        return coorX;
    }

    /**
     * Setter de la coordenada X
     * @param coorX coordenada X
     */
    public void setCoorX(float coorX) {
        this.coorX = coorX;
    }

    /**
     * Getter de la coordenada Y
     * @return coordenada Y
     */
    public float getCoorY() {
        return coorY;
    }

    /**
     * Setter de la coordenada Y
     * @param coorY coordenada Y
     */
    public void setCoorY(float coorY) {
        this.coorY = coorY;
    }

    /**
     * Metodo toString para devolver la informacion de la ubicacion
     * @return informacion de la ubicacion
     */
    @Override
    public String toString() {
        return lugar + " (" + coorX + ", " + coorY + ')';
    }
}
