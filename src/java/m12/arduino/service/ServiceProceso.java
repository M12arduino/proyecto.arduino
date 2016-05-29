/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m12.arduino.dao.DaoProcesoImpl;
import m12.arduino.domain.Proceso;

/**
 * Clase ServiceProceso que se apoya en la clase DaoProcesoImpl
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ServiceProceso {

    /**
     * Objeto DaoProcesoImpl para el trato de datos
     */
    private final DaoProcesoImpl dP = new DaoProcesoImpl();

    /**
     * Metodo para eliminar un proceso.
     * @param pro objeto Proceso a eliminar.
     */
    public void eliminarProceso(Proceso pro){
        dP.eliminarProceso(pro);
    }
    
    /**
     * Metodo para buscar un proceso por codigo.
     * @param codigo String con el codigo del proceso a buscar.
     * @return Devuelve un Objeto Proceso correspondiente al codigo proporcionado.
     */
    public Proceso buscarProceso(String codigo) {
        return dP.buscarProceso(codigo);
    }

    /**
     * Metodo para buscar un proceso por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un objeto Proceso que coincida con los
     * parametros proporcionados
     */
    public Proceso buscarProceso(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dP.buscarProceso(condiciones);
    }
    
    /**
     * Metodo para listar los procesos.
     * @return Devuelve un Objeto List con los procesos.
     */
    public List<Proceso> listarProcesos() {
        return dP.obtenerListaProcesos();
    }

    /**
     * Metodo para listar los procesos filtrados por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un objeto List de los procesos que coinciden con los
     * parametros proporcionados
     */
    public List<Proceso> listarProcesos(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dP.obtenerListaProcesos(condiciones);
    }

    /**
     * Metodo para insertar procesos.
     * @param pro objeto Proceso a insertar.
     * @return Devuelve el objeto Proceso insertado.
     */
    public Proceso insertarProceso(Proceso pro) {
        return dP.guardarProceso(pro);
    }

    /**
     * Metodo para actualizar un proceso.
     * @param pro objeto Proceso a actualizar.
     * @return Devuelve el objeto Proceso actualizado.
     */
    public Proceso actualizarProceso(Proceso pro) {
        return dP.actualizarProceso(pro);
    }
    
    /**
     * Metodo que construye el Map a partir de los parametros que recibe
     * @param str parametros de busqueda
     * @return Devuelve un objeto Map hecho a partir de los parametros
     */    
    public Map<String, Object> constructConditions(Object... str) {
        Map<String, Object> conditions = new HashMap<String, Object>();
        for (int i = 0; i <= str.length - 2; i += 2) {
            if (str[i] != null & str[i + 1] != null) {
                if (!str[i].equals("") & !str[i + 1].equals("")) {
                    conditions.put((String) str[i], str[i + 1]);
                    System.out.println("I:" + str[i] + "i+1:" + str[i + 1]);
                }
            }
        }
        return conditions;
    }
}
