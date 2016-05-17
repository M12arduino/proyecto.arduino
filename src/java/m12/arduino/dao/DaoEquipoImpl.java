/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

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
    public Equipo guardaActualizaEquipo(Equipo eq) {
        iniciaOperacion();
        session.persist(eq);
        acabaOperacion();
        return eq;
    }

    @Override
    public Equipo actualizaEquipo(Equipo eq) {
        iniciaOperacion();
        session.update(eq);
        acabaOperacion();
        return eq;
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
    public Equipo mergeEquipo(Equipo eq) {
        iniciaOperacion();
        session.merge(eq);
        acabaOperacion();
        return eq;
    }

}
