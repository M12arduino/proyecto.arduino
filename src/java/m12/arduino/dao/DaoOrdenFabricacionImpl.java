package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.OrdenFabricacion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
Jordi Puig Puig
DAW 2
Curs 2015-2016

@author Jordi
*/
public class DaoOrdenFabricacionImpl implements DaoOrdenFabricacion {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdenFabricacion> obtenerListaOrdenes(Map<String, Object> whereMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdenFabricacion> obtenerListaOrdenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdenFabricacion guardarOrden(OrdenFabricacion ord) {
        iniciaOperacion();
        session.persist(ord);
        acabaOperacion();
        return ord;
    }

    @Override
    public OrdenFabricacion actualizarOrden(OrdenFabricacion ord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
