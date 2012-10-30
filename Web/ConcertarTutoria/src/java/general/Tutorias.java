/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acabrera
 */
public class Tutorias extends HttpServlet {

    String carpeta = null;
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        carpeta = getInitParameter("carpeta");
        //parametro establecido en el archivo web.xml que se localiza en WEB-INF
        //del servidor
        if(carpeta == null){
            System.err.println("No se especifico la carpeta de destino");
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
            //Abro el archivo para registrar la tutoria

            FileWriter fw = new FileWriter(carpeta + "/tutorias.txt", true);
            PrintWriter ficheroTutorias = new PrintWriter(fw);

            //Tomar los datos recibidos por el cliente y escribirlos en el
            //fichero. Se finaliza cada registro con la marca <FIN> para su
            //posterior identificación.
            Enumeration nombresParams = request.getParameterNames();
            while(nombresParams.hasMoreElements()){
                String param = (String)nombresParams.nextElement();
                String valor = request.getParameter(param);
                ficheroTutorias.println(param + ": " + valor);
            }
            ficheroTutorias.println("<FIN>");

            //Cerrar el fichero
            ficheroTutorias.close();
            fw.close();

            //Responder al cliente
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Tutorias</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Tutorias at " + request.getContextPath () + "</h1>");
            out.println("<p>Su petici&oacute;n ha sido registrada</p><p>Un Saludo!</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e){
            out.println("<p>Hubo un error procesando su solicitud.</p><p>Por favor intentelo otra vez</p>");
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
        return "Servlet Tutorías";
    }// </editor-fold>

}
