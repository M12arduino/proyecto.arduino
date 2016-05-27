/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Proceso;

/**
 * Controlador implementable para los objetos Proceso.
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface DaoProceso {

    /**
     * Metodo implementable para buscar un proceso en la base de datos.
     * @param codigo String con el codigo del proceso a buscar.
     * @return Devuelve un Objeto Proceso correspondiente al codigo proporcionado.
     */
    public Proceso buscarProceso(String codigo);
    
    /**
     * Metodo implementable para buscar procesos en la base de datos.
     * @param whereMap objeto Map con la información para buscar procesos. 
     * @return Devuelve un Objeto Proceso que coincide con la información proporcionada.
     */
    public Proceso buscarProceso(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los procesos de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * procesos. 
     * @return Devuelve un objeto List de los procesos que coinciden con la 
     * información proporcionada.
     */
    public List<Proceso> obtenerListaProcesos(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los procesos de la base de datos.
     * @return Devuelve un Objeto List con los procesos de la base de datos.
     */
    public List<Proceso> obtenerListaProcesos();

    /**
     * Metodo implementable para guardar procesos en la base de datos.
     * @param pro objeto Proceso a guardar.
     * @return Devuelve el objeto Proceso guardado.
     */
    public Proceso guardarProceso(Proceso pro);

    /**
     * Metodo implementable para actualizar procesos de la base de datos.
     * @param pro objeto Proceso a actualizar.
     * @return Devuelve el objeto Proceso actualizado.
     */
    public Proceso actualizarProceso(Proceso pro);
    
    /**
     * Metodo implementable para eliminar procesos de la base de datos.
     * @param pro objeto Proceso a eliminar.
     */
    public void eliminarProceso(Proceso pro);
}
