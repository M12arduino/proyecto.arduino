package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Trabajador;

/**
 * Controlador implementable para los objetos Trabajador.
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface DaoTrabajador {

    /**
     * Metodo implementable para buscar un trabajador en la base de datos.
     * @param nif String con el nif del trabajador a buscar.
     * @return Devuelve un Objeto Trabajador correspondiente al nif proporcionado.
     */
    public Trabajador buscarTrabajador(String nif);

    /**
     * Metodo implementable para buscar trabajadores en la base de datos.
     * @param whereMap objeto Map con la información para buscar trabajadores. 
     * @return Devuelve un Objeto Trabajador que coincide con la información proporcionada.
     */
    public Trabajador buscarTrabajador(Map<String, Object> whereMap);
    
    /**
     * Metodo implementable para listar los trabajadores de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * trabajadores. 
     * @return Devuelve un objeto List de los trabajadores que coinciden con la 
     * información proporcionada.
     */
    public List<Trabajador> obtenerListaTrabajadores(Map<String, Object> whereMap);

    /**
     * Metodo implementable para listar los trabajadores de la base de datos.
     * @return Devuelve un Objeto List con los trabajadores de la base de datos.
     */
    public List<Trabajador> obtenerListaTrabajadores();

    /**
     * Metodo implementable para guardar trabajadores en la base de datos.
     * @param trab objeto Trabajador a guardar.
     * @return Devuelve el objeto Trabajador guardado.
     */
    public Trabajador guardarTrabajador(Trabajador trab);

    /**
     * Metodo implementable para actualizar trabajadores de la base de datos.
     * @param trab objeto Trabajador a actualizar.
     * @return Devuelve el objeto Trabajador actualizado.
     */
    public Trabajador actualizarTrabajador(Trabajador trab);
    
    /**
     * Metodo implementable para eliminar trabajadores de la base de datos.
     * @param trab objeto Trabajador a eliminar.
     */
    public void eliminarTrabajador(Trabajador trab);
}
