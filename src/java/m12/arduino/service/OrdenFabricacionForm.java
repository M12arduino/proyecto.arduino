package m12.arduino.service;

import java.util.List;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.Prioridad;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class OrdenFabricacionForm {

    private Long id;
    private String codigo;
    private String descripcion;
    private Prioridad prioridad;
    private Long equipo_id;
    private long codigo_proceso;
    private int cantidad;
    private long id_robot;
    // fecha y estado assignadas por defecto

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Long equipo_id) {
        this.equipo_id = equipo_id;
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

    public long getId_robot() {
        return id_robot;
    }

    public void setId_robot(long id_robot) {
        this.id_robot = id_robot;
    }

    public long getCodigo_proceso() {
        return codigo_proceso;
    }

    public void setCodigo_proceso(long codigo_proceso) {
        this.codigo_proceso = codigo_proceso;
    }




    
 
}
