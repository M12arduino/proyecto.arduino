/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m12.arduino.domain.Robot;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author couto
 */
public class DaoRobotImpl implements DaoRobot {

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
    public Robot buscarRobot(String nombre) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Robot r WHERE r.nombre =:nombre ");
        q.setParameter("nombre", nombre);
        Robot res = (Robot) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    @Override
    public List<Robot> obtenerListaRobots(Map<String, Object> whereMap) {
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
        // Complete query-string
        Query query = session.createQuery("FROM Robot WHERE " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            String val = (String) e.getValue();
            query.setParameter(attr, val);
        }
        acabaOperacion();
        return query.list();
    }

    @Override
    public List<Robot> obtenerListaRobots() {
        iniciaOperacion();
        Query q = session.createQuery("From Robot");
        List<Robot> res = q.list();
        acabaOperacion();
        return res;
    }

    @Override
    public Robot guardarRobot(Robot rob) {
        iniciaOperacion();
        session.persist(rob);
        acabaOperacion();
        return rob;
    }

    @Override
    public Robot actualizarRobot(Robot rob) {
        iniciaOperacion();
        session.update(rob);
        acabaOperacion();
        return rob;
    }

    @Override
    public Robot buscarRobot(Map<String, Object> whereMap) {
        return obtenerListaRobots(whereMap).get(0);
    }

}
