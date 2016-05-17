package m12.arduino.dao;

import java.util.List;
import m12.arduino.domain.Trabajador;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public interface DaoTrabajador {

    public Trabajador buscarTrabajador(String nif);
    public List<Trabajador> obtenListaTrabajador();
    public Trabajador guardaActualizaTrabajador(Trabajador trab);
    public Trabajador actualizaTrabajador(Trabajador trab);

}
