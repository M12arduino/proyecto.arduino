/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Couto
 */
public class ProcesoForm {
    
    // ATTR
    private String titulo;
    private String descripcion;
    private String accionesJSON;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccionesJSON() {
        return accionesJSON;
    }

    public void setAccionesJSON(String accionesJSON) {
        this.accionesJSON = accionesJSON;
    }

}
