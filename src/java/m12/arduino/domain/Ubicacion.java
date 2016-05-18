package m12.arduino.domain;

import javax.persistence.Embeddable;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
@Embeddable
public class Ubicacion {

    // ATTR
    private String lugar;
    private float coorX;
    private float coorY;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getCoorX() {
        return coorX;
    }

    public void setCoorX(float coorX) {
        this.coorX = coorX;
    }

    public float getCoorY() {
        return coorY;
    }

    public void setCoorY(float coorY) {
        this.coorY = coorY;
    }
    
    
}
