<%--
    Document   : mostrarGeneros
    Created on : 10/02/2011, 02:25:51
    Author     : acabrera
--%>
<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Mostrar G&eacute;nero</title>
        <link rel="stylesheet" href="css/estilos.css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <%-- Muestro todos los generos --%>
            <div id="mostrarGeneros">
                <h1>${numFilas} g&eacute;neros en el catalogo</h1>
                <c:forEach var="unGenero" items="${catalogo}">
                    <%-- Mostrar los generos de la pelicula --%>
                    <div class="generos">
                        <h2><c:out value="${unGenero.value.nombre}"></c:out></h2>
                        <p>N&uacute;mero: <strong><c:out value="${unGenero.value.idGen}"></c:out></strong></p>
                        <p><c:out value="${unGenero.value.descripcion}"></c:out></p>
                        <form id="verPelisDelGenero" action="ControladorPeliculas?opc=2" method="POST">
                            <input type="hidden" name="idGenero" value="${unGenero.value.idGen}"></input>
                            <input type="submit" name="boton" value="Ver Peliculas"></input>
                        </form>
                    </div>
                </c:forEach>
            </div>
            <div style="clear: both;"></div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>