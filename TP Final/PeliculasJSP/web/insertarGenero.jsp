<%-- 
    Document   : insertarGenero
    Created on : 10/02/2011, 07:00:29
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page isELIgnored="false" isErrorPage="false" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
        <title>Insertar Generos de Películas</title>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <c:if test="${not empty requestScope.mensaje}">
                <p>${requestScope.mensaje}</p>
            </c:if>
            <c:choose>
                <c:when test="${empty param.nombre}">
                    <%-- Formulario Insertar Genero --%>
                    <h1>Insertar un Genero</h1>
                </c:when>
                <c:otherwise>
                    <%-- Lo agrego a la Base de Datos --%>
                    <sql:update dataSource="${bd}">
                        INSERT INTO Genero (nombre, descripcion) VALUES ('${param.nombre}', '${param.descripcion}');
                    </sql:update>
                    <p>G&eacute;nero insertado correctamente</p>
                </c:otherwise>
            </c:choose>
            <jsp:include page="formInsertarGenero.jsp"></jsp:include>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
