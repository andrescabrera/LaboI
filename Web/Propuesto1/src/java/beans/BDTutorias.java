// Clase base de datos tutorías (BDTutorias). Métodos:
package beans;

import java.sql.*;
import javax.servlet.*;
import javax.sql.*;    // para DataSource

public class BDTutorias {

    private Connection conexión;
    private Statement sentenciaSQL;
    private ResultSet cdr; // conjunto de resultados

    public BDTutorias(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        synchronized (servCon) {
            conexión = servCon.getConnection(); // recuperar la conexión
        }
        if (conexión == null) {
            throw new ServletException("Problemas con la conexion");
        }

        // Crear una sentencia SQL
        sentenciaSQL = conexión.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        System.out.println("\nConexión realizada con éxito.\n");
    }

    public void cerrarConexion() throws java.sql.SQLException {
        if (cdr != null) {
            cdr.close();
        }
        if (sentenciaSQL != null) {
            sentenciaSQL.close();
        }
        if (conexión != null) {
            conexión.close();
        }
        System.out.println("\nConexión cerrada con éxito.\n");
    }

    public ResultSet obtenerTabla(String tabla)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery("SELECT * FROM " + tabla);
        return cdr;
    }

    public ResultSet tutoriasDisponibles()
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT tutorias.idTutoria, profesores.profesor, "
                + "tutorias.dia, tutorias.hora "
                + "FROM profesores, tutorias "
                + "WHERE profesores.idProfesor=tutorias.idProfesor "
                + "AND tutorias.idTutoria NOT IN "
                + "(SELECT idTutoria FROM citas)");
        return cdr;
    }

    public void insertarEnCitas(int idTutoria, String alumno, String asunto)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO citas"
                + " VALUES (" + idTutoria + ", '" + alumno + "', '" + asunto + "')");
    }

    public void borrarCitas() throws SQLException {
        sentenciaSQL.executeUpdate("DELETE FROM citas");
    }

    public int obtenerIdProfesor(String nombre) throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM profesores"
                + " WHERE profesor = " + "'" + nombre + "'");
        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("idProfesor");
        } else {
            return -1;
        }
    }

    public int obtenerIdTutoria(int id_prof, String d, String h)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM tutorias"
                + " WHERE idProfesor = " + id_prof
                + " AND dia = " + "'" + d + "'"
                + " AND hora = " + "'" + h + "'");
        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("idTutoria");
        } else {
            return -1;
        }
    }

    public boolean noEstaReservada(int idT)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT idTutoria FROM citas WHERE idTutoria = " + idT);
        if (cdr.isBeforeFirst()) {
            return false; // está reservada
        } else {
            return true; // no está reservada
        }
    }
}
