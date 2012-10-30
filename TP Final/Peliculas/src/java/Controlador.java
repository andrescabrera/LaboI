
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.BeanBDPeliculas;

/**
 * Servlet Controlador
 * @author acabrera
 */
public class Controlador extends HttpServlet {

    private DataSource srvCon;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        try {
            Context cntxt = new InitialContext();
            srvCon = (javax.sql.DataSource) cntxt.lookup("java:comp/env/jdbc/bdPeliculas");
        } catch (Exception e) {
            throw new ServletException("Imposible recuperar el DataSource.", e);
        }
    }

    //Obtengo los datos y me muevo hacia la pagina correspondiente
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanBDPeliculas bdPels = null;
        HashMap respuesta = null;
        String opc = request.getParameter("opc"); //opcion del menu
        String dispStr = "/index.jsp"; //string para el dispatcher
        try {
            bdPels = new BeanBDPeliculas(srvCon);
            if (opc != null || opc.length() != 0) {
                int accion = Integer.parseInt(opc);
                switch (accion) {
                    case 1:
                        respuesta = bdPels.getPeliculas();
                        String caption = bdPels.getNumFilas() + " peliculas en el catalogo.";
                        request.setAttribute("caption", caption);
                        dispStr = "/mostrarPeliculas.jsp";
                        break;
                    case 2:
                        respuesta = bdPels.getGeneros();
                        request.setAttribute("numFilas", bdPels.getNumFilas());
                        dispStr = "/mostrarGeneros.jsp";
                        break;
                    case 3:
                        respuesta = bdPels.getPeliculas();
                        dispStr = "/eliminarPelicula.jsp";
                        break;
                    case 4:
                        respuesta = bdPels.getGeneros();
                        dispStr = "/eliminarGenero.jsp";
                        break;
                    case 5:
                        respuesta = bdPels.getGeneros();
                        dispStr = "/insertarPelicula.jsp";
                        break;
                    case 6:
                        respuesta = bdPels.getGeneros();
                        dispStr = "/insertarGenero.jsp";
                        break;
                    case 7:
                        respuesta = bdPels.getGeneros();
                        dispStr = "/buscarPeliculas.jsp";
                        break;
                }
            }
            request.setAttribute("catalogo", respuesta);
            RequestDispatcher dispat = request.getRequestDispatcher(dispStr);
            if (dispat != null) {
                dispat.forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("resltOp", "Error: " +ex);
            RequestDispatcher dispat = request.getRequestDispatcher(dispStr);
            if (dispat != null) {
                dispat.forward(request, response);
            }            
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bdPels.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Proceso los formularios
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //HttpSession sesion = request.getSession(true); //TODO: control de sesiones - NO IMPLEMENTADO
        BeanBDPeliculas bdPels = null;
        HashMap respuesta = null;
        //String ruta = getUrl(request); //TODO: la ruta - NO IMPLEMENTADO
        String dispStr = "/index.jsp"; //string para el dispatcher
        String boton = request.getParameter("boton"); //value del submmit, para saber de donde vengo
        try {
            bdPels = new BeanBDPeliculas(srvCon);
            if (boton.equals("Eliminar Generos")) {
                //Eliminar los generos
                String[] generosAEliminar = request.getParameterValues("genPelis");
                if (generosAEliminar != null && generosAEliminar.length != 0) {
                    for (String idGen : generosAEliminar) {
                        bdPels.eliminarGenero(Integer.parseInt(idGen));
                    }
                    request.setAttribute("resltOp", "Genero eliminado correctamente.");
                } else {
                    request.setAttribute("resltOp", "Ningún genero seleccionado.");
                }
                respuesta = bdPels.getGeneros();
                dispStr = "/eliminarGenero.jsp";
            } else if (boton.equals("Ver Peliculas")) {
                //Mostrar las peliculas de un genero
                String idGeneroP = request.getParameter("idGenero");
                if (idGeneroP != null) {
                    respuesta = bdPels.getPeliculasPorGenero(Integer.parseInt(idGeneroP));
                    String caption = bdPels.getNumFilas() + " peliculas en el genero.";
                    request.setAttribute("caption", caption);
                }
                dispStr = "/mostrarPeliculas.jsp";
            } else if (boton.equals("Eliminar Peliculas")) {
                //Eliminar peliculas
                String[] idPelsAEliminar = request.getParameterValues("idPelis");
                if (idPelsAEliminar != null) {
                    for (String unaPel : idPelsAEliminar) {
                        bdPels.eliminarPelicula(Integer.parseInt(unaPel));
                    }
                    request.setAttribute("resltOp", "Peliculas eliminadas correctamente.");
                    respuesta = bdPels.getPeliculas();
                }
                dispStr = "/eliminarPelicula.jsp";
            } else if (boton.equals("Insertar Pelicula")) {
                //Insertar Pelicula
                String nomPel = request.getParameter("nomPeli");
                int idPeli = 0;
                String[] generosPeli = request.getParameterValues("genPelis");
                String fechaEstreno = getFecha(request.getParameter("dia"), request.getParameter("mes"), request.getParameter("anio"));
                if (nomPel != null && nomPel.length() != 0) {
                    if (fechaEstreno == null) {
                        idPeli = bdPels.altaPelicula(nomPel);
                    } else {
                        idPeli = bdPels.altaPelicula(nomPel, fechaEstreno);
                    }
                    if (generosPeli != null && generosPeli.length != 0) {
                        bdPels.agregarGenerosPelicula(generosPeli, idPeli);
                    }
                    request.setAttribute("resltOp", "Pelicula insertada correctamente.");
                } else {
                    request.setAttribute("resltOp", "Problema al insertar. Falta el nombre de la pelicula.");
                }
                respuesta = bdPels.getGeneros();
                dispStr = "/insertarPelicula.jsp";
            } else if (boton.equals("Buscar Pelicula")) {
                //Buscar una pelicula
                String nomPel = request.getParameter("nomPeli");
                String fechaEstreno = getFecha(request.getParameter("dia"), request.getParameter("mes"), request.getParameter("anio"));
                if (nomPel != null) {
                    if (fechaEstreno == null) {
                        respuesta = bdPels.buscarPeliculas(nomPel);
                    } else {
                        respuesta = bdPels.buscarPeliculas(nomPel, fechaEstreno);
                    }
                    request.setAttribute("caption", nomPel);
                    request.setAttribute("resltOp", "Hay " + bdPels.getNumFilas() + " peliculas coincidentes con su busqueda.");
                    dispStr = "/mostrarPeliculas.jsp";
                }
            } else if (boton.equals("Insertar Genero")) {
                String nomGen = request.getParameter("nomGenero");
                String descGen = request.getParameter("descGenero");
                if (nomGen != null && nomGen.length() != 0) {
                    if (descGen != null && descGen.length() != 0) {
                        bdPels.altaGenero(nomGen, descGen);
                    } else {
                        bdPels.altaGenero(nomGen);
                    }
                    request.setAttribute("resltOp", "Género insertado correctamente.");
                } else {
                    request.setAttribute("resltOp", "Error al insertar el genero, falta el nombre.");
                }
                dispStr = "/insertarGenero.jsp";
            } else if (boton.equals("Seleccionar...")) {
                String idPel = request.getParameter("idPel");
                String nomPel = request.getParameter("nomPel");
                if (idPel != null && idPel.length() != 0) {
                    request.setAttribute("idPel", idPel);
                    request.setAttribute("nomPel", nomPel);
                }
                respuesta = bdPels.getGeneros();
                dispStr = "/agregarGenerosAPelicula.jsp";
            } else if (boton.equals("Seleccionar Generos")) {
                //Agrega los generos seleccionados a una pelicula
                String idPelicula = request.getParameter("idPel");
                String[] generosParaAgregar = request.getParameterValues("genPelis");
                if (generosParaAgregar != null && generosParaAgregar.length != 0 && idPelicula != null) {
                    bdPels.agregarGenerosPelicula(generosParaAgregar, Integer.parseInt(idPelicula));
                    request.setAttribute("resltOp", "Generos agregados correctamente.");
                } else {
                    request.setAttribute("resltOp", "Error: Ningún genero seleccionado.");
                }
                respuesta = bdPels.getPeliculas();
                dispStr = "/mostrarPeliculas.jsp";
            }
            //en todos los casos
            request.setAttribute("catalogo", respuesta);
            RequestDispatcher dispat = request.getRequestDispatcher(dispStr);
            if (dispat != null) {
                dispat.forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("resltOp", "Error:" + ex);
            RequestDispatcher dispat = request.getRequestDispatcher(dispStr);
            if (dispat != null) {
                dispat.forward(request, response);
            }            
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bdPels.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "El controlador de la aplicación Gestor de Películas";
    }

    //Formateo y devuelvo la URL completa
    public String getUrl(HttpServletRequest req) {
        String reqUrl = req.getRequestURL().toString();
        String queryString = req.getQueryString();   // d=789
        if (queryString != null) {
            reqUrl += "?" + queryString;
        }
        return reqUrl;
    }

    //Compongo la fecha
    public String getFecha(String dia, String mes, String anio) {
        String fecha = null;
        if (dia != null && mes != null && anio != null && dia.length() != 0 && mes.length() != 0 && anio.length() != 0) {
            fecha = dia + "/" + mes + "/" + anio;
        }
        return fecha;
    }
}
