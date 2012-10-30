<%-- 
    Document   : Hola
    Created on : 07/02/2011, 05:22:39
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="miEtiqueta" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Página JSP Cuenta</title>
    </head>
    <body>
        <h1>Contador fechaHora.tag, usando el bean BeanFecha.java</h1>
        <miEtiqueta:fechaHora>
            <h2>Hola, son las ${hora}:${minutos} del d&iacute;a ${fecha}</h2>
            <p>
                ${param.parNombre}, has visitado esta p&aacute;gina
                ${cuenta} ${(cuenta > 1) ? "vez. " : " veces."}
            </p>
        </miEtiqueta:fechaHora>
    </body>
</html>
