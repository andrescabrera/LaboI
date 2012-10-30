<%-- 
    Document   : tratamientoDelError
    Created on : 07/02/2011, 16:00:41
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>P&aacute;gina para tratamiento de un error.</title>
    </head>
    <body>
        <h1>Error:</h1>
        <h2>El parametro mes, supuestamente deberia ser un numero, NABO!</h2>
        <p>Excepci&oacute;n ${pageContext.errorData.throwable}</p>
        <p>Petici&oacute;n que fall&oacute; ${pageContext.errorData.requestURI}</p>
        <p>C&oacute;digo de error: ${pageContext.errorData.statusCode}</p>
    </body>
</html>
