/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelo.bdPeliculas;

/**
 *
 * @author acabrera
 */
public class BeanBDPeliculas {

    private bdPeliculas bd;
    private int numFilas = 0;

    // Constructor
    public BeanBDPeliculas(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new bdPeliculas(servCon);
    }

    //Cerrar la conexión
    public void cerrarConexion() throws java.sql.SQLException {
        bd.cerrarConexion();
    }

    /**
     * @return the numFilas
     */
    public int getNumFilas() {
        return numFilas;
    }

    /*
     * Metodos para gestionar las peliculas
     *
     */
    public HashMap<Integer, BeanDatosPelicula> getPeliculasPorGenero(int idGenero) throws SQLException {
        HashMap<Integer, BeanDatosPelicula> map = new HashMap<Integer, BeanDatosPelicula>();
        BeanDatosPelicula bdtPel;
        ResultSet cjtoRes = bd.recuperarPeliculasDeUnGenero(idGenero);
        int idPel = 0;
        while (cjtoRes.next()) {
            idPel = cjtoRes.getInt("id");
            bdtPel = new BeanDatosPelicula(idPel, cjtoRes.getString("nombre"), cjtoRes.getDate("fechaEstreno"));
            map.put(idPel, bdtPel);
        }
        numFilas = map.size();
        return map;
    }

    public int altaPelicula(String nombre) throws SQLException {
        int ultId = bd.altaPelicula(nombre);
        return ultId;
    }

    public int altaPelicula(String nombre, String fechaEstreno) throws SQLException {
        int ultId = 0;
        ultId = bd.altaPelicula(nombre, getInsertDate(fechaEstreno));
        return ultId;
    }

    public void modificarPelicula(int idPel, String nombre) throws SQLException {
        bd.modificarPelicula(idPel, nombre);
    }

    public void modificarPelicula(int idPel, String nombre, String fechaEstreno) throws SQLException {
        bd.modificarPelicula(idPel, nombre, getInsertDate(fechaEstreno));
    }

    public HashMap getPeliculas() throws SQLException {
        HashMap<Integer, BeanDatosPelicula> peliculas = new HashMap<Integer, BeanDatosPelicula>();
        HashMap<Integer, BeanDatosGenero> generos = new HashMap<Integer, BeanDatosGenero>();
        BeanDatosPelicula bdtPel;
        ResultSet cdr = bd.recuperarPeliculas();
        int idPel = 0;
        while (cdr.next()) {
            idPel = cdr.getInt(1);
            bdtPel = new BeanDatosPelicula(idPel, cdr.getString(2), cdr.getDate(3));
            peliculas.put(idPel, bdtPel);
        }
        cdr.close();
        //Recorrer los valores (BeanDatosPeliculas) del HashMap y agregar sus generos
        for (BeanDatosPelicula p : peliculas.values()) {
            //Generos de la pelicula
            generos = this.getGenerosDeUnaPelicula(p.getIdPel());
            p.setGenerosPelicula(generos);
        }
        numFilas = peliculas.size();
        return peliculas;
    }

    public void eliminarPelicula(int unIdPel) throws SQLException {
        bd.eliminarPelicula(unIdPel);
    }

    public void agregarGenerosPelicula(String[] idGeneros, int idPelicula) throws SQLException {
        for (String idUnGenero : idGeneros) {
            bd.agregarGeneroPelicula(idPelicula, Integer.parseInt(idUnGenero));
        }
    }

    /*
     * Metodos para gestionar los generos
     */
    public HashMap getGeneros() throws SQLException {
        BeanDatosGenero bdtGen;
        HashMap<Integer, BeanDatosGenero> mapGeneros = new HashMap<Integer, BeanDatosGenero>();
        HashMap<Integer, BeanDatosPelicula> mapPeliculasDelGenero = new HashMap<Integer, BeanDatosPelicula>();
        ResultSet cjtoRes = bd.recuperarGeneros();
        int idGen = 0;
        while (cjtoRes.next()) {
            idGen = cjtoRes.getInt(1);
            bdtGen = new BeanDatosGenero(idGen, cjtoRes.getString(2), cjtoRes.getString(3));
            mapGeneros.put(idGen, bdtGen);
        }
        cjtoRes.close();
        for (BeanDatosGenero g : mapGeneros.values()) {
            mapPeliculasDelGenero = this.getPeliculasPorGenero(g.getIdGen());
            g.setPeliculasGenero(mapPeliculasDelGenero);
        }
        numFilas = mapGeneros.size();
        return mapGeneros;
    }

