/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etiquetas;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author acabrera
 */
public class Fecha extends SimpleTagSupport{
    @Override
    public void doTag () throws IOException {
        Calendar fechaHoraActual = new GregorianCalendar();

        String s = fechaHoraActual.get(Calendar.DAY_OF_MONTH)+"/"+
                (fechaHoraActual.get(Calendar.MONTH) + 1)+"/"+
                fechaHoraActual.get(Calendar.YEAR);

        getJspContext().getOut().write("Hoy estamos a " + s);
    }
}
