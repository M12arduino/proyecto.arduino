/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import m12.arduino.domain.Robot;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author couto
 */
public class DaoRobotImpl implements DaoRobot{
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
    public Robot buscarRobot(String nombre) {
        iniciaOperacion();
        Query q =session.createQuery("FROM Robot r WHERE r.nombre =:nombre ");
        q.setParameter("nombre",nombre);
        Robot res = (Robot)q.uniqueResult();
        acabaOperacion();
        return res;           
    }

    @Override
    public Robot guardaActualizaRobot(Robot rob) {
        iniciaOperacion();
        session.persist(rob);
        acabaOperacion();
        return rob;
    }

    @Override
    public List<Robot> obtenListaRobot() {
        iniciaOperacion();
        Query q = session.createQuery("From Robot");
        List<Robot> res = q.list();
        acabaOperacion();
        return res;
    }
    
}