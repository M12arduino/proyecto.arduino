/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;

/**
 * Clase TrabajadorCrudForm
 *
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
    //@Pattern(regexp = "(^\\d{8})([\\s-]?)([a-zA-Z]$)", message = "Format del DNI incorrecte")
    @NotNull(message = "El campo dni no puede estar vacio")
    private String nif;

    /**
     * Nombre
     */
    @Size(min = 1, max = 50, message = "El nombre tiene un maximo de 50 caracteres")
    private String nombre;

    /**
     * Movil
     */
    @Pattern(regexp = "(^[6-7])(\\d{8})$", message = "Formato del MOBIL incorrecto")
    private String movil;

    /**
     * Password
     */
    @Size(min = 4, max = 20, message = "La contraseña ha de tener entre 4 y 20 caracteres")
    private String password;

    /**
     * Catigoria
     */
    @NotNull(message = "Es obligatorio seleccionar una categoria")
    private CategoriaTrabajador categoria;

    /**
     * Identificador del equipo
     */
    @Pattern(regexp = "([A-Z]{2}[0-9]{4})", message = "Formato del id del equipo incorrecto")
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
     *
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Setter del equipo
     *
     * @param equipo equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Getter del identificador del trabajador
     *
     * @return Identificador del trabajador
     */
    public long getId_trab() {
        return id_trab;
    }

    /**
     * Setter del identificador del trabajador
     *
     * @param id_trab identificador del trabajador
     */
    public void setId_trab(long id_trab) {
        this.id_trab = id_trab;
    }

    /**
     * Getter del nif
     *
     * @return nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter del nif
     *
     * @param nif nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Getter del nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     *
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del movil
     *
     * @return movil
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Setter del movil
     *
     * @param movil movil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * Getter del password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter del password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter de la categoria del trabajador
     *
     * @return categoria del trabajador
     */
    public CategoriaTrabajador getCategoria() {
        return categoria;
    }

    /**
     * Setter de la categoria del trabajador
     *
     * @param categoria categoria del trabajador
     */
    public void setCategoria(CategoriaTrabajador categoria) {
        this.categoria = categoria;
    }

    /**
     * Getter del identificador del equipo
     *
     * @return identificador del equipo
     */
    public String getId_equipo() {
        return id_equipo;
    }

    /**
     * Setter del identificador del equipo
     *
     * @param id_equipo identificador del equipo
     */
    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * Getter de la categoria a buscar
     *
     * @return categoria a buscar
     */
    public CategoriaTrabajador getCategoriaSearch() {
        return categoriaSearch;
    }

    /**
     * Setter de la categoria a buscar
     *
     * @param categoriaSearch categoria a buscar
     */
    public void setCategoriaSearch(CategoriaTrabajador categoriaSearch) {
        this.categoriaSearch = categoriaSearch;
    }

    /**
     * Metodo toString para devolver informacion del objeto TrabajadorCrudForm
     *
     * @return información del objeto TrabajadorCrudForm
     */
    @Override
    public String toString() {
        return "TrabajadorCrudForm{" + "id_trab=" + id_trab + ", nif=" + nif + ", nombre=" + nombre + ", movil=" + movil + ", password=" + password + ", categoria=" + categoria + ", equipo=" + id_equipo + ", categoriaSearch=" + categoriaSearch + '}';
    }

}
