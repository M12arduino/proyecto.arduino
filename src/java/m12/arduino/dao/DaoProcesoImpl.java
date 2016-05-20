package m12.arduino.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m12.arduino.domain.Proceso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 Jordi Puig Puig
 DAW 2
 Curs 2015-2016

 @author Jordi
 */
public class DaoProcesoImpl implements DaoProceso {

    private Session session;
    private Transaction tx;

    public void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void acabaOperacion() {
        tx.commit();
        session.close();
    }

    @Override
    public Proceso buscarProceso(String codigo) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Proceso p WHERE p.codigo =:codigo ");
        q.setParameter("codigo", codigo);
        Proceso res = (Proceso) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    @Override
    public List<Proceso> obtenerListaProcesos(Map<String, Object> whereMap) {
        iniciaOperacion();
        //Create where block
        String str = "";
        Set keys = whereMap.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            if (it.hasNext()) {
                String currentKey = it.next();
                str += currentKey + "=:" + currentKey + " ";
            }
            if (it.hasNext()) {
                str += " and ";
            }
        }
        if (str!="") str= "WHERE "+str;
        // Complete query-string
        Query query = session.createQuery("FROM Trabajador " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            Object val =  e.getValue();
            query.setParameter(attr, val);      
        }
        List<Proceso> res= query.list();
        acabaOperacion();
        return res;
    }

    @Override
    public List<Proceso> obtenerListaProcesos() {
        iniciaOperacion();
        Query q = session.createQuery("From Proceso");
        List<Proceso> res = q.list();
        acabaOperacion();
        return res;
    }

    @Override
    public Proceso guardarProceso(Proceso pro) {
        iniciaOperacion();
        session.persist(pro);
        acabaOperacion();
        return this.buscarProceso(pro.getCodigo());
    }

    @Override
    public Proceso actualizarProceso(Proceso pro) {
        iniciaOperacion();
        session.update(pro);
        acabaOperacion();
        return pro;
    }

    @Override
    public Proceso buscarProceso(Map<String, Object> whereMap) {
        return obtenerListaProcesos(whereMap).get(0);
    }

    @Override
    public void eliminarProceso(Proceso pro) {
        iniciaOperacion();
        session.delete(pro);
        acabaOperacion();
    }

}
