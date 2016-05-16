/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import m12.arduino.domain.Equipo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author enric
 */
public class DaoEquipoImpl implements DaoEquipo{
    
    private Session session;
    private Transaction tx;
  
    public void iniciaOperacion(){
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public void acabaOperacion(){
         tx.commit();
        session.close();
    }
    @Override
    public Equipo guardaActualizaEquipo(Equipo eq) {
        iniciaOperacion();
        session.persist(eq);
        acabaOperacion();
        return eq;
    }
    
}
