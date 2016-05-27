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
import m12.arduino.domain.Trabajador;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Controlador para los objetos Robot.
 * @author Enric, Pablo, Jordi y Oscar
 */
public class DaoRobotImpl implements DaoRobot {

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
     * Metodo para buscar un robot en la base de datos.
     * @param id_robot String con el id_robot del robot a buscar.
     * @return Devuelve un Objeto Robot correspondiente al id_robot proporcionado.
     */
    @Override
    public Robot buscarRobot(String id_robot) {
        iniciaOperacion();
        Query q = session.createQuery("FROM Robot r WHERE r.id_robot =:id_robot ");
        q.setParameter("id_robot", id_robot);
        Robot res = (Robot) q.uniqueResult();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los robots de la base de datos.
     * @param whereMap objeto Map con la información para obtener la lista de
     * robots. 
     * @return Devuelve un objeto List de los robots que coinciden con la 
     * información proporcionada.
     */
    @Override
    public List<Robot> obtenerListaRobots(Map<String, Object> whereMap) {
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
                str += currentKey + operator+" :" + currentKey + " ";
            }
            if (it.hasNext()) {
                str += " and ";
            }
        }
        if (str != "") {
            str = "WHERE " + str;
        }
        // Complete query-string
        Query query = session.createQuery("FROM Robot " + str);
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
        List<Robot> res = query.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para listar los robots de la base de datos.
     * @return Devuelve un Objeto List con los robots de la base de datos.
     */
    @Override
    public List<Robot> obtenerListaRobots() {
        iniciaOperacion();
        Query q = session.createQuery("From Robot");
        List<Robot> res = q.list();
        acabaOperacion();
        return res;
    }

    /**
     * Metodo para guardar robots en la base de datos.
     * @param rob objeto Robot a guardar.
     * @return Devuelve el objeto Robot guardado.
     */
    @Override
    public Robot guardarRobot(Robot rob) {
        iniciaOperacion();
        session.persist(rob);
        acabaOperacion();
        return this.buscarRobot(rob.getId_robot());
    }

    /**
     * Metodo para actualizar robots de la base de datos.
     * @param rob objeto Robot a actualizar.
     * @return Devuelve el objeto Robot actualizado.
     */
    @Override
    public Robot actualizarRobot(Robot rob) {
        iniciaOperacion();
        session.update(rob);
        acabaOperacion();
        return rob;
    }

    /**
     * Metodo para buscar robots en la base de datos.
     * @param whereMap objeto Map con la información para buscar robots. 
     * @return Devuelve un Objeto Robot que coincide con la información proporcionada.
     */
    @Override
    public Robot buscarRobot(Map<String, Object> whereMap) {
        return obtenerListaRobots(whereMap).get(0);
    }

    /**
     * Metodo para eliminar robots de la base de datos.
     * @param rob objeto Robot a eliminar.
     */
    @Override
    public void eliminarRobot(Robot rob) {
        iniciaOperacion();
        session.delete(rob);
        acabaOperacion();
    }

}
