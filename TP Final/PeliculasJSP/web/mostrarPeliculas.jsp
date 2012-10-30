<%-- 
    Document   : mostrarPeliculas
    Created on : 10/02/2011, 02:25:51
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page isELIgnored="false" isErrorPage="false" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Peliculas del Catalogo</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <c:choose>
                <c:when test="${not empty param.idPel}">
                    <%-- TODO: Mostrar una sola pel&iacute;cula --%>
                    <sql:query dataSource="${bd}" var="cjtoPels">
                        SELECT id, nombre, fechaEstreno FROM Pelicula WHERE id = ?;
                        <sql:param value="${param.idPel}"></sql:param>
                    </sql:query>
                </c:when>
                <c:when test="${not empty param.idGenero}">
                    <%-- Recupero todas las peliculas de determinado genero --%>
                    <sql:query dataSource="${bd}" var="cjtoPels">
                        SELECT id, nombre, fechaEstreno FROM Pelicula WHERE id IN (SELECT idPeliculas FROM GeneroDeLaPelicula WHERE idGenero = ?) LIMIT 0, 200;
                        <sql:param value="${param.idGenero}"></sql:param>
                    </sql:query>
                </c:when>
                <c:otherwise>
                    <%-- Recupero todas las peliculas y sus generos--%>
                    <sql:query dataSource="${bd}" var="cjtoPels">
                        SELECT id, nombre, fechaEstreno FROM Pelicula LIMIT 0, 50;
                    </sql:query>
                    <sql:query dataSource="${bd}" var="cantidad">
                        SELECT COUNT(id) AS cta FROM Pelicula;
                    </sql:query>
                </c:otherwise>
            </c:choose>
            <%-- Recorro el conjunto mostrando cada pelicula --%>
            <c:choose>
                <c:when test="${cjtoPels.rowCount != 0}">
                    <table id="tablaPeliculas" cellspacing="0" summary="Listado de Pel&iacute;culas del Catalogo">
                        <c:if test="${cantidad.rowCount != 0}">
                            <c:forEach items="${cantidad.rows}" var="c">
                                <caption>${c.cta} pel&iacute;culas en el catalogo</caption>
                            </c:forEach>
                        </c:if>
                        <colgroup>
                            <col id="idCol"/>
                            <col id="nombreCol"/>
                            <col id="fechaEstrenoCol"/>
                            <col id="generosPelCol"/>
                        </colgroup>
                        <thead>
                            <tr>
                                <th scope="col" id="idHead">ID</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Fecha de Estreno</th>
                                <th scope="col">Generos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set scope="request" var="cuenta" value="1"></c:set>
                            <c:forEach var="unaPel" items="${cjtoPels.rows}">
                                <tr class="${(cuenta%2 == 0) ? "par" : "imp"}">
                                    <td>${unaPel.id}</td>
                                    <td>${unaPel.nombre}</td>
                                    <td>${unaPel.fechaEstreno}</td>
                                    <td>
                                        <jsp:include page="mostrarGeneros.jsp?parIdPel=${unaPel.id}"></jsp:include>
                                    </td>
                                </tr>
                                <c:set scope="request" var="cuenta" value="${cuenta + 1}"></c:set>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>No hay pel&iacute;culas en la base de datos.</p>
                </c:otherwise>
            </c:choose>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
