package m12.arduino.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
@Entity
public class Accion implements Serializable {
    private static final long serialVersionUID = -1008905165777384338L;
    
    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_accion;
    private int posX;
    private int posY;
    private int posZ;
    private boolean abrirPinza;
    @ManyToOne
    private Proceso proceso;

    public long getId_accion() {
        return id_accion;
    }

    public void setId_accion(long id_accion) {
        this.id_accion = id_accion;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosZ() {
        return posZ;
    }

    public void setPosZ(int posZ) {
        this.posZ = posZ;
    }

    public boolean isAbrirPinza() {
        return abrirPinza;
    }

    public void setAbrirPinza(boolean abrirPinza) {
        this.abrirPinza = abrirPinza;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
    
    
    
    
    
}
