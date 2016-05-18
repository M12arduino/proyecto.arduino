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
import m12.arduino.domain.Equipo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author enric
 */
public class DaoEquipoImpl implements DaoEquipo {

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
    public Equipo buscarEquipo(String nombre) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Equipo e WHERE e.nombre =:nombre ");
        q.setParameter("nombre", nombre);
        Equipo res = (Equipo) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    @Override
    public List<Equipo> obtenerListaEquipos(Map<String, Object> whereMap) {
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
        Query query = session.createQuery("FROM Equipo WHERE " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            Object val = e.getValue();
            query.setParameter(attr, val);
        }
        acabaOperacion();
        return query.list();
    }

    @Override
    public List<Equipo> obtenerListaEquipos() {
        iniciaOperacion();
        Query q = session.createQuery("From Equipo");
        List<Equipo> res = q.list();
        acabaOperacion();
        return res;
    }

    @Override
    public Equipo guardarEquipo(Equipo eq) {
        iniciaOperacion();
        session.persist(eq);
        acabaOperacion();
        return eq;
    }

    @Override
    public Equipo actualizarEquipo(Equipo eq) {
        iniciaOperacion();
        session.update(eq);
        acabaOperacion();
        return eq;
    }

    @Override
    public Equipo buscarEquipo(Map<String, Object> whereMap) {
        return obtenerListaEquipos(whereMap).get(0);
    }
}
