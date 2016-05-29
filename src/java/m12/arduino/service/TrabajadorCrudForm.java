/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;

/**
 * Clase TrabajadorCrudForm
 * @author Enric, Pablo, Jordi y Oscar
 */
public class TrabajadorCrudForm {
    
    /**
     * Identificador del trabajador
     */
    private long id_trab;
    
    /**
     * Nif
     */
    // @Pattern(regexp = "(^\\d{8})([\\s-]?)([a-zA-Z]$)", message = "Format del DNI incorrecte")
    // @NotNull(message = "El camp dni no pot estar buit")
    private String nif;
    
    /**
     * Nombre
     */
    //  @Pattern(regexp = "(^[\\w\\s]{2,15})", message = "Format del Nom incorrecte")
    private String nombre;
    
    /**
     * Movil
     */
    // @Pattern(regexp = "(^[6-7])(\\d{8})$", message = "Format del MOBIL incorrecte")
    private String movil;
    
    /**
     * Password
     */
    // @Size(min = 4, max = 20, message = "La contrassenya ha de tenir entre 4 i 20 caracters")
    private String password;
    
    /**
     * Catigoria
     */
    private CategoriaTrabajador categoria;
    
    /**
     * Identificador del equipo
     */
    private String id_equipo;
    
    /**
     * Equipo
     */
    private Equipo equipo;
    
    /**
     * Categoria a buscar
     */
    private CategoriaTrabajador categoriaSearch;

    /**
     * Constructor vacio
     */
    public TrabajadorCrudForm() {
    }

    /**
     * Getter del equipo
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Setter del equipo
     * @param equipo equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Getter del identificador del trabajador
     * @return Identificador del trabajador
     */
    public long getId_trab() {
        return id_trab;
    }

    /**
     * Setter del identificador del trabajador
     * @param id_trab identificador del trabajador
     */
    public void setId_trab(long id_trab) {
        this.id_trab = id_trab;
    }

    /**
     * Getter del nif
     * @return nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter del nif
     * @param nif nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Getter del nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del movil
     * @return movil
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Setter del movil
     * @param movil movil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Getter del password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter del password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter de la categoria del trabajador
     * @return categoria del trabajador
     */
    public CategoriaTrabajador getCategoria() {
        return categoria;
    }

    /**
     * Setter de la categoria del trabajador
     * @param categoria categoria del trabajador
     */
    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }

    /**
     * Getter del identificador del equipo
     * @return identificador del equipo
     */
    public String getId_equipo() {
        return id_equipo;
    }

    /**
     * Setter del identificador del equipo
     * @param id_equipo identificador del equipo
     */
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * Getter de la categoria a buscar
     * @return categoria a buscar
     */
    public CategoriaTrabajador getCategoriaSearch() {
        return categoriaSearch;
    }

    /**
     * Setter de la categoria a buscar
     * @param categoriaSearch categoria a buscar
     */
    public void setCategoriaSearch(CategoriaTrabajador categoriaSearch) {
        this.categoriaSearch = categoriaSearch;
    }

    /**
     * Metodo toString para devolver informacion del objeto TrabajadorCrudForm
     * @return información del objeto TrabajadorCrudForm
     */
    @Override
    public String toString() {
        return "TrabajadorCrudForm{" + "id_trab=" + id_trab + ", nif=" + nif + ", nombre=" + nombre + ", movil=" + movil + ", password=" + password + ", categoria=" + categoria + ", equipo=" + id_equipo + ", categoriaSearch=" + categoriaSearch + '}';
    }
    
}
