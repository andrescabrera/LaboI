<%-- 
    Document   : eliminarPelicula
    Created on : 12/02/2011, 12:31:23
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page isErrorPage="false" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<c:choose>
    <%-- si tengo los params listos, la elimino --%>
    <c:when test="${not empty param.idPelis}">
        <c:forEach var="idPel" items="${paramValues.idPelis}">
            <sql:transaction dataSource="${bd}">
                <sql:update>
                    DELETE FROM GeneroDeLaPelicula WHERE idPeliculas = ?
                    <sql:param value="${idPel}"></sql:param>
                </sql:update>
                <sql:update>
                    DELETE FROM Pelicula WHERE id = ?
                    <sql:param value="${idPel}"></sql:param>
                </sql:update>
            </sql:transaction>
        </c:forEach>
        <c:redirect url="index.jsp"></c:redirect>
    </c:when>
    <c:otherwise>
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <title>Eliminar una pel&iacute;cula</title>
                <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
            </head>
            <body>
                <div id="contenedorPrincipal">
                    <jsp:include page="menu.jsp"></jsp:include>
                    <h1>Eliminar una pel&iacute;cula</h1>
                    <jsp:include page="formEliminarPelicula.jsp"></jsp:include>
                </div>
                <jsp:include page="footer.jsp"></jsp:include>
            </body>
        </html>
    </c:otherwise>
</c:choose>