    public HashMap getGenerosDeUnaPelicula(int idPel) throws SQLException {
        BeanDatosGenero bdtGen;
        HashMap<Integer, BeanDatosGenero> map = new HashMap<Integer, BeanDatosGenero>();
        ResultSet cjtoRes = bd.recuperarGenerosDeUnaPelicula(idPel);
        int idGen = 0;
        while (cjtoRes.next()) {
            idGen = cjtoRes.getInt("id");
            bdtGen = new BeanDatosGenero(idGen, cjtoRes.getString("nombre"), cjtoRes.getString("descripcion"));
            map.put(idGen, bdtGen);
        }
        numFilas = map.size();
        return map;
    }

    public void altaGenero(String nombre) throws SQLException {
        bd.altaGenero(nombre);
    }

    public void altaGenero(String nombre, String descripcion) throws SQLException {
        bd.altaGenero(nombre, descripcion);
    }

    public void eliminarGenero(int idGen) throws SQLException {
        bd.eliminarGenero(idGen);
    }

    public HashMap buscarGenero(String nombre, String descripcion) throws SQLException {
        BeanDatosGenero bdtGen;
        HashMap map = new HashMap();
        ResultSet cjtoRes = bd.buscarGeneros(nombre, descripcion);
        int idGen = 0;
        while (cjtoRes.next()) {
            idGen = cjtoRes.getInt("id");
            bdtGen = new BeanDatosGenero(idGen, cjtoRes.getString("nombre"), cjtoRes.getString("descripcion"));
            map.put(idGen, bdtGen);
        }
        numFilas = map.size();
        return map;
    }

    public HashMap buscarGenero(String nombre) throws SQLException {
        BeanDatosGenero bdtGen;
        HashMap map = new HashMap();
        ResultSet cjtoRes = bd.buscarGeneros(nombre);
        int idGen = 0;
        while (cjtoRes.next()) {
            idGen = cjtoRes.getInt("id");
            bdtGen = new BeanDatosGenero(idGen, cjtoRes.getString("nombre"));
            map.put(idGen, bdtGen);
        }
        numFilas = map.size();
        return map;
    }

    public void modificarGenero(int idGen, String nombre) throws SQLException {
        bd.modificarGenero(idGen, nombre);
    }

    public void modificarGenero(int idGen, String nombre, String descripcion) throws SQLException {
        bd.modificarGenero(idGen, nombre, descripcion);
    }

    public static java.sql.Date getInsertDate(String s) {
        java.sql.Date dte = null;
        try {
            String str = s;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dt = formatter.parse(str);
            dte = new java.sql.Date(dt.getTime());
        } catch (Exception ex) {
            Logger.getLogger(BeanBDPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dte;
    }

    public HashMap buscarPeliculas(String nomPel) throws SQLException {
        HashMap<Integer, BeanDatosPelicula> resultados = new HashMap<Integer, BeanDatosPelicula>();
        HashMap<Integer, BeanDatosGenero> generosDeLaPelicula;
        BeanDatosPelicula unaPeli;
        ResultSet cjtoRes = bd.buscarPelicula(nomPel);
        int idPel = 0;
        while (cjtoRes.next()) {
            idPel = cjtoRes.getInt(1);
            unaPeli = new BeanDatosPelicula(idPel, cjtoRes.getString(2), cjtoRes.getDate(3));
            resultados.put(idPel, unaPeli);
        }
        cjtoRes.close();
        for (BeanDatosPelicula p : resultados.values()) {
            generosDeLaPelicula = this.getGenerosDeUnaPelicula(p.getIdPel());
            p.setGenerosPelicula(generosDeLaPelicula);
        }
        numFilas = resultados.size();
        return resultados;
    }

    public HashMap buscarPeliculas(String nomPel, String fechaEstreno) throws SQLException {
        HashMap<Integer, BeanDatosPelicula> resultados = new HashMap<Integer, BeanDatosPelicula>();
        HashMap<Integer, BeanDatosGenero> generosDeLaPelicula;
        BeanDatosPelicula unaPeli;
        ResultSet cjtoRes = bd.buscarPelicula(nomPel, fechaEstreno);
        int idPel = 0;
        while (cjtoRes.next()) {
            idPel = cjtoRes.getInt(1);
            unaPeli = new BeanDatosPelicula(idPel, cjtoRes.getString(2), cjtoRes.getDate(3));
            resultados.put(idPel, unaPeli);
        }
        cjtoRes.close();
        for (BeanDatosPelicula p : resultados.values()) {
            generosDeLaPelicula = this.getGenerosDeUnaPelicula(p.getIdPel());
            p.setGenerosPelicula(generosDeLaPelicula);
        }
        numFilas = resultados.size();
        return resultados;
    }
}