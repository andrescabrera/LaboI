<%-- 
    Document   : insertarPelicula
    Created on : 10/02/2011, 06:54:58
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" isErrorPage="false" errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <form action="ControladorPeliculas" method="post">
                <jsp:include page="formPelicula.jsp"></jsp:include>
                <fieldset>
                    <label for="selectPelis">G&eacute;neros de la pel&iacute;cula</label>
                    <select id="selectPelis" name="genPelis" multiple>
                        <c:forEach items="${catalogo}" var="unGenero">
                            <option value="${unGenero.value.idGen}">${unGenero.value.nombre}</option>
                        </c:forEach>
                    </select>
                </fieldset>
                <p>
                    <input type="submit" name="boton" value="Insertar Pelicula"></input>
                    <input type="reset" value="Restablecer"></input>
                </p>
            </form>
        </div>
    </body>
</html>