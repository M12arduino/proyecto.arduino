package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import m12.arduino.dao.DaoOrdenFabricacionImpl;
import m12.arduino.domain.OrdenFabricacion;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
public class ServiceOrdenFabricacion {

    private final DaoOrdenFabricacionImpl dO = new DaoOrdenFabricacionImpl();

    public OrdenFabricacion buscarOrden(String nombre) {
        return dO.buscarOrden(nombre);
    }

    public OrdenFabricacion buscarOrden(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dO.buscarOrden(condiciones);
    }

    public List<OrdenFabricacion> listarOrdenes() {
        return dO.obtenerListaOrdenes();
    }

    public List<OrdenFabricacion> listarOrdenes(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dO.obtenerListaOrdenes(condiciones);
    }

    public boolean insertarOrden(OrdenFabricacion ord) {
        dO.guardarOrden(ord);
        return true;
    }

    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord) {
        return dO.actualizarOrden(ord);
    }

    public void eliminarOrden(OrdenFabricacion ord) {
        dO.eliminarOrden(ord);
    }

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
