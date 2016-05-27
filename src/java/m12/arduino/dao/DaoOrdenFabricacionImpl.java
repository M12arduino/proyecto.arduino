package m12.arduino.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m12.arduino.domain.OrdenFabricacion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Controlador para los objetos OrdenFabricacion.
 * @author Enric, Pablo, Jordi y Oscar
 */
public class DaoOrdenFabricacionImpl implements DaoOrdenFabricacion {

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

    @Override
    public OrdenFabricacion buscarOrden(String codigo) {
        iniciaOperacion();
        Query q = session.createQuery("FROM OrdenFabricacion o WHERE o.codigo =:codigo ");
        q.setParameter("codigo", codigo);
        OrdenFabricacion ord = (OrdenFabricacion) q.uniqueResult();
        acabaOperacion();
        return ord;
    }

    @Override
    public OrdenFabricacion buscarOrden(Map<String, Object> whereMap) {
        return obtenerListaOrdenes(whereMap).get(0);
    }

    @Override
    public List<OrdenFabricacion> obtenerListaOrdenes(Map<String, Object> whereMap) {
        iniciaOperacion();
        //Create where block
        String str = "";
        Set keys = whereMap.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            if (it.hasNext()) {
                String currentKey = it.next();
                String operator = "=";
                if (whereMap.get(currentKey) instanceof String) {
                    operator = " LIKE ";
                }
                str += currentKey + operator + ":" + currentKey + " ";
            }
            if (it.hasNext()) {
                str += " and ";
            }
        }
        if (str != "") {
            str = "WHERE " + str;
        }
        // Complete query-string
        Query query = session.createQuery("FROM OrdenFabricacion " + str);
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
        List<OrdenFabricacion> res = query.list();
        acabaOperacion();
        return res;
    }

    @Override
    public List<OrdenFabricacion> obtenerListaOrdenes() {
        iniciaOperacion();
        Query q = session.createQuery("From OrdenFabricacion");
        System.out.println("Query: " + q);
        List<OrdenFabricacion> res = q.list();
        acabaOperacion();
        return res;
    }

    @Override
    public OrdenFabricacion guardarOrden(OrdenFabricacion ord) {
        iniciaOperacion();
        session.persist(ord);
        acabaOperacion();
        return this.buscarOrden(ord.getCodigo());
    }

    @Override
    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord) {
        iniciaOperacion();
        session.update(ord);
        acabaOperacion();
        return ord;
    }

    @Override
    public void eliminarOrden(OrdenFabricacion ord) {
        iniciaOperacion();
        session.delete(ord);
        acabaOperacion();
    }

}
