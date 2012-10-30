/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author acabrera
 */
public final class BDTutorias {

    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet cjtoResultados;

    public BDTutorias() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        //Cargar el controlador JDBC
        String controlador = "com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        conectar(); //Conecta con la fuente de datos
    }

    public void conectar() throws SQLException {
        String urlDB = "jdbc:mysql://192.168.1.20:3306/tutorias";
        String userDB = "root";
        String passDB = "1164t";

        //Conectar con la Base de Datos
        conexion = DriverManager.getConnection(urlDB, userDB, passDB);
        sentenciaSQL = conexion.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("\nConexión realizada con éxito");
    }

    public void cerrarConexion() throws SQLException {
        if (cjtoResultados != null) {
            cjtoResultados.close();
        }
        if (sentenciaSQL != null) {
            sentenciaSQL.close();
        }
        if (conexion != null) {
            conexion.close();
        }
    }

    public ResultSet obtenerTabla(String tabla) throws SQLException {
        cjtoResultados = sentenciaSQL.executeQuery("SELECT * FROM " + tabla);
        return cjtoResultados;
    }

    public ResultSet tutoriasDisponibles() throws SQLException {
        cjtoResultados = sentenciaSQL.executeQuery(
                "SELECT tutorias.idTutoria, profesores.profesor, "
                + "tutorias.dia, tutorias.hora FROM profesores, "
                + "tutorias WHERE profesores.idProfesor = tutorias.idProfesor "
                + "AND tutorias.idTutoria NOT IN "
                + "(SELECT idTutoria FROM citas)");
        return cjtoResultados;
    }

    public void insertarEnCitas(int idTutoria, String alumno, String asunto) throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO citas VALUES "
                + "(" + idTutoria + ", '" + alumno + "', '" + asunto + "')");
    }

    public void borrarCitas() throws SQLException {
        sentenciaSQL.executeUpdate("DELETE FROM citas");
    }

    public int obtenerIdProfesor(String nombre) throws SQLException {
        cjtoResultados = sentenciaSQL.executeQuery("SELECT * FROM profesores"
                + " WHERE profesor = '" + nombre + "'");
        if (cjtoResultados.isBeforeFirst()) {
            cjtoResultados.first();
            return cjtoResultados.getInt("idProfesor");
        } else {
            return -1;
        }
    }

    public int obtenerIdTutoria(int idProf, String d, String h) throws SQLException {
        cjtoResultados = sentenciaSQL.executeQuery("SELECT * FROM tutorias"
                + " WHERE idProfesor = " + idProf
                + " AND dia = '" + d + "'"
                + " AND hora = " + h );
        if (cjtoResultados.isBeforeFirst()) {
            cjtoResultados.first();
            return cjtoResultados.getInt("idTutoria");
        } else {
            return -1;
        }
    }

    public boolean noEstaReservada(int idT) throws SQLException {
        cjtoResultados = sentenciaSQL.executeQuery(
                "SELECT idTutoria FROM citas WHERE idTutoria = " + idT);
        if (cjtoResultados.isBeforeFirst()) {
            return false;
        } else {
            return true;
        }
    }
}
