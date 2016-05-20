package m12.arduino.service;

import m12.arduino.domain.Prioridad;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class OrdenFabricacionForm {

    private String codigo;
    private String descripcion;
    private Prioridad prioridad;
    private String codigo_proceso;
    private int cantidad;
    private String id_robot;
    // fecha y estado assignadas por defecto

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

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_robot() {
        return id_robot;
    }

    public void setId_robot(String id_robot) {
        this.id_robot = id_robot;
    }

    public String getCodigo_proceso() {
        return codigo_proceso;
    }

    public void setCodigo_proceso(String codigo_proceso) {
        this.codigo_proceso = codigo_proceso;
    }
    
 
}
