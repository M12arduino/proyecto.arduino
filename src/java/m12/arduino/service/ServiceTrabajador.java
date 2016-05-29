package m12.arduino.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import m12.arduino.dao.DaoTrabajador;
import m12.arduino.dao.DaoTrabajadorImpl;
import m12.arduino.domain.CategoriaTrabajador;
import m12.arduino.domain.Equipo;
import m12.arduino.domain.Trabajador;

/**
 * Clase ServiceTrabajador que se apoya en la clase DaoTrabajadorImpl
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ServiceTrabajador {

    /**
     * Objeto DaoTrabajadorImpl para el trato de datos
     */
    private final DaoTrabajadorImpl dT = new DaoTrabajadorImpl();

    /**
     * Metodo para eliminar un trabajador.
     * @param trabajador objeto Trabajador a eliminar.
     */
    public void eliminarTrabajador(Trabajador trabajador) {
        dT.eliminarTrabajador(trabajador);
    }

    /**
     * Metodo para buscar un trabajador por nif.
     * @param nif String con el nif del trabajador a buscar.
     * @return Devuelve un Objeto Trabajador correspondiente al nif proporcionado.
     */
    public Trabajador buscarTrabajador(String nif) {
        return dT.buscarTrabajador(nif);
    }

    /**
     * Metodo para buscar un trabajador por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un Objeto Trabajador que coincide con los parametros proporcionados
     */
    public Trabajador buscarTrabajador(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dT.buscarTrabajador(condiciones);
    }

    /**
     * Metodo para listar los trabajadores.
     * @return Devuelve un Objeto List con los trabajadores.
     */
    public List<Trabajador> listarTrabajadores() {
        return dT.obtenerListaTrabajadores();
    }

    /**
     * Metodo para listar trabajadores filtrados por parametros
     * @param vars parametros para la busqueda
     * @return Devuelve un Objeto List de los trabajadores que coinciden con los
     * parametros proporcionados
     */
    public List<Trabajador> listarTrabajadores(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dT.obtenerListaTrabajadores(condiciones);
    }

    /**
     * Metodo para insertar trabajadores.
     * @param trab objeto Trabajador a insertar.
     * @return Devuelve el objeto Trabajador insertado.
     */
    public Trabajador insertarTrabajador(Trabajador trab) {
        return dT.guardarTrabajador(trab);
    }

    /**
     * Metodo para actualizar un trabajador.
     * @param trab objeto Trabajador a actualizar.
     * @return Devuelve el objeto Trabajador actualizado.
     */
    public Trabajador actualizarTrabajador(Trabajador trab) {
        return dT.actualizarTrabajador(trab);
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
