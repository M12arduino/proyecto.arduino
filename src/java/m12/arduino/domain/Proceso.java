package m12.arduino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, descripció, relació de moviments del robot i accions a
realitzar (obrir-tancar pinça)
@author Jordi
*/
@Entity
public class Proceso implements Serializable {
    private static final long serialVersionUID = -370493739408314348L;

    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String codi;
    private String descripcion;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy="proceso")
    private List<Accion> acciones;

    {
        acciones = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void addAccion(Accion ac){
        this.getAcciones().add(ac);
    }
    
}