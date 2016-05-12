package m12.arduino.domain;
/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class Trabajador {

    // ATTR
    private long id_trab;
    private String nif;
    private String nombre;
    private String movil;
    private String password;
    private CategoriaTrabajador categoria;   

    public Trabajador() {
    }

    public Trabajador(String nif, String nombre, String movil, String password) {
        this.nif = nif;
        this.nombre = nombre;
        this.movil = movil;
        this.password = password;
    }

    public long getId_trab() {
        return id_trab;
    }

    public void setId_trab(long id_trab) {
        this.id_trab = id_trab;
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

    public CategoriaTrabajador getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }    
    
    
    
    
}
