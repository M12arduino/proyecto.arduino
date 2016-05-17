package m12.arduino.service;

import java.util.List;
import m12.arduino.dao.DaoTrabajador;
import m12.arduino.dao.DaoTrabajadorImpl;
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
            if (aux == null) return false; else return true;
        } else {
            return false;
        }
    }
    
    public Trabajador actualizaTrabajdor(Trabajador trab){
        return dT.actualizaTrabajador(trab);
    }
    public Trabajador buscaTrabajador(String nif){
        return dT.buscarTrabajador(nif);
    }
    public List<Trabajador> listaTrabajador(){
        return dT.obtenListaTrabajador();
    }
    
}
