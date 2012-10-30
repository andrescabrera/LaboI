<%-- 
    Document   : insertarGenero
    Created on : 26/02/2011, 02:18:33
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h1>Insertar un Genero</h1>
            <form action="ControladorPeliculas" method="POST">
                <fieldset>
                    <legend>Datos del Genero</legend>
                    <p>
                        <label for="nombre">Nombre: </label>
                        <input type="text" name="nomGenero" id="nombre"></input>
                    </p>
                    <p>
                        <label for="descripcion">Descripci&oacute;n: </label>
                        <textarea cols="50" rows="10" name="descGen" id ="descripcion"></textarea>
                    </p>
                </fieldset>
                <input type="submit" name="boton" value="Insertar Genero"></input>
                <input type="reset" value="Restablecer"></input>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
