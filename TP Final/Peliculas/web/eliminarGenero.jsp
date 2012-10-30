<%-- 
    Document   : eliminarGenero
    Created on : 12/02/2011, 01:41:17
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Eliminar un G&eacute;nero</h1>
            <form action="ControladorPeliculas" method="POST">
                <jsp:include page="seleccionarGeneros.jsp"></jsp:include>
                <p>
                    <input type="submit" name="boton" value="Eliminar Generos"></input>
                    <input type="reset" value="Restablecer"></input>
                </p>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>