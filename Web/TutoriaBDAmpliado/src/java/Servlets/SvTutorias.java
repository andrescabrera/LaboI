/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void init() throws ServletException {
        super.init();

        baseDatos = new BDTutorias();       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter salida = response.getWriter();
        mostrarFormulario(salida);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter salida = response.getWriter();
        try {
        String sID = request.getParameter("idTutoria");
        if(sID == null || sID.length() == 0)
            return;
        int id_tutoria = Integer.parseInt(sID);
        String alumno = request.getParameter("alumno");
        String asunto = request.getParameter("asunto");

        //Insertar una fila en la tabla citas
        baseDatos.insertarEnCitas(id_tutoria, alumno, asunto);
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<title>Respuesta a su solicitud</title>");
        salida.println("</head>");
        salida.println("<body>");
        salida.println("<p>Solicitud recibida, un saludo</p>");
        salida.println("</body>");
        salida.println("</html>");
        } catch (SQLException sqlEx) {
            salida.println("<html>");
            salida.println("<head>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("<h1>Imposible realizar la operacion</h1>");
            salida.println("<p><a href='SvTutorias'>continuar...</a></p>");
            salida.println("</body>");
            salida.println("</html>");
            response.setHeader("Refresh", "5; URL=SvTutorias");

        }
        salida.close();
    }

    @Override
    public String getServletInfo() {
        return "Un servlet para procesar las peticiones.";
    }

    private void mostrarFormulario(PrintWriter salida) {
        try {
            ResultSet cdr = baseDatos.tutoriasDisponibles();
            salida.println("<html>");
            salida.println("<head>");
            salida.println("<title>Concertar una tutoria</title>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("<h1>Concertar una tutoria</h1>");
            if(cdr.isBeforeFirst() == false){
                salida.println("<h2>Todas las tutorias están ocupadas</h2>");
                salida.println("</body></html>");
                return;
            }
            salida.println("<form action='SvTutorias' method=*****66ASAs4h54H54H54h54hasd>");
            salida.println("</body>");
            salida.println("</html>");

        }
    }

}
