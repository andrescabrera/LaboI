
<%-- 
    Document   : eliminarGenero
    Created on : 12/02/2011, 01:41:17
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
        <title>Eliminar un G&eacute;nero</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <c:choose>
                <c:when test="${not empty paramValues.genPeli}">
                    <c:forEach var="unGenero" items="${paramValues.genPeli}">
                        <sql:transaction dataSource="${bd}">
                            <sql:update>
                                DELETE FROM GeneroDeLaPelicula WHERE idGenero = ?;
                                <sql:param value="${unGenero}"></sql:param>
                            </sql:update>
                            <sql:update>
                                DELETE FROM Genero WHERE id = ?;
                                <sql:param value="${unGenero}"></sql:param>
                            </sql:update>
                        </sql:transaction>
                    </c:forEach>
                    <c:redirect url="index.jsp"></c:redirect>
                </c:when>
                <c:otherwise>
                    <h1>Eliminar un G&eacute;nero</h1>
                    <form action="eliminarGenero.jsp" method="POST">
                        <fieldset>                            
                        <jsp:include page="seleccionarGenero.jsp"></jsp:include>
                        </fieldset>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>