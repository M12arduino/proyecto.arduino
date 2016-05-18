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
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dE.buscarEquipo(condiciones);
    }

    public List<Equipo> listarEquipos() {
        return dE.obtenerListaEquipos();
    }

    public List<Equipo> listarEquipos(Object... vars) {
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dE.obtenerListaEquipos(condiciones);
    }

    public boolean insertarEquipo(Equipo equ) {
        dE.guardarEquipo(equ);
        return true;
    }

    public Equipo actualizarEquipo(Equipo equ) {
        return dE.actualizarEquipo(equ);
    }
}
