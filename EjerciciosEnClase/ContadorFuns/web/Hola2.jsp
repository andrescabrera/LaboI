<%-- 
    Document   : Hola2
    Created on : 07/02/2011, 05:52:07
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="miEtiqueta" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Página JSP Cuenta 2 - usando Fragmentos</title>
    </head>
    <body>
        <h1>Página JSP Cuenta 2 - usando Fragmentos</h1>
        <miEtiqueta:fechaHoraFragmentos>
            <jsp:attribute name="mostrarFechaHora">
                <h2>
                    Hola, son las ${hora}:${minutos}, del d&iacute;a ${fecha}
                </h2>
            </jsp:attribute>
            <jsp:attribute name="mostrarCuenta">
                <p>
                    ${param.parNombre}, has visitado esta p&aacute;gina
                    ${cuenta} ${(cuenta > 1) ? " veces." : " vez."}
                </p>
            </jsp:attribute>
        </miEtiqueta:fechaHoraFragmentos>
    </body>
</html>
