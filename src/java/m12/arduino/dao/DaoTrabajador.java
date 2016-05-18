package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Trabajador;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
public interface DaoTrabajador {

    public Trabajador buscarTrabajador(String nif);

    public Trabajador buscarTrabajador(Map<String, Object> whereMap);
    
    public List<Trabajador> obtenerListaTrabajadores(Map<String, Object> whereMap);

    public List<Trabajador> obtenerListaTrabajadores();

    public Trabajador guardarTrabajador(Trabajador trab);

    public Trabajador actualizarTrabajador(Trabajador trab);

}
