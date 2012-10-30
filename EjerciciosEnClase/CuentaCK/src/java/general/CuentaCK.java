/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acabrera
 */
public class CuentaCK extends HttpServlet {

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
            // Obtener el valor actual de la cookie "cuenta.ck" buscando entre
            //las cookies recibidas
            String scuenta = null;
            Cookie[] cookies = request.getCookies();
            // <editor-fold defaultstate="collapsed" desc="si hay cookies... Click on the + sign on the left to edit the code.">
            if (cookies != null) {
                // <editor-fold defaultstate="collapsed" desc="No me gusta el break; del ejemplo. Click on the + sign on the left to edit the code.">
                /* 
                for(int i = 0; i < cookies.length; i++){
                //buscar la cookie "cuenta.ck"
                if(cookies[i].getName().equals("cuenta.ck")){
                //y obtener el valor asociado
                scuenta = cookies[i].getValue();
                break;
                }
                }
                 */
                //</editor-fold>
                int i = 0;
                //Buscar la cookie "cuenta.ck" //sin salidas abruptas
                while (i < cookies.length && (cookies[i].getName().equals("cuenta.ck") == false)) {
                    i++;
                }
                if (cookies[i].getName().equals("cuenta.ck")) {
                    //y obtener el valor asociado
                    scuenta = cookies[i].getValue();
                }
            } // </editor-fold>

            //Incrementar el contador para esta página. El valor es guardado en
            //la cookie "cuenta.ck". Después asegurarse de enviarsela al cliente
            //con la respuesta (response)
            Integer objCuenta = null; //contador
            if (scuenta == null) //si no se encontró "cuenta.ck"
            {
                objCuenta = new Integer(1);
            } else {
                objCuenta = new Integer(Integer.parseInt(scuenta) + 1);
            }
            //Crear una nueva cookie con la cuenta actualizada
            Cookie cookieRta = new Cookie("cuenta.ck", objCuenta.toString());
            cookieRta.setMaxAge(99999999);
            response.addCookie(cookieRta);

            //Responder al cliente
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CuentaCK</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Has visitado esta p&aacute;gina " + objCuenta.toString()
                    + ((objCuenta.intValue() == 1) ? " vez." : " veces.") + "</p>");
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
        return "Servlet Cuenta.ck";
    }// </editor-fold>
}
