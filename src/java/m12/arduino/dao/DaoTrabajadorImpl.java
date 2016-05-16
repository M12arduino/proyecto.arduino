/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import m12.arduino.domain.Trabajador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author enric
 */
public class DaoTrabajadorImpl implements DaoTrabajador{
    
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
    public Trabajador buscarTrabajador(String nif) {       
        Query q =session.createQuery("FROM Trabajador t WHERE t.nif =:nif ");
        q.setParameter("nif",nif);
        Trabajador res = (Trabajador)q.uniqueResult();
        session.close();
        System.out.println(res+"~~~~~~");
        return res;
        
        
        
    }

    @Override
    public Trabajador guardaActualizaTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.persist(trab);
        acabaOperacion();
        return trab;
    }

    @Override
    public List<Trabajador> obtenListaTrabajador() {
        iniciaOperacion();
        Query q = session.createQuery("From Trabajador");
        List<Trabajador> res = q.list();
        acabaOperacion();
        return res;
    }
    
}
