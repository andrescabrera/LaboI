/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acabrera
 */
public class SvTutorias extends HttpServlet {

    private BDTutorias baseDatos;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            baseDatos = new BDTutorias();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvTutorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SvTutorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SvTutorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SvTutorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            //Obtener los datos enviados por el cliente
            String profesor = request.getParameter("profesor");
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");
            String alumno = request.getParameter("alumno");
            String asunto = request.getParameter("asunto");
            int idProfesor = -1, idTutoria = -1;
            idProfesor = baseDatos.obtenerIdProfesor(profesor);
            //out.println("<html><head></head><body><h1>profesor: " + baseDatos.obtenerIdProfesor(profesor) + "</h1>");
            //out.println("no se encontro el idProfesor.");
            if (idProfesor != -1) {
                //out.println("dia = " + dia + " hora = " + hora);
                idTutoria = baseDatos.obtenerIdTutoria(idProfesor, dia, hora);
                //out.println("idtutoria =" + idTutoria);
                if (idTutoria != -1) {

                    //Insertar una fila en la tabla citas
                    baseDatos.insertarEnCitas(idTutoria, alumno, asunto);

                    //Responder al cliente
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Respuesta a la solicitud</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Su petici&oacute;n ha sido registrada.</h1>");
                    out.println("<p>Un saludo</p>");
                    out.println("</body>");
                    out.println("</html>");
                } else
                    mostrarTutoriasDisponibles(out);
            } else
                mostrarTutoriasDisponibles(out);  
        } catch (SQLException ex) {
            Logger.getLogger(SvTutorias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

 // Devuelve un formulario html con las tutorías disponibles.
  public void mostrarTutoriasDisponibles(PrintWriter out)
  {
    try
    {
      ResultSet cdr = baseDatos.tutoriasDisponibles();
      // Mostrar el conjunto de resultados obtenido
      out.println("<html><head><title>Tutorías</title></head>" +
      "<body>");
      out.println("<h1>Tutoria no disponible.</h1>");
      out.println("<p>Escoja una de las siguientes: </p>");
      // Tabla
      out.println("<table>");
      // Cabeceras
      out.println("<tr>" +
                    "<th>Día/hora</th><th>Con el profesor</th>" +
                  "</tr>");
      // Filas
      while (cdr.next())
      {
        out.println(
         "<tr>" +
           "<td>" + cdr.getString("dia") +
                  " a las " + cdr.getString("hora") + "</td>" +
           "<td>" + cdr.getString("profesor") + "</td>" +
         "</tr>");
      }
      out.println("</table></body></html>");
    }
    catch(SQLException e)
    {
      out.println("Excepción SQL. " + e.getMessage());
    }
  }
    @Override
    public void destroy() {
        try {
            baseDatos.cerrarConexion();
        } catch (SQLException ignorada) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
        return "Servlet SvTutorias";
    }// </editor-fold>
}
