package m12.arduino.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Trabajador buscarTrabajador(String nombre) {
        return dT.buscarTrabajador(nombre);
    }

    public Trabajador buscarTrabajador(Object... vars) {
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dT.buscarTrabajador(condiciones);
    }

    public List<Trabajador> listarTrabajadores() {
        return dT.obtenerListaTrabajadores();
    }

    public List<Trabajador> listarTrabajadores(Object... vars) {
        Map<String, Object> condiciones = new HashMap();
        for (int i = 0; i < vars.length; i++) {
            condiciones.put((String) vars[i], vars[i + 1]);
            i++;
        }
        return dT.obtenerListaTrabajadores(condiciones);
    }

    public boolean insertarTrabajador(Trabajador trab) {
        dT.guardarTrabajador(trab);
        return true;
    }

    public Trabajador actualizarTrabajador(Trabajador trab) {
        return dT.actualizarTrabajador(trab);
    }

    /* must be deleted */
    public List baseTrabajadores() {
        List<Trabajador> trab = new ArrayList();
        Equipo eq = new Equipo();
        eq.setNombre("Equipo1");

        Trabajador tr1 = new Trabajador();
        tr1.setId_trab(1);
        tr1.setNombre("Jordi");
        tr1.setNif("12345678A");
        tr1.setMovil("687543210");
        tr1.setPassword("myPassword1");
        tr1.setCategoria(CategoriaTrabajador.LEADER);
        tr1.setEquipo(eq);
        Trabajador tr2 = new Trabajador();
        tr2.setId_trab(2);
        tr2.setNombre("Pablo");
        tr2.setNif("187654321A");
        tr2.setMovil("987654321");
        tr2.setPassword("myPassword2");
        tr2.setCategoria(CategoriaTrabajador.MANAGER);
        tr2.setEquipo(eq);
        trab.add(tr1);
        trab.add(tr2);
        return trab;
    }

}
