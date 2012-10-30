/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import beans.BeanBDTutorias;
import beans.BeanDatosTutoria;
import java.sql.SQLException;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author acabrera
 */
public class SvTutorias extends HttpServlet {

    private DataSource servicioDeConexiones;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        //cambiar segun el ide, ver que onda con esta ruta
        String ctxLookup = "java:comp/env/jdbc/bdTutorias";
        try {
            //Recuperar el contexto inicial
            Context contexto = new InitialContext();
            //Referencia al servicio de conexiones
            servicioDeConexiones = (DataSource) contexto.lookup(ctxLookup);
        } catch (Exception e) {
            throw new ServletException("Imposible recuperar " + ctxLookup);
        }
    }

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
        tutoriasDisponibles(request, response);
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
        guardarEnBase(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "La parte CONTROLADOR para el Ejercicio Propuesto 1";
    }// </editor-fold>

    private void tutoriasDisponibles(HttpServletRequest request,
            HttpServletResponse response) {

        BeanBDTutorias beanBDTut = null;

        try {
            //Realizar una conexion con la base de datos
            beanBDTut = new BeanBDTutorias(servicioDeConexiones);
            //Consultar por las tutorias disponibles
            TreeSet<BeanDatosTutoria> respuesta = beanBDTut.getTutoriasDisponibles();
            int nFilas = beanBDTut.getNumFilas();
            //Poner los datos obtenidos como parametros en la petición
            request.setAttribute("tutoriasDisponibles", respuesta);
            request.setAttribute("numFilas", Integer.toString(nFilas));
            //Reenviar la petición a la página JSP especificada
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("mostrarForm.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("Excepción SQL. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                beanBDTut.cerrarConexion();
            } catch (SQLException ignorada) {
            }
        }
    }

    private void guardarEnBase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeanBDTutorias beanBDTut = null;
        String operFallida = "SI";

        try {
            //Obtener los datos enviados por el cliente
            String sID = request.getParameter("idTutoria");

            if (sID == null || sID.length() == 0) {
                return;
            }

            int idTutoria = Integer.parseInt(sID);
            String alumno = request.getParameter("alumno");
            String asunto = request.getParameter("asunto");

            //Realizar una conexión con la BD
            beanBDTut = new BeanBDTutorias(servicioDeConexiones);
            //Insertar una fila en la tabla citas
            beanBDTut.insertarEnFilas(idTutoria, alumno, asunto);
            operFallida = "NO";
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally { //pase lo que pase devolvemos la conexión
            try {
                beanBDTut.cerrarConexion();
            } catch (SQLException ignorada) {
            }
        }

        //Responder al cliente
        request.setAttribute("operFallida", operFallida);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("InsertarFila.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
}
