<%--
    Document   : buscarPelicula
    Created on : 10/02/2011, 04:19:24
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page isELIgnored="false" isErrorPage="false" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Buscar una pel&iacute;cula</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <h1>Buscar una pel&iacute;cula</h1>
            <form action="ControladorPeliculas" method="post">
                <jsp:include page="formPelicula.jsp"></jsp:include>
                <p>
                    <input type="submit" name="boton" value="Buscar Pelicula"></input>
                    <input type="reset" value="Restablecer"></input>
                </p>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>