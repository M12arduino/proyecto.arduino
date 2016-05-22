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
    private Long id;
    private String codigo;
    private String descripcion;
    private String accionesJSON;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAccionesJSON() {
        return accionesJSON;
    }

    public void setAccionesJSON(String accionesJSON) {
        this.accionesJSON = accionesJSON;
    }

}
