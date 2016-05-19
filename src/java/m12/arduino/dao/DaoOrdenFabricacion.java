/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.OrdenFabricacion;

/**
 *
 * @author Jordi
 */
public interface DaoOrdenFabricacion {

    public OrdenFabricacion buscarOrden(String nombre);
    
    public OrdenFabricacion buscarOrden(Map<String, Object> whereMap);

    public List<OrdenFabricacion> obtenerListaOrdenes(Map<String, Object> whereMap);

    public List<OrdenFabricacion> obtenerListaOrdenes();

    public OrdenFabricacion guardarOrden(OrdenFabricacion ord);

    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord);
}
