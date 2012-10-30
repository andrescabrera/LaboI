package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 *
 * @author acabrera
 */
public class bdPeliculas {

    private Connection conex;
    private Statement instr;
    private ResultSet cjtoRes;

    //Constructor, recibe un DataSource como parametro para realizar la conexión.
    public bdPeliculas(DataSource srvCon) throws SQLException, ServletException {
        synchronized (srvCon) {
            conex = srvCon.getConnection();
        }
        if (conex == null) {
            throw new ServletException("Problemas con la conexión");
        }
        instr = conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Conexión realizada con exito.");
    }

    //Cerramos la conexión con la BD
    public void cerrarConexion() throws SQLException {
        if(cjtoRes != null){
            cjtoRes.close();
        }
        if (instr != null) {
            instr.close();
        }
        if (conex != null) {
            conex.close();
        }
    }
    //Peliculas

    public int altaPelicula(String nombre) throws SQLException {
        instr.executeUpdate("INSERT INTO `Pelicula` (`nombre`) VALUES ('" + nombre + "')");
        //Devuelvo el id de la pelicula insertada
        int idPeli = 0;
        cjtoRes = instr.getGeneratedKeys();
        if (cjtoRes != null && cjtoRes.next()) {
            idPeli = cjtoRes.getInt(1);
        }
        return idPeli;
    }

    public int altaPelicula(String nombre, java.sql.Date fechaEstreno) throws SQLException {
        instr.executeUpdate("INSERT INTO `Pelicula` (`nombre`,`fechaEstreno`) VALUES ('" + nombre + "', '" + fechaEstreno + "')");
        //Devuelvo el id de la pelicula insertada
        int idPeli = 0;
        cjtoRes = instr.getGeneratedKeys();
        if (cjtoRes != null && cjtoRes.next()) {
            idPeli = cjtoRes.getInt(1);
        }
        return idPeli;
    }

    public ResultSet recuperarPeliculas() throws SQLException {
        cjtoRes = instr.executeQuery("SELECT id, nombre, fechaEstreno FROM `Pelicula` ORDER BY nombre");
        return cjtoRes;
    }

    public ResultSet buscarPelicula(String nomPel) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT DISTINCT id, nombre, fechaEstreno FROM  `Pelicula` WHERE nombre LIKE '%" + nomPel + "%' ORDER BY nombre");
        return cjtoRes;
    }

    public ResultSet buscarPelicula(String nomPel, String fecha) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT DISTINCT id, nombre, fechaEstreno FROM `Pelicula` WHERE nombre LIKE '%" + nomPel + "%' AND fecha = '" + fecha + "' ORDER BY nombre");
        return cjtoRes;
    }

    public void eliminarPelicula(int idPel) throws SQLException {
        eliminarGenerosDeLaPelicula(idPel);
        instr.executeUpdate("DELETE FROM Pelicula WHERE id = " + idPel);
    }

    public void modificarPelicula(int idPel, String nombre) throws SQLException {
        instr.executeUpdate("UPDATE Peliculas SET nombre = '" + nombre + "' WHERE id = " + idPel + ";");
    }

    public void modificarPelicula(int idPel, String nombre, Date fechaEstreno) throws SQLException {
        instr.executeUpdate("UPDATE Peliculas SET nombre = '" + nombre + "' AND fechaEstreno = " + fechaEstreno + " WHERE id = " + idPel + ";");
    }

    //Generos
    public void altaGenero(String nombre) throws SQLException {
        instr.executeUpdate("INSERT INTO Genero (nombre) VALUES ('" + nombre + "')");
    }

    public void altaGenero(String nombre, String descripcion) throws SQLException {
        instr.executeUpdate("INSERT INTO Genero (nombre, descripcion) VALUES ('" + nombre + "', '" + descripcion + "');");
    }

    public ResultSet recuperarGeneros() throws SQLException {
        cjtoRes = instr.executeQuery("SELECT id, nombre, descripcion FROM `Genero` ORDER BY nombre");
        return cjtoRes;
    }

    public void eliminarGenero(int idGen) throws SQLException {
        eliminarPeliculasDelGenero(idGen);
        instr.executeUpdate("DELETE FROM Genero WHERE id = " + idGen);
    }

    public ResultSet buscarGeneros(String nombre) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT id, nombre, descripcion FROM `Genero` WHERE nombre LIKE '%" + nombre + "%' ORDER BY id");
        return cjtoRes;
    }

    public ResultSet buscarGeneros(String nombre, String descripcion) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT id, nombre, descripcion FROM `Genero` WHERE nombre LIKE '%" + nombre + "%' AND descripcion LIKE '%" + descripcion + "%' ORDER BY id");
        return cjtoRes;
    }

    //Peliculas / Generos
    public void eliminarPeliculasDelGenero(int idGen) throws SQLException {
        instr.executeUpdate("DELETE FROM GeneroDeLaPelicula WHERE idGenero = " + idGen);
    }

    public void agregarGeneroPelicula(int idPel, int idGen) throws SQLException {
        instr.executeUpdate("INSERT INTO GeneroDeLaPelicula (idGenero, idPeliculas) VALUES (" + idGen + ", " + idPel + ");");
    }

    public void eliminarGenerosDeLaPelicula(int idPel) throws SQLException {
        instr.executeUpdate("DELETE FROM GeneroDeLaPelicula WHERE idPeliculas = " + idPel);
    }

    public ResultSet recuperarGenerosDeUnaPelicula(int idPel) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT `id`, `nombre`, `descripcion` FROM `Genero` WHERE id IN (SELECT `idGenero` FROM `GeneroDeLaPelicula` WHERE `idPeliculas` = " + idPel + ") ORDER BY id");
        return cjtoRes;
    }

    public ResultSet recuperarPeliculasDeUnGenero(int idGenero) throws SQLException {
        cjtoRes = instr.executeQuery("SELECT id, nombre, fechaEstreno FROM Pelicula WHERE id IN (SELECT idPeliculas FROM GeneroDeLaPelicula WHERE idGenero = " + idGenero + ") ORDER BY id");
        return cjtoRes;
    }

    public void modificarGenero(int idGen, String nombre, String descripcion) throws SQLException {
        instr.executeUpdate("UPDATE Genero SET nombre = '" + nombre + "' AND descripcion = '" + descripcion + "' WHERE id = idGen;");
    }

    public void modificarGenero(int idGen, String nombre) throws SQLException {
        instr.executeUpdate("UPDATE Genero SET nombre = '" + nombre + "' WHERE id = " + idGen + ";");
    }

}
