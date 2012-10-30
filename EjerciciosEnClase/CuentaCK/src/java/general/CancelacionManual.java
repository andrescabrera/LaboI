/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acabrera
 */
public class CancelacionManual extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cancelaci&oacute;n Manual</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelacionManual at " + request.getContextPath() + "</h1>");
            //Obtener la sesión actual; crear una si fuese necesario
            HttpSession sesion = request.getSession(true);

            //Cancelar la sesión si transcurrieron más de 3 horas desde que
            //fue creada o ha permanecido inactiva más de 10 minutos.
            if (!sesion.isNew()) { //Si la sesión no es nueva
                out.println("<h3>Sesi&oacute;n en curso</h3>");
                Date transcurrido = new Date(System.currentTimeMillis()
                        - 3 * 60 * 60 * 1000);
                Date inactividad = new Date(System.currentTimeMillis()
                        - 1 * 60 * 1000);
                Date creada = new Date(sesion.getCreationTime());
                Date accedida = new Date(sesion.getLastAccessedTime());

                if (creada.before(transcurrido) || accedida.before(inactividad)) {
                    sesion.invalidate();
                    out.println("<h3>Sesi&oacute;n Cancelada</h3>");
                    sesion = request.getSession(true); //una nueva sesión
                    out.println("<h3>Se inicia una sesi&oacute;n nueva</h3>");
                } else {
                    out.println("<h3>Sesi&oacute;n nueva</h3>");
                }
                out.println("</body>");
                out.println("</html>");
                //Continuación del proceso...
            }
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
