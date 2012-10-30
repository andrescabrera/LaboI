/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etiquetas;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author acabrera
 */
public class FechaConAtributos extends SimpleTagSupport {
    private int formato; //el formato: 12 o 24 horas

    @Override
    public void doTag() throws JspException, IOException{
        Calendar fechaHoraActual = new GregorianCalendar();
        int hora, minutos;

        if(formato == 12){
            hora = fechaHoraActual.get(Calendar.HOUR);
        } else {
            hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY);
        }
        minutos = fechaHoraActual.get(Calendar.MINUTE);
        String fecha = fechaHoraActual.get(Calendar.DAY_OF_MONTH) + "/" + (fechaHoraActual.get(Calendar.MONTH) + 1) + "/" + fechaHoraActual.get(Calendar.YEAR);

        getJspContext().setAttribute("hora", String.valueOf(hora));
        getJspContext().setAttribute("minutos", String.valueOf(minutos));
        getJspContext().setAttribute("fecha", fecha);
        getJspBody().invoke(null);
    }
    public void setFormato(int f){
        formato = f;
    }
}
