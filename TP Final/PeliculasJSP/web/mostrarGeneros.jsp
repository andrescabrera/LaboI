<%-- 
    Document   : mostrarGeneros
    Created on : 11/02/2011, 15:57:43
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  isELIgnored="false" isErrorPage="false" errorPage="error.jsp" %>
<c:choose>
    <c:when test="${not empty param.parIdPel}">
        <%-- Busco el/los genero/s de una pelicula --%>
        <sql:query dataSource="${bd}" var="generosPel">
            SELECT id, nombre FROM Genero WHERE id IN
            (SELECT idGenero FROM GeneroDeLaPelicula WHERE idPeliculas = ${param.parIdPel}) LIMIT 0, 4;
        </sql:query>
        <c:if test="${generosPel.rowCount != 0}">
            <c:forEach var="unGenero" items="${generosPel.rows}">
                <a href="mostrarGeneros.jsp?idGen=${unGenero.id}" title="Ver m&aacute;s info sobre el genero">${unGenero.nombre}</a>,
            </c:forEach>
            <%-- Dar la opcion de agregar un genero a la pelicula --%>
            <a href="seleccionarGeneroDePelicula.jsp?idPel=${param.parIdPel}" title="Seleccionar g&eacute;neros">Seleccionar</a>
        </c:if>
    </c:when>
    <c:otherwise>
        <c:choose>
            <%-- Consulto por información completa de un determinado genero --%>
            <c:when test="${not empty param.idGen}">
                <sql:query dataSource="${bd}" var="generosPel">
                    SELECT id, nombre, descripcion FROM Genero where id = ${param.idGen};
                </sql:query>
            </c:when>
            <%-- Consulto por información completa de todos los generos --%>
            <c:when test="${empty param.idGen && not empty param.desde && not empty param.cant}">
                <sql:query dataSource="${bd}" var="generosPel">
                    SELECT id, nombre, descripcion FROM Genero LIMIT ${param.desde}, ${param.cant};
                </sql:query>
            </c:when>
            <c:otherwise>
                <sql:query dataSource="${bd}" var="generosPel">
                    SELECT id, nombre, descripcion FROM Genero;
                </sql:query>
            </c:otherwise>
        </c:choose>
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
                    <c:choose>
                        <c:when test="${generosPel.rowCount != 0}">
                            <%-- Muestro todos los generos --%>
                            <div id="mostrarGeneros">
                                <sql:query dataSource="${bd}" var="cantidad">
                                    SELECT COUNT(id) AS cta FROM Genero;
                                </sql:query>
                                <c:if test="${cantidad.rowCount != 0}">
                                    <c:forEach items="${cantidad.rows}" var="c">
                                        <h1>${c.cta} g&eacute;neros en el catalogo</h1>
                                    </c:forEach>
                                </c:if>
                                <c:forEach var="unGenero" items="${generosPel.rows}">
                                    <%-- Mostrar los generos de la pelicula --%>
                                    <div class="generos">
                                        <h2>${unGenero.nombre}</h2>
                                        <p>N&uacute;mero: <strong>${unGenero.id}</strong></p>
                                        <p>${unGenero.descripcion}</p>
                                        <p><a href="mostrarPeliculas.jsp?idGenero=${unGenero.id}"
                                              title="Ver pel&iacute;culas de ${unGenero.nombre}">
                                                Ver pel&iacute;culas</a></p>
                                    </div>
                                </c:forEach>
                            </div>
                            <div style="clear: both;"></div>
                            <p id="paginador">
                                <c:if test="${param.desde !=0}">
                                    <a href="mostrarGeneros.jsp?cant=${param.cant-6}&amp;desde=${param.desde-6}"
                                       title="Ver resultados anteriores">
                                        <<< Volver
                                    </a>
                                </c:if>
                            |
                                <a href="mostrarGeneros.jsp?cant=${param.cant+6}&amp;desde=${param.desde+6}"
                                   title="Ver más resultados">
                                    Ver m&aacute;s >>>
                                </a>
                            </p>
                        </c:when>
                        <c:otherwise>
                            <p>Su busqueda no arroj&oacute; resultados.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <jsp:include page="footer.jsp"></jsp:include>
            </body>
        </html>
    </c:otherwise>
</c:choose>