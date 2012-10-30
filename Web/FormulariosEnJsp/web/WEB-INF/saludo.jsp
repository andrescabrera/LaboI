<%-- 
    Document   : saludo
    Created on : 07/02/2011, 16:22:54
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Pagina JSP que manda un saludo</title>
    </head>
    <body>
        <h1>Hola: ${param.nombre}</h1>
    </body>
</html>
