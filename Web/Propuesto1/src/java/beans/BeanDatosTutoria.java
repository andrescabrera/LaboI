/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author acabrera
 */
public class BeanDatosTutoria implements Comparable<BeanDatosTutoria> {

    private int idTutoria;
    private String dia;
    private String hora;
    private String profesor;

    public BeanDatosTutoria() {
    }

    public BeanDatosTutoria(int id, String d, String h, String prof) {
        idTutoria = id;
        dia = d;
        hora = h;
        profesor = prof;
    }

    public int compareTo(BeanDatosTutoria obj) {
        if (this.idTutoria < obj.idTutoria) {
            return -1;
        } else if (this.idTutoria == obj.idTutoria) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * @return the idTutoria
     */
    public int getIdTutoria() {
        return idTutoria;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @return the profesor
     */
    public String getProfesor() {
        return profesor;
    }
}
