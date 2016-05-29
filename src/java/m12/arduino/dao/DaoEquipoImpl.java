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
 * Controlador para los objetos equipo
 * @author Enric, Pablo, Jordi y Oscar
 */
public class DaoEquipoImpl implements DaoEquipo {

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
     * Metodo para buscar un equipo en la base de datos.
     * @param id_equipo String con el id_equipo del equipo a buscar.
     * @return Devuelve un Objeto Equipo correspondiente al id_equipo proporcionado.
     */
    @Override
    public Equipo buscarEquipo(String id_equipo) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Equipo e WHERE e.id_equipo =:id_equipo ");
        q.setParameter("id_equipo", id_equipo);
        Equipo res = (Equipo) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los equipos de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * equipos. 
     * @return Devuelve un objeto List de los equipos que coinciden con la 
     * información proporcionada.
     */
    @Override
    public List<Equipo> obtenerListaEquipos(Map<String, Object> whereMap) {
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
        Query query = session.createQuery("FROM Equipo " + str);
        //set parameters
        for (Map.Entry e : whereMap.entrySet()) {
            String attr = (String) e.getKey();
            Object val = e.getValue();
            if (val instanceof String) {
                query.setParameter(attr, "%" + val + "%");
            } else {
                query.setParameter(attr, val);
            };
        }
        List<Equipo> res = query.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los equipos de la base de datos.
     * @return Devuelve un Objeto List con los equipos de la base de datos.
     */
    @Override
    public List<Equipo> obtenerListaEquipos() {
        iniciaOperacion();
        Query q = session.createQuery("From Equipo");
        List<Equipo> res = q.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para guardar equipos en la base de datos.
     * @param equ objeto Equipo a guardar.
     * @return Devuelve el objeto Equipo guardado.
     */
    @Override
    public Equipo guardarEquipo(Equipo equ) {
        iniciaOperacion();
        session.save(equ);
        acabaOperacion();
        return this.buscarEquipo(equ.getId_equipo());
    }

    /**
     * Metodo para actualizar equipos de la base de datos.
     * @param equ objeto Equipo a actualizar.
     * @return Devuelve el objeto Equipo actualizado.
     */
    @Override
    public Equipo actualizarEquipo(Equipo equ) {
        iniciaOperacion();
        session.update(equ);
        acabaOperacion();
        return equ;
    }

    /**
     * Metodo para buscar equipos en la base de datos.
     * @param whereMap objeto Map con la información para buscar equipos. 
     * @return Devuelve un Objeto Equipo que coincide con la información proporcionada.
     */
    @Override
    public Equipo buscarEquipo(Map<String, Object> whereMap) {
        return obtenerListaEquipos(whereMap).get(0);
    }

    /**
     * Metodo para eliminar equipos de la base de datos.
     * @param equ objeto Equipo a eliminar.
     */
    @Override
    public void eliminarEquipo(Equipo equ) {
        iniciaOperacion();
        session.delete(equ);
        acabaOperacion();
    }
}
