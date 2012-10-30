/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 *
 * @author acabrera
 */
public class BeanBDTutorias {

    private BDTutorias bd;
    private int numFilas = 0;

    public BeanBDTutorias(DataSource servCon) throws SQLException, ServletException {
        bd = new BDTutorias(servCon);
    }

    public TreeSet<BeanDatosTutoria> getTutoriasDisponibles() throws java.sql.SQLException {
        BeanDatosTutoria bTutDat = null;
        TreeSet<BeanDatosTutoria> m = new TreeSet<BeanDatosTutoria>();
        ResultSet cjtoRes = bd.tutoriasDisponibles();
        while(cjtoRes.next()){
            bTutDat = new BeanDatosTutoria(
                    cjtoRes.getInt("idTutoria"),
                    cjtoRes.getString("dia"),
                    cjtoRes.getString("hora"),
                    cjtoRes.getString("profesor"));
            m.add(bTutDat);
        }
        numFilas = m.size();
        return m;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void cerrarConexion() throws SQLException {
        bd.cerrarConexion();
    }

    public void insertarEnFilas(int idTutoria, String alumno, String asunto) throws SQLException {
        bd.insertarEnCitas(idTutoria, alumno, asunto);
    }

}
