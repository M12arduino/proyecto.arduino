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
 *
 * @author Couto
 */
public class ServiceProceso {

    private final DaoProcesoImpl dP = new DaoProcesoImpl();

    public Proceso buscarProceso(String nombre) {
        return dP.buscarProceso(nombre);
    }

    public List<Proceso> listarProcesos() {
        return dP.obtenerListaProcesos();
    }

    public List<Proceso> listarProcesos(String... str) {
        Map condiciones = new HashMap();
        for (int i = 0; i < str.length; i++) {
            condiciones.put(str[i], str[i + 1]);
            i++;
        }
        return dP.obtenerListaProcesos(condiciones);
    }

    public boolean insertarProceso(Proceso pro) {
        dP.guardarProceso(pro);
        return true;
    }

    public Proceso actualizarProceso(Proceso pro) {
        return dP.actualizarProceso(pro);
    }
}
