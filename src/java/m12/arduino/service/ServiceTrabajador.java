package m12.arduino.service;

import java.util.ArrayList;
import java.util.List;
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

    private DaoTrabajadorImpl dT = new DaoTrabajadorImpl();

    public boolean insertarTrabajador(Trabajador trab) {
        Trabajador auxTrab = this.dT.buscarTrabajador(trab.getNif());
        if (auxTrab == null) {
            Trabajador aux = dT.guardaActualizaTrabajador(trab);
            if (aux == null) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Trabajador actualizaTrabajdor(Trabajador trab) {
        return dT.actualizaTrabajador(trab);
    }

    public Trabajador buscaTrabajador(String nif) {
        return dT.buscarTrabajador(nif);
    }

    public List<Trabajador> listaTrabajador() {
        return dT.obtenListaTrabajador();
    }

    /* must be deleted */
    public List listaTrabajadores() {
        List<Trabajador> trab = new ArrayList();
        Equipo eq = new Equipo();
        eq.setNombre("Equipo1");

        Trabajador tr1 = new Trabajador();
        tr1.setNombre("Jordi");
        tr1.setNif("12345678A");
        tr1.setMovil("687543210");
        tr1.setPassword("myPassword1");
        tr1.setCategoria(CategoriaTrabajador.LEADER);
        tr1.setEquipo(eq);
        Trabajador tr2 = new Trabajador();
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
