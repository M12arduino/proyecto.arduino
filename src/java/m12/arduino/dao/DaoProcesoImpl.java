package m12.arduino.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m12.arduino.domain.Accion;
import m12.arduino.domain.Proceso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Controlador para los objetos Proceso.
 * @author Enric, Pablo, Jordi y Oscar
 */
public class DaoProcesoImpl implements DaoProceso {

    private Session session;
    private Transaction tx;

    /**
     * Metodo que abre la sesion e inicia la transaccion.
     */
    public void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    /**
     * Metodo que hace el commit y cierra la conexion.
     */
    public void acabaOperacion() {
        tx.commit();
        session.close();
    }

    /**
     * Metodo para buscar un proceso en la base de datos.
     * @param codigo String con el codigo del proceso a buscar.
     * @return Devuelve un Objeto Proceso correspondiente al codigo proporcionado.
     */
    @Override
    public Proceso buscarProceso(String codigo) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Proceso p WHERE p.codigo =:codigo ");
        q.setParameter("codigo", codigo);
        Proceso res = (Proceso) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los procesos de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * procesos. 
     * @return Devuelve un objeto List de los procesos que coinciden con la 
     * información proporcionada.
     */
    @Override
    public List<Proceso> obtenerListaProcesos(Map<String, Object> whereMap) {
        iniciaOperacion();
        //Create where block
        String str = "";
        Set keys = whereMap.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            if (it.hasNext()) {
                String currentKey = it.next();
                String operator = "=";
                if (whereMap.get(currentKey) instanceof String){
                    operator = " LIKE ";
                }
                str += currentKey +operator+" :" + currentKey + " ";
            }
            if (it.hasNext()) {
                str += " and ";
            }
        }
        if (str != "") {
            str = "WHERE " + str;
        }
        // Complete query-string
        Query query = session.createQuery("FROM Proceso " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            Object val = e.getValue();
            if (val instanceof String) {
                query.setParameter(attr, "%" + val + "%");
            } else {
                query.setParameter(attr, val);
            };
        }
        List<Proceso> res = query.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los procesos de la base de datos.
     * @return Devuelve un Objeto List con los procesos de la base de datos.
     */
    @Override
    public List<Proceso> obtenerListaProcesos() {
        iniciaOperacion();
        Query q = session.createQuery("FROM Proceso");
        List<Proceso> res = q.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para guardar procesos en la base de datos.
     * @param pro objeto Proceso a guardar.
     * @return Devuelve el objeto Proceso guardado.
     */
    @Override
    public Proceso guardarProceso(Proceso pro) {
        iniciaOperacion();
        session.persist(pro);
        acabaOperacion();
        return this.buscarProceso(pro.getCodigo());
    }

    /**
     * Metodo para actualizar procesos de la base de datos.
     * @param pro objeto Proceso a actualizar.
     * @return Devuelve el objeto Proceso actualizado.
     */
    @Override
    public Proceso actualizarProceso(Proceso pro) {
        iniciaOperacion();
        session.update(pro);
        acabaOperacion();
        return pro;
    }

    /**
     * Metodo para buscar procesos en la base de datos.
     * @param whereMap objeto Map con la información para buscar procesos. 
     * @return Devuelve un Objeto Proceso que coincide con la información proporcionada.
     */
    @Override
    public Proceso buscarProceso(Map<String, Object> whereMap) {
        return obtenerListaProcesos(whereMap).get(0);
    }

    /**
     * Metodo para eliminar procesos de la base de datos.
     * @param pro objeto Proceso a eliminar.
     */
    @Override
    public void eliminarProceso(Proceso pro) {
        iniciaOperacion();
        session.delete(pro);
        acabaOperacion();
    }

}
