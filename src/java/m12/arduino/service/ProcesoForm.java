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
    private String codi;
    private String descripcion;
    private String accionesJSON;

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

    public String getAccionesJSON() {
        return accionesJSON;
    }

    public void setAccionesJSON(String accionesJSON) {
        this.accionesJSON = accionesJSON;
    }

}
