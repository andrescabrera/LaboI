<%--
    Document   : index
    Created on : 21/01/2011, 19:15:27
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P&aacute;gina JSP cuenta</title>
    </head>
    <body>
        <!--
        Incrementar el contador para esta página. El valor es
        guardado en la variable "atrCuenta" definida en el ambito de aplicación
        -->
    <c:set var="atrCuenta" scope="application" value="${atrCuenta + 1}"></c:set>
    <h1>Demostraci&oacute;n de seguimiento a nivel de aplicaci&oacute;n</h1>
    <!-- Visualizar la cuenta para esta página -->
    <p>
    ${param.parNombre}, has visitado esta p&aacute;gina
    ${atrCuenta} ${(atrCuenta > 1) ? " veces." : " vez."}
    </p>
    </body>
</html>