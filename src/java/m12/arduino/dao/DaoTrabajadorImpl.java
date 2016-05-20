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
import java.util.TreeMap;
import m12.arduino.domain.Trabajador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author enric
 */
public class DaoTrabajadorImpl implements DaoTrabajador {

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
    public Trabajador buscarTrabajador(String nif) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Trabajador t WHERE t.nif =:nif ");
        q.setParameter("nif", nif);
        Trabajador res = (Trabajador) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    @Override
    public List<Trabajador> obtenerListaTrabajadores(Map<String, Object> whereMap) {
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
        List<Trabajador> res= query.list();
        acabaOperacion();
        return res;
    }

    
    @Override
    public void eliminarTrabajador(Trabajador trab){
        iniciaOperacion();
        session.delete(trab);
        acabaOperacion();
    }
    
    @Override
    public List<Trabajador> obtenerListaTrabajadores() {
        iniciaOperacion();
        Query q = session.createQuery("From Trabajador");
        List<Trabajador> res = q.list();
        acabaOperacion();
        return res;
    }

    @Override
    public Trabajador guardarTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.persist(trab);
        acabaOperacion();
        return this.buscarTrabajador(trab.getNif());
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.update(trab);
        acabaOperacion();
        return trab;
    }

    @Override
    public Trabajador buscarTrabajador(Map<String, Object> whereMap) {
        return obtenerListaTrabajadores(whereMap).get(0);
    }
    
}
