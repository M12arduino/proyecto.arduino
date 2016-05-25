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
    private String codigo_proceso;
    private int cantidad;
    private String id_robot;
    private long codigo_proceso_id;
    private long id_robot_id;
    
    public long getCodigo_proceso_id() {
        return codigo_proceso_id;
    }

    public void setCodigo_proceso_id(long codigo_proceso_id) {
        this.codigo_proceso_id = codigo_proceso_id;
    }

    public long getId_robot_id() {
        return id_robot_id;
    }

    // fecha y estado assignadas por defecto
    public void setId_robot_id(long id_robot_id) {
        this.id_robot_id = id_robot_id;
    }

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

    public String getCodigo_proceso() {
        return codigo_proceso;
    }

    public void setCodigo_proceso(String codigo_proceso) {
        this.codigo_proceso = codigo_proceso;
    }

    public String getId_robot() {
        return id_robot;
    }

    public void setId_robot(String id_robot) {
        this.id_robot = id_robot;
    }






    
 
}
