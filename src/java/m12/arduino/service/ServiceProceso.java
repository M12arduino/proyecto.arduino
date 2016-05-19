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

    public void eliminarProceso(Proceso pro){
        dP.eliminarProceso(pro);
    }
    
    public Proceso buscarProceso(String codigo) {
        return dP.buscarProceso(codigo);
    }

    public Proceso buscarProceso(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dP.buscarProceso(condiciones);
    }
    
    public List<Proceso> listarProcesos() {
        return dP.obtenerListaProcesos();
    }

    public List<Proceso> listarProcesos(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dP.obtenerListaProcesos(condiciones);
    }

    public boolean insertarProceso(Proceso pro) {
        dP.guardarProceso(pro);
        return true;
    }

    public Proceso actualizarProceso(Proceso pro) {
        return dP.actualizarProceso(pro);
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
