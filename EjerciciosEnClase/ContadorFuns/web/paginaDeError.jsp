<%-- 
    Document   : paginaDeError
    Created on : 07/02/2011, 15:55:51
    Author     : acabrera
--%>

<%@page isErrorPage="false" errorPage="tratamientoDelError.jsp"
        contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Pagina donde puede ocurrir un error.</title>
    </head>
    <body>
        <c:set var="nMes" value="${param.mes}"></c:set>
        <p>El valor de nMes es: ${nMes}</p>
        <p>Ejecutar una multiplicacion: ${nMes * 3}</p>
    </body>
</html>
