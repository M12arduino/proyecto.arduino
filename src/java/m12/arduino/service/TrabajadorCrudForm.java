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
 *
 * @author enric
 */
public class TrabajadorCrudForm {
    

    private long id_trab;
    // @Pattern(regexp = "(^\\d{8})([\\s-]?)([a-zA-Z]$)", message = "Format del DNI incorrecte")
    // @NotNull(message = "El camp dni no pot estar buit")
    private String nif;
    //  @Pattern(regexp = "(^[\\w\\s]{2,15})", message = "Format del Nom incorrecte")
    private String nombre;
    // @Pattern(regexp = "(^[6-7])(\\d{8})$", message = "Format del MOBIL incorrecte")
    private String movil;
    // @Size(min = 4, max = 20, message = "La contrassenya ha de tenir entre 4 i 20 caracters")
    private String password;
    private CategoriaTrabajador categoria;
    private Equipo equipo;
    private CategoriaTrabajador categoriaSearch;

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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public CategoriaTrabajador getCategoriaSearch() {
        return categoriaSearch;
    }

    public void setCategoriaSearch(CategoriaTrabajador categoriaSearch) {
        this.categoriaSearch = categoriaSearch;
    }
    
    
}