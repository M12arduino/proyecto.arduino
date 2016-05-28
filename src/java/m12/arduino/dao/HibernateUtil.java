package m12.arduino.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 /**
  * Clase HibernateUtil
  * @author Enric, Pablo, Jordi y Oscar
  */
public class HibernateUtil {

    /**
     * Atributo SessionFactory
     */
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("/m12/arduino/dao/hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    /**
     * Getter del atributo SessionFactory
     * @return Devuelve el atributo SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
