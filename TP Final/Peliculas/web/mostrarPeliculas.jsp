<%-- 
    Document   : mostrarPeliculas
    Created on : 10/02/2011, 02:25:51
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" isErrorPage="false" errorPage="error.jsp"%>
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
            <%-- Recorro el conjunto mostrando cada pelicula --%>
            <table id="tablaPeliculas" cellspacing="0" summary="Listado de Pel&iacute;culas del Catalogo">
                <caption>${caption}</caption>
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
                    <c:set scope="page" var="cuenta" value="1"></c:set>
                    <c:forEach var="unaPel" items="${catalogo}">
                        <tr class="${(cuenta%2 == 0) ? "par" : "imp"}">
                            <td>${unaPel.value.idPel}</td>
                            <td>${unaPel.value.nombre}</td>
                            <td><fmt:formatDate value="${unaPel.value.fechaEstreno}" dateStyle="long" type="date"></fmt:formatDate></td>
                            <td>
                                <c:forEach var="genPeli" items="${unaPel.value.generosPelicula}">
                                    ${genPeli.value.nombre},
                                </c:forEach>
                                <form action="ControladorPeliculas" method="post">
                                    <input type="hidden" name="nomPel" value="${unaPel.value.nombre}"></input>
                                    <input type="hidden" name="idPel" value="${unaPel.value.idPel}"></input>
                                    <input type="submit" name="boton" value="Seleccionar..."></input>
                                </form>
                            </td>
                        </tr>
                        <c:set scope="page" var="cuenta" value="${cuenta + 1}"></c:set>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
