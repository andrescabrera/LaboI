<%-- 
    Document   : index
    Created on : 05/02/2011, 18:57:25
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/miBiblioteca" prefix="miBiblioteca" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="archivoTag" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página cuenta.jsp</title>
    </head>
    <body>
        <c:set var="attrCuenta" scope="application" value="${miBiblioteca:incUno(attrCuenta)}"></c:set>
        <h1>Demostración de seguimiento a nivel de aplicación</h1>
        <p>${param.parNombre}, has visitado esta página
        ${attrCuenta} ${(attrCuenta > 1) ? " veces." : " vez."}</p>
        <h2>Mostrando la etiqueta fecha: <miBiblioteca:fecha></miBiblioteca:fecha></h2>
        <h3>Mostrando la etiqueta fecha con atributos: </h3>
        <miBiblioteca:fechaAttr formato="12">
            <p>
                Son las ${hora} horas ${minutos} minutos,
                del d&iacute;a ${fecha}
            </p>
        </miBiblioteca:fechaAttr>
        <archivoTag:saludo unmensaje="Le estoy mandando un menaje desde el
                           archivo saludo.tag"></archivoTag:saludo>
    </body>
</html>