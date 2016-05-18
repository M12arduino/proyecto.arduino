package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Proceso;
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
    public Proceso buscarProceso(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proceso> obtenerListaProcesos(Map<String, Object> whereMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proceso> obtenerListaProcesos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proceso guardarProceso(Proceso pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proceso actualizarProceso(Proceso pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proceso buscarProceso(Map<String, Object> whereMap) {
        return obtenerListaProcesos(whereMap).get(0);
    }

}
