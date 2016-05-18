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
import org.hibernate.HibernateException;
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
    
        public Robot buscarRobotByX(Map<String, Object> attrs) {

        Robot res = new Robot();
        try {
            iniciaOperacion();
            //Create Query String
            String str = "";
            Set keys = attrs.keySet();

            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                if (it.hasNext()) {
                    String currentKey = it.next();
                    str += currentKey + "=:" + currentKey + " ";
                }
                if (it.hasNext()) {
                    str += " and ";
                }
            }
            Query query = session.createQuery("FROM Robot r WHERE " + str);
            //Initialize params
            for (Map.Entry e : attrs.entrySet()) {
                String attr = (String) e.getKey();
                Object val = (Object) e.getValue();
                query.setParameter(attr, val);
            }
            Object aux = query.uniqueResult();
            res = (Robot) aux;
            acabaOperacion();
        }catch (Exception ex){
            System.out.println(ex);;
        } 

        return res;
    }
}