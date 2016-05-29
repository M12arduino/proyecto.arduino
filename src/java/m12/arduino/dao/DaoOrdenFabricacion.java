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
 * Controlador implementable para los objetos OrdenFabricacion.
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface DaoOrdenFabricacion {

    /**
     * Metodo implementable para buscar una orden de fabricacion en la base de datos.
     * @param codigo String con el codigo de la orden de fabricacion a buscar.
     * @return Devuelve un Objeto OrdenFabricacion correspondiente al codigo proporcionado.
     */
    public OrdenFabricacion buscarOrden(String codigo);
    
    /**
     * Metodo implementable para buscar ordenes de fabricacion en la base de datos.
     * @param whereMap objeto Map con la información para buscar ordenes de fabricacion. 
     * @return Devuelve un Objeto OrdenFabricacion que coincide con la información 
     * proporcionada.
     */
    public OrdenFabricacion buscarOrden(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar las ordenes de fabricacion de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * ordenes de fabricacion. 
     * @return Devuelve un objeto List de las ordenes de fabricacion que coinciden con la 
     * información proporcionada.
     */
    public List<OrdenFabricacion> obtenerListaOrdenes(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar las ordenes de fabricacion de la base de datos.
     * @return Devuelve un Objeto List con las ordenes de fabricacion de la base de datos.
     */
    public List<OrdenFabricacion> obtenerListaOrdenes();

    /**
     * Metodo implementable para guardar ordenes de fabricacion en la base de datos.
     * @param ord objeto OrdenFabricacion a guardar.
     * @return Devuelve el objeto OrdenFabricacion guardado.
     */
    public OrdenFabricacion guardarOrden(OrdenFabricacion ord);

    /**
     * Metodo implementable para actualizar ordenes de fabricacion de la base de datos.
     * @param ord objeto OrdenFabricacion a actualizar.
     * @return Devuelve el objeto OrdenFabricacion actualizado.
     */
    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord);
    
    /**
     * Metodo implementable para eliminar ordenes de fabricacion de la base de datos.
     * @param ord objeto OrdenFabricacion a eliminar.
     */
    public void eliminarOrden(OrdenFabricacion ord);
}
