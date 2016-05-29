package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import m12.arduino.dao.DaoOrdenFabricacionImpl;
import m12.arduino.domain.OrdenFabricacion;

/**
 * Clase ServiceOrdenFabricacion que se apoya en la clase DaoOrdenFabricacionImpl
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ServiceOrdenFabricacion {

    /**
     * Objeto DaoOrdenFabricacionImpl para el trato de datos
     */
    private final DaoOrdenFabricacionImpl dO = new DaoOrdenFabricacionImpl();

    /**
     * Metodo para buscar una orden de fabricacion por codigo.
     * @param codigo codigo de la orden de fabricacion a buscar.
     * @return Devuelve un Objeto OrdenFabricacion correspondiente al codigo proporcionado.
     */
    public OrdenFabricacion buscarOrden(String codigo) {
        return dO.buscarOrden(codigo);
    }

    /**
     * Metodo para buscar ordenes de fabricacion por parametros.
     * @param vars parametros de la orden de fabricacion a buscar. 
     * @return Devuelve un Objeto OrdenFabricacion que coincide con los parametros 
     * proporcionados.
     */
    public OrdenFabricacion buscarOrden(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dO.buscarOrden(condiciones);
    }

    /**
     * Metodo para listar las ordenes de fabricacion.
     * @return Devuelve un Objeto List con las ordenes de fabricacion.
     */
    public List<OrdenFabricacion> listarOrdenes() {
        return dO.obtenerListaOrdenes();
    }

    /**
     * Metodo para listar las ordenes de fabricacion filtradas por parametros.
     * @param vars parametros para la busqueda
     * @return Devuelve un objeto List de las ordenes de fabricacion que coinciden
     * con los parametros proporcionados.
     */
    public List<OrdenFabricacion> listarOrdenes(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dO.obtenerListaOrdenes(condiciones);
    }

    /**
     * Metodo para insertar ordenes de fabricacion.
     * @param ord objeto OrdenFabricacion a insertar.
     * @return Devuelve el objeto OrdenFabricacion insertado.
     */
    public OrdenFabricacion insertarOrden(OrdenFabricacion ord) {
        return dO.guardarOrden(ord);
    }

    /**
     * Metodo para actualizar una orden de fabricacion.
     * @param ord objeto OrdenFabricacion a actualizar.
     * @return Devuelve el objeto OrdenFabricacion actualizado.
     */
    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord) {
        return dO.actualizarOrden(ord);
    }

    /**
     * Metodo para eliminar una orden de fabricacion.
     * @param ord objeto OrdenFabricacion a eliminar.
     */
    public void eliminarOrden(OrdenFabricacion ord) {
        dO.eliminarOrden(ord);
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
