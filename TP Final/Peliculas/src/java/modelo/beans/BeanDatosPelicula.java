package modelo.beans;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author acabrera
 */
public class BeanDatosPelicula implements Comparator {

    private int idPel = 0;
    private String nombre = null;
    private Date fechaEstreno = null;
    private HashMap generosPelicula = null;

    //Constructores
    public BeanDatosPelicula() {
    }

    public BeanDatosPelicula(int idPel, String nombre) {
        this.idPel = idPel;
        this.nombre = nombre;
    }
    
    public BeanDatosPelicula(int idPel, String nombre, Date fechaEstreno) {
        this.idPel = idPel;
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
    }    

    //Comparo para que se introduzcan ordenadamente
    public int compare(Object o1, Object o2) {
        if (((BeanDatosPelicula) o1).getIdPel() < ((BeanDatosPelicula) o2).getIdPel()) {
            return -1;
        } else if (((BeanDatosPelicula) o1).getIdPel() == ((BeanDatosPelicula) o2).getIdPel()) {
            return 1;
        } else {
            return 1;
        }
    }

    // En caso de que dos libros sean iguales, este método devolverá true.
    @Override
    public boolean equals(Object obj) {
        return getIdPel() == ((BeanDatosPelicula) obj).getIdPel();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getIdPel();
        return hash;
    }

    /**
     * @return the idPel
     */
    public int getIdPel() {
        return idPel;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaEstreno
     */
    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * @param fechaEstreno the fechaEstreno to set
     */
    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * @param idPel the idPel to set
     */
    public void setIdPel(int idPel) {
        this.idPel = idPel;
    }

    /**
     * @return the generosPelicula
     */
    public HashMap getGenerosPelicula() {
        return generosPelicula;
    }

    /**
     * @param generosPelicula the generosPelicula to set
     */
    public void setGenerosPelicula(HashMap generosPelicula) {
        this.generosPelicula = generosPelicula;
    }
}
