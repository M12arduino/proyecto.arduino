package m12.arduino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016
 codi, descripció, relació de moviments del robot i accions a
realitzar (obrir-tancar pinça)
@author Jordi
*/
@Entity
public class Proceso implements Serializable, Maketable {
    private static final long serialVersionUID = -370493739408314348L;

    // ATTR
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy="proceso")
    @JsonIgnore
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

    public List<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void addAccion(Accion ac){
        this.getAcciones().add(ac);
        ac.setProceso(this);
    }

    @Override
    public String toString() {
        return "Proceso{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", acciones=" + acciones + '}';
    }

    @Override
    @JsonIgnore
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Codigo", "Descripcion", "Acciones"));
    }

    @Override
    @JsonIgnore
    public List<String> getInfo() {
        String strAcciones = "";
        for (Accion accion : acciones) {
            strAcciones += accion.toString() + "<br />";
        }
        return new ArrayList(Arrays.asList(this.getId(), this.getCodigo(), this.getDescripcion(), strAcciones));
    }

    @Override
    @JsonIgnore
    public long getPK() {
        return this.getId();
    }

    @Override
    @JsonIgnore
    public String getFullName() {
        return "Proceso - " + this.getCodigo();
    }
    
    
    
}
