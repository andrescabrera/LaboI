<%-- 
    Document   : agregarGeneroAPelicula
    Created on : 12/02/2011, 21:00:45
    Author     : acabrera
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${not empty param.idPel && not empty paramValues.genPeli}">
        <sql:transaction dataSource="${bd}">    
            <%-- Borro los generos de la película --%>
            <sql:update>
                DELETE FROM GeneroDeLaPelicula WHERE idPeliculas = ?
                <sql:param value="${param.idPel}"></sql:param>
            </sql:update>
            <c:forEach var="unIdDeGenero" items="${paramValues.genPeli}">
                <sql:update>
                    INSERT INTO GeneroDeLaPelicula (idGenero, idPeliculas) VALUES (?, ?);
                    <sql:param value="${unIdDeGenero}"></sql:param>
                    <sql:param value="${param.idPel}"></sql:param>
                </sql:update>
            </c:forEach>
        </sql:transaction>
        <%-- Mostrar la pel&iacute;cula modificada --%>
        <c:redirect url="mostrarPeliculas.jsp?idPel=${param.idPel}"></c:redirect>
    </c:when>
    <c:otherwise>
        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
                <title>Seleccionar g&eacute;neros</title>
            </head>
            <body>
                <div id="contenedorPrincipal">
                    <jsp:include page="menu.jsp"></jsp:include>
                    <h1>Seleccionar g&eacute;neros de la pel&iacute;cula</h1>
                    <form action="seleccionarGeneroDePelicula.jsp?idPel=${param.idPel}" method="POST">
                        <fieldset>
                            <legend>Seleccionar G&eacute;neros.</legend>
                            <jsp:include page="seleccionarGenero.jsp"></jsp:include>
                        </fieldset>
                    </form>
                </div>
                <jsp:include page="footer.jsp"></jsp:include>
            </body>
        </html>
    </c:otherwise>
</c:choose>
