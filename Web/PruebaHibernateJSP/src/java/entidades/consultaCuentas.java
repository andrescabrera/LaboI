/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author acabrera
 */
public class consultaCuentas {

    Session sesion = null;

    public consultaCuentas() {
        this.sesion = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getCuentas() {

        List<Cuentas> cuentas = null;
        try {
            org.hibernate.Transaction tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Cuentas as cuentas");
            cuentas = (List<Cuentas>) q.list();
        } catch (Exception e) {
        }
        return cuentas;
    }
}
