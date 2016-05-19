/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m12.arduino.dao.DaoEquipoImpl;
import m12.arduino.domain.Equipo;

/**
 *
 * @author enric
 */
public class ServiceEquipo {

    private final DaoEquipoImpl dE = new DaoEquipoImpl();

    public Equipo buscarEquipo(String nombre) {
        return dE.buscarEquipo(nombre);
    }

    public Equipo buscarEquipo(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dE.buscarEquipo(condiciones);
    }

    public List<Equipo> listarEquipos() {
        return dE.obtenerListaEquipos();
    }

    public List<Equipo> listarEquipos(Object... vars) {
        Map<String, Object> condiciones = constructConditions(vars);
        return dE.obtenerListaEquipos(condiciones);
    }

    public boolean insertarEquipo(Equipo equ) {
        dE.guardarEquipo(equ);
        return true;
    }

    public Equipo actualizarEquipo(Equipo equ) {
        return dE.actualizarEquipo(equ);
    }

    public void eliminarEquipo(Equipo equ) {
        dE.eliminarEquipo(equ);
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
