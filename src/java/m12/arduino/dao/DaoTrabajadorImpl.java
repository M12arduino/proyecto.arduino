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
 * Controlador para los objetos Trabajador.
 * @author Enric, Pablo, Jordi y Oscar
 */
public class DaoTrabajadorImpl implements DaoTrabajador {

    private Session session;
    private Transaction tx;

    /**
     * Metodo que abre la sesion e inicia la transaccion.
     */
    public void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    /**
     * Metodo que hace el commit y cierra la conexion.
     */
    public void acabaOperacion() {
        tx.commit();
        session.close();
    }

    /**
     * Metodo para buscar un trabajador en la base de datos.
     * @param nif String con el nif del trabajador a buscar.
     * @return Devuelve un Objeto Trabajador correspondiente al nif proporcionado.
     */
    @Override
    public Trabajador buscarTrabajador(String nif) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Trabajador t WHERE t.nif =:nif ");
        q.setParameter("nif", nif);
        Trabajador res = (Trabajador) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para buscar trabajadores en la base de datos.
     * @param whereMap objeto Map con la información para buscar trabajadores. 
     * @return Devuelve un Objeto List de los trabajadores que coinciden con la 
     * información proporcionada.
     */
    @Override
    public List<Trabajador> obtenerListaTrabajadores(Map<String, Object> whereMap) {
        iniciaOperacion();
        //Create where block
        String str = "";
        Set keys = whereMap.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            if (it.hasNext()) {
                String currentKey = it.next();
                String operator = "=";
                if (whereMap.get(currentKey) instanceof String) {
                    operator = " LIKE ";
                }
                str += currentKey + operator + " :" + currentKey + " ";
            }
            if (it.hasNext()) {
                str += " and ";
            }
        }
        if (str != "") {
            str = "WHERE " + str;
        }
        // Complete query-string
        Query query = session.createQuery("FROM Trabajador " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            Object val = e.getValue();
            if (val instanceof String) {
                query.setParameter(attr, "%" + val + "%");
            } else {
                query.setParameter(attr, val);
            }
        }
        List<Trabajador> res = query.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para eliminar trabajadores de la base de datos.
     * @param trab objeto Trabajador a eliminar.
     */
    @Override
    public void eliminarTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.delete(trab);
        acabaOperacion();
    }

    /**
     * Metodo para listar los trabajadores de la base de datos.
     * @return Devuelve un Objeto List con los trabajadores de la base de datos.
     */
    @Override
    public List<Trabajador> obtenerListaTrabajadores() {
        iniciaOperacion();
        Query q = session.createQuery("From Trabajador");
        List<Trabajador> res = q.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para guardar trabajadores en la base de datos.
     * @param trab objeto Trabajador a guardar.
     * @return Devuelve el objeto Trabajador guardado.
     */
    @Override
    public Trabajador guardarTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.persist(trab);
        acabaOperacion();
        return this.buscarTrabajador(trab.getNif());
    }

    /**
     * Metodo para actualizar trabajadores de la base de datos.
     * @param trab objeto Trabajador a actualizar.
     * @return Devuelve el objeto Trabajador actualizado.
     */
    @Override
    public Trabajador actualizarTrabajador(Trabajador trab) {
        iniciaOperacion();
        session.update(trab);
        acabaOperacion();
        return trab;
    }

    /**
     * Metodo para buscar trabajadores en la base de datos.
     * @param whereMap objeto Map con la información para buscar trabajadores. 
     * @return Devuelve un Objeto Trabajador que coincide con la información 
     * proporcionada.
     */
    @Override
    public Trabajador buscarTrabajador(Map<String, Object> whereMap) {
        return obtenerListaTrabajadores(whereMap).get(0);
    }

}
