package m12.arduino.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
@Entity
public class Trabajador implements Serializable, Maketable {

    private static final long serialVersionUID = -2083851459317235842L;

    // ATTR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_trab;
    // @Pattern(regexp = "(^\\d{8})([\\s-]?)([a-zA-Z]$)", message = "Format del DNI incorrecte")
    // @NotNull(message = "El camp dni no pot estar buit")
    private String nif;
    //  @Pattern(regexp = "(^[\\w\\s]{2,15})", message = "Format del Nom incorrecte")
    private String nombre;
    //@Pattern(regexp = "(^[6-7])(\\d{8})$", message = "Format del MOBIL incorrecte")
    private String movil;
    // @Size(min = 4, max = 20, message = "La contrassenya ha de tenir entre 4 i 20 caracters")
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private CategoriaTrabajador categoria;
    @ManyToOne
    private Equipo equipo;

    // GESETS
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public long getId_trab() {
        return id_trab;
    }

    public void setId_trab(long id_trab) {
        this.id_trab = id_trab;
    }
    public CategoriaTrabajador getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // OTHER METHODS

    @Override
    public String toString() {
        String eqName = "No definido";
        if (equipo != null){
            eqName = equipo.getNombre();
        }               
        return "Trabajador{" + "id_trab=" + id_trab + ", nif=" + nif + ", nombre=" + nombre + ", movil=" + movil + ", password=" + password + ", categoria=" + categoria + ", equipo=" + eqName + '}';
    }
    
    
    public String toJson() throws IOException{
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = mapperObj.writeValueAsString(this);
        return jsonStr;
    }
    @JsonIgnore
    @Override
    public List<String> getFields() {
        return new ArrayList(Arrays.asList("ID", "Nif", "Nombre", "Movil", "Categoria", "Equipo"));
    }
    @JsonIgnore
    @Override
    public List<String> getInfo() {
        String eqName = "No definido";
        if (equipo != null){
            eqName = equipo.getNombre();
        }               
        return new ArrayList(Arrays.asList(id_trab, nif, nombre, movil, categoria.toString(),eqName));   
    }
    @JsonIgnore
    @Override
    public long getPK() {
        return id_trab;
    }

    @Override
    public String getFullName() {
        return this.getNombre();
    }
}
