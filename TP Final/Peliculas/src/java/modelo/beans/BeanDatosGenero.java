package modelo.beans;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author acabrera
 */
public class BeanDatosGenero implements Comparator {
    private int idGen = 0;
    private String nombre = null;
    private String descripcion = null;
    private HashMap peliculasGenero = null;

    //Constructores
    public BeanDatosGenero() {
    }

    public BeanDatosGenero(int idGen, String nombre, String descripcion) {
        this.idGen = idGen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BeanDatosGenero(int idGen, String nombre) {
        this.idGen = idGen;
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }
    //Comparo para que se introduzcan ordenadamente
    public int compare(Object o1, Object o2) {
        if (((BeanDatosGenero) o1).getIdGen() < ((BeanDatosGenero) o2).getIdGen()) {
            return -1;
        } else if (((BeanDatosGenero) o1).getIdGen() == ((BeanDatosGenero) o2).getIdGen()) {
            return 1;
        } else {
            return 1;
        }
    }

    // En caso de que dos libros sean iguales, este método devolverá true.
    @Override
    public boolean equals(Object obj) {
        return getIdGen() == ((BeanDatosGenero) obj).getIdGen();
    }

    /**
     * @return the idGen
     */
    public int getIdGen() {
        return idGen;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param idGen the idGen to set
     */
    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }

    /**
     * @return the peliculasGenero
     */
    public HashMap getPeliculasGenero() {
        return peliculasGenero;
    }

    /**
     * @param peliculasGenero the peliculasGenero to set
     */
    public void setPeliculasGenero(HashMap peliculasGenero) {
        this.peliculasGenero = peliculasGenero;
    }
}
