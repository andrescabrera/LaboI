/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acabrera
 */
public class SeguimientoSesion extends HttpServlet {
    //Manipular la petición enviada por el cliente utilizando
    //el atributo method=get

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tipo de respuesta que será enviada al cliente
        response.setContentType("text/html;charset=UTF-8");
        //Obtener el flujo PrintWriter para devolver la respuesta
        PrintWriter out = response.getWriter();
        try {
            //Obtener la sesión actual, crear una si fuera necesario
            HttpSession sesionCli = request.getSession(true);
            //Datos de la sesión
            String idSesion = sesionCli.getId();
            long fechaCreacion = sesionCli.getCreationTime();
            long fechaUltimoAcceso = sesionCli.getLastAccessedTime();

            //Incrementar el contador para esta página
            //El valor es guardado en la sesión del cliente con el nombre
            //"cuenta.ss"
            Integer cuenta = (Integer)sesionCli.getAttribute("cuenta.ss");
            if(cuenta == null)
                cuenta = new Integer(1);
            else
                cuenta = new Integer(cuenta.intValue() + 1);
            sesionCli.setAttribute("cuenta.ss", cuenta);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
            out.println("Seguimiento de sesi&oacute;n");
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Demostraci&oacute;n de seguimiento de"
                    + " sesi&oacute;n</h1>");
            //Visualizar la cuenta para esta página
            out.println("<p>Has visitado esta p&aacute;gina" + cuenta +
                    (cuenta.intValue() == 1 ? " vez" : " veces") + ".</p>");
            out.println("<h2>Datos de tu sesi&oacute;n</h2>");
            out.println("<p>Sesi&oacute;n " + idSesion + "</p>");
            out.println("<p>Fue creada: "
                    + (new Date(fechaCreacion)).toString() + "</p>");
            out.println("<p>Fue accedida por &uacute;ltima vez: "
                    + (new Date(fechaUltimoAcceso)).toString() + "</p>");
            out.println("<p>Atributos:</p>");

            Enumeration nombresParams = sesionCli.getAttributeNames();
            out.println("<ul>");
            while(nombresParams.hasMoreElements()){
             String param = (String)nombresParams.nextElement();
             Object valor = sesionCli.getAttribute(param);
             out.println("<li>" + param + ": " + valor.toString() + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
