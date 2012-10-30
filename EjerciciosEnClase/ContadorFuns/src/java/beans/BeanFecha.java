/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author acabrera
 */
public class BeanFecha {

    private Calendar fechaHoraActual;
    private int formato;
    private int hora;
    private int minutos;

    public BeanFecha() {
        formato = 24;
        fechaHoraActual = new GregorianCalendar();
    }

    public String getFecha() {

        return (fechaHoraActual.get(Calendar.DAY_OF_MONTH) + "/"
                + (fechaHoraActual.get(Calendar.MONTH) + 1) + "/"
                + (fechaHoraActual.get(Calendar.YEAR)));
    }

    /**
     * @return the formato
     */
    public int getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(int formato) {
        this.formato = formato;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        if (formato == 24) {
            hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY);
        } else {
            hora = fechaHoraActual.get(Calendar.HOUR);
        }
        return hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        minutos = fechaHoraActual.get(Calendar.MINUTE);
        return minutos;
    }
}
