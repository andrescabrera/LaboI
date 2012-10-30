/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acabrera
 */
public class CarroCompra extends HttpServlet {

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
            //Obtener el identificador de sesión actual buscando entre las
            //cookies recibidas
            String idSesion = null;
            Cookie[] cookies = request.getCookies();
            String cookieName = "idSesion";
            if (cookies != null) {
                int i = 0;
                while (i < cookies.length && cookies[i].getName().equals(cookieName)) {
                    i++;
                }
                if (cookies[i].getName().equals(cookieName)) {
                    idSesion = cookies[i].getValue();
                }
            }
            //Si el identificador de sesión no fue enviado, generar uno.
            //Despúes asegurarse de enviarselo al cliente con la
            //respuesta (response)
            if (idSesion == null) {
                idSesion = generarIdSesion();
                Cookie cookieRta = new Cookie(cookieName, idSesion);
                response.addCookie(cookieRta);
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carro de la compra</title>");
            out.println("</head>");
            out.println("<body>");
            //Ofrecer una página de ayuda
            out.println("<p>Si tiene dificultades para operar visite la "
                    + "secci&oacute;n: " + "<a href=\"Ayuda"
                    + "?tema=CarroCompra\">"
                    + "Obtener ayuda</a></p>");
            //Los articulos son asociados con el ID de sesión
            String[] items = articulosComprados(idSesion);

            //Mostrar los artículos actuales
            out.println("<div id=\"articulosActuales\">"
                    + "<p>Art&iacute;culos que hay en tu carro</p>");
            if (items == null) {
                out.println("<p>Su carro de compras est&aacute; vac&iacute;o</p>");
            } else {
                out.println("<ul id=\"listaArticulosComprados\">");
                for (String itemActual : items) { //uso un foreach
                    out.println("<li>" + itemActual + "</li>");
                }
                out.println("</ul>");
            }
            out.println("</div> <!-- cierro articulosActuales -->");

            //Preguntar si se quiere añadir más elementos o finalizar.
            out.println("<div id=\"tiendaForm\">");
            out.println("<form action=\"Tienda\" method=post");
            out.println("<p>Desea");
            out.println("<input type=submit value=\"A&ntilde;adir "
                    + "art&iacute;culos\"/>");
            out.println("<input type=submit value=\"Pagar\"/>");
            out.println("</p>");
            out.println("</form>");
            out.println("</div><!-- cierro tiendaForm");

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
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Carro de compra Servlet";
    }// </editor-fold>

    private static String generarIdSesion() {
        //garantizar un id único
        String uid = new java.rmi.server.UID().toString();

        try {
            //Codificar cualquier caracter especial
            return java.net.URLEncoder.encode(uid, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CarroCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private String[] articulosComprados(String idSesion) {
        //throw new UnsupportedOperationException("Not yet implemented");

        //No implementado.
        Random rnd = new Random();
        int i, n = rnd.nextInt(8) + 1;
        String[] art = new String[n];
        for (i = 0; i < n; ++i) {
            art[i] = "art0" + i;
        }
        return art;
    }
}
