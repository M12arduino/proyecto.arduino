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

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
public class ServiceTrabajador {

    private final DaoTrabajadorImpl dT = new DaoTrabajadorImpl();

    public void eliminarTrabajador(Trabajador trabajador) {
        dT.eliminarTrabajador(trabajador);
    }

    public Trabajador buscarTrabajador(String nombre) {
        return dT.buscarTrabajador(nombre);
    }

    public Trabajador buscarTrabajador(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dT.buscarTrabajador(condiciones);
    }

    public List<Trabajador> listarTrabajadores() {
        return dT.obtenerListaTrabajadores();
    }

    public List<Trabajador> listarTrabajadores(Object... vars) {
        //System.out.println(vars+"#######################################################");
        Map<String, Object> condiciones = constructConditions(vars);
        return dT.obtenerListaTrabajadores(condiciones);
    }

    public Trabajador insertarTrabajador(Trabajador trab) {
        return dT.guardarTrabajador(trab);
    }

    public Trabajador actualizarTrabajador(Trabajador trab) {
        return dT.actualizarTrabajador(trab);
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
