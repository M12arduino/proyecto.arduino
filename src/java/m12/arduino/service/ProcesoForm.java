/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.List;


/**
 *
 * @author Couto
 */
public class ProcesoForm {
    
    // ATTR
    private String descripcion;
    private List<String> acciones;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<String> acciones) {
        this.acciones = acciones;
    }
    
    public void addAccion(String accion){
        this.getAcciones().add(accion);
    }
    
}
