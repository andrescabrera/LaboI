<%-- 
    Document   : buscarPelicula
    Created on : 10/02/2011, 04:19:24
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <c:catch var="errorOcurrido">
                <fmt:parseDate
                    parseLocale="es_ES" var="fecha"
                    value="${param.dia}-${param.mes}-${param.anio}"/>
            </c:catch>
            <c:choose>
                <%-- Busco y muestro los resultados, sino muestro el form busqueda --%>
                <c:when test="${not empty param.nomPeli || not empty fecha}">
                    <c:choose>
                        <%-- -- QUERYS -- Si se ingreso un nombre y fecha, buscar por las dos --%>
                        <c:when test="${not empty param.nomPeli && not empty fecha}">
                            <sql:query dataSource="${bd}" var="coincidenciasRstset">
                                SELECT * FROM Pelicula WHERE nombre LIKE '%${param.nomPeli}%' AND fechaEstreno = '${fecha}'
                            </sql:query>
                        </c:when>
                        <%-- Sino, buscar por nombre ó por fecha --%>
                        <c:when test="${not empty param.nomPeli}">
                            <sql:query dataSource="${bd}" var="coincidenciasRstset">
                                SELECT * FROM Pelicula WHERE nombre LIKE '%${param.nomPeli}%'
                            </sql:query>
                        </c:when>
                        <c:otherwise>
                            <sql:query dataSource="${bd}" var="coincidenciasRstset">
                                SELECT * FROM Pelicula WHERE fechaEstreno = '${fecha}'
                            </sql:query>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${coincidenciasRstset.rowCount != 0}">
                            <table>
                                <caption>Resultados de la Busqueda</caption>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Fecha de Estreno</th>
                                        <th>Generos</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="unaCoinc" items="${coincidenciasRstset.rows}">
                                        <tr>
                                            <td>${unaCoinc.id}</td>
                                            <td>${unaCoinc.nombre}</td>
                                            <td>${unaCoinc.fechaEstreno}</td>
                                            <%-- Busco el/los genero/s de la pelicula --%>
                                            <sql:query dataSource="${bd}" var="generosPel">
                                                SELECT id, nombre FROM Genero WHERE id IN (SELECT idGenero FROM GeneroDeLaPelicula WHERE idPeliculas = ${unaCoinc.id} )
                                            </sql:query>
                                            <td>
                                                <c:if test="${generosPel.rowCount != 0}">
                                                    <%-- Muestro el/los genero/s --%>
                                                    <c:forEach var="unGenero" items="${generosPel.rows}">
                                                        <%-- Mostrar los generos de la pelicula --%>
                                                        <a href="mostrarGeneros.jsp?idGen=${unGenero.id}" title="Ver datos del g&eacute;nero ${unGenero.nombre}">${unGenero.nombre}</a>
                                                    </c:forEach>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <h2>No hubo resultados para su busqueda.</h2>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <c:if test="${not empty errorOcurrido}">
                        <p>Error: el parametro día no es correcto: ${errorOcurrido}</p>
                    </c:if>
                    <%-- Mostrar el formulario para ingresar la busqueda --%>
                    <h1>Buscar una pel&iacute;cula</h1>
                    <jsp:include page="formPelicula.jsp"></jsp:include>
                </c:otherwise>
            </c:choose>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>