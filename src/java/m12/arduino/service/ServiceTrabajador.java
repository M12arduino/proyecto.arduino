package m12.arduino.service;

import m12.arduino.dao.DaoTrabajador;
import m12.arduino.domain.Trabajador;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class ServiceTrabajador {

    public static boolean insertarTrabajador(Trabajador trab) {
        DaoTrabajador dT = new DaoTrabajador();
        Trabajador auxTrab = dT.buscarTrabajador(trab.getNif());
        if (auxTrab == null) {
            return dT.guardaActualizaTrabajador(trab);
        } else {
            return false;
        }
    }
    
}
