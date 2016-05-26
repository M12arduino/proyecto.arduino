/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.Calendar;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import m12.arduino.domain.Accion;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.EstadoOrden;
import m12.arduino.domain.Prioridad;
import m12.arduino.domain.Proceso;
import m12.arduino.domain.Robot;
import m12.arduino.domain.Trabajador;

/**
 *
 * @author enric
 */
public class OrdenFabricacionArduino {
    
     // ATTR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    private Prioridad proridad;
    private List<Accion> acciones;

    public OrdenFabricacionArduino() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prioridad getProridad() {
        return proridad;
    }

    public void setProridad(Prioridad proridad) {
        this.proridad = proridad;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    

    
}
