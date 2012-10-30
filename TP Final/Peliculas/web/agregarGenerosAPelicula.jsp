<%-- 
    Document   : agregarGenerosAPelicula
    Created on : 27/02/2011, 15:06:22
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Seleccionar g&eacute;neros para ${nomPel}</title>
        <link type="text/css" href="css/estilos.css" rel="stylesheet"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <h1>${nomPel}: seleccionar g&eacute;neros.</h1>
            <form action="ControladorPeliculas" method="POST">
                <jsp:include page="seleccionarGeneros.jsp"></jsp:include>
                <p>
                    <input type="hidden" name="idPel" value="${idPel}"></input>
                    <input type="submit" name="boton" value="Seleccionar Generos"></input>
                    <input type="reset" value="Restablecer"></input>
                </p>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
