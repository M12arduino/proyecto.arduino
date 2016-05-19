package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dO.buscarOrden(condiciones);
    }
    
    public List<OrdenFabricacion> listarOrdenes() {
        return dO.obtenerListaOrdenes();
    }

    public List<OrdenFabricacion> listarOrdenes(Object... vars) {
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dO.obtenerListaOrdenes(condiciones);
    }

    public boolean insertarOrden(OrdenFabricacion ord) {
        dO.guardarOrden(ord);
        return true;
    }

    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord) {
        return dO.actualizarOrden(ord);
    }
}
