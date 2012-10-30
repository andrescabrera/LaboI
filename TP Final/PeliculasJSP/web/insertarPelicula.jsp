<%-- 
    Document   : insertarPelicula
    Created on : 10/02/2011, 06:54:58
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" isErrorPage="false" errorPage="errorAlInsertar.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Insertar una Pel&iacute;cula</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <h1>Insertar una pel&iacute;cula</h1>
            <%-- Recuperar los generos --%>
            <sql:query dataSource="${bd}" var="generos">
                SELECT * FROM Genero;
            </sql:query>
            <%-- Si no hay generos, inserto uno y vuelvo --%>
            <c:if test="${generos.rowCount == 0 || param.genPeli == 'insGen'}">
                <c:set scope="request" var="mensaje" property="No hay generos en la BD, cree uno nuevo por favor."></c:set>
                <jsp:forward page="insertarGenero.jsp"></jsp:forward>
            </c:if>
            <%-- Parseo la fecha --%>
            <c:if test="${not empty param.dia && param.dia!='n' && param.mes!='n' && param.anio!='n'}">
                <c:catch var="errorOcurrido">
                    <fmt:parseDate
                        parseLocale="es_ES" var="fecha"
                        value="${param.dia}-${param.mes}-${param.anio}"></fmt:parseDate>
                </c:catch>
            </c:if>
            <%-- Si existen los parametros, guardo en la base --%>
            <c:if test="${not empty param.nomPeli && empty errorOcurrido}">
                <sql:transaction dataSource="${bd}">
                    <c:choose>
                        <c:when test="${not empty fecha}">
                            <sql:update>
                                INSERT INTO `Pelicula` (`nombre`,`fechaEstreno`) VALUES ('${param.nomPeli}',
                                '<fmt:formatDate value="${fecha}" pattern="yyyy-MM-dd"></fmt:formatDate>');
                            </sql:update>
                        </c:when>
                        <c:otherwise>
                            <sql:update>
                                INSERT INTO `Pelicula` (`nombre`) VALUES ('${param.nomPeli}');
                            </sql:update>
                        </c:otherwise>
                    </c:choose>
                    <sql:query var="ultId">
                        SELECT id FROM Pelicula WHERE id IN (SELECT LAST_INSERT_ID())
                    </sql:query>
                    <c:if test="${ultId.rowCount != 0}">
                        <c:forEach var="idUltPel" items="${ultId.rows}">
                            <c:forEach var="unGenPel" items="${paramValues.genPeli}">
                                <sql:update>
                                    INSERT INTO GeneroDeLaPelicula (idPeliculas, idGenero) VALUES (${idUltPel.id}, ${unGenPel})
                                </sql:update>
                            </c:forEach>
                        </c:forEach>
                        <p class="msg">Película insertada correctamente.</p>
                    </c:if>
                </sql:transaction>
            </c:if>
            <%-- Si no existen los parametros, o hubo un error al parsear la fecha, muestro el form --%>
            <c:if test="${empty param.nomPeli || empty dia || not empty errorOcurrido}">
                <c:if test="${not empty errorOcurrido}">
                    <p>Lo siento, el parametro día no es correcto: ${errorOcurrido}</p>
                </c:if>
                <jsp:include page="formPelicula.jsp?parAction=insertarPelicula.jsp"></jsp:include>
            </c:if>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>