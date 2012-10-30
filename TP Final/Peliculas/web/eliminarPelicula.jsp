<%-- 
    Document   : eliminarPelicula
    Created on : 23/02/2011, 07:50:21
    Author     : acabrera
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isELIgnored="false" isErrorPage="false" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
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
            <form action="ControladorPeliculas" method="POST">
                <fieldset>
                    <legend>Eliminar una pel&iacute;cula</legend>
                    <p>
                        <label for="selectPelis">Seleccionar una pel&iacute;cula</label>
                        <select name="idPelis" id="selectPelis" multiple>
                            <c:forEach var="unaPeli" items="${catalogo}">
                                <option value="${unaPeli.value.idPel}">${unaPeli.value.nombre}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <input name="boton" type="submit" value="Eliminar Peliculas"></input>
                        <input type="reset" value="Restablecer"></input>
                    </p>
                </fieldset>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
