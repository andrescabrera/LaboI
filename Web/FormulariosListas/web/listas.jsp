<%-- 
    Document   : listas
    Created on : 07/02/2011, 17:15:15
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Listas</title>
    </head>
    <body>
        <p>Mostrando la fecha ingresada, sin parsear: dia: ${param.dia}
            mes: ${param.mes} a&ntilde;o: ${param.anio}
        </p>
        <c:catch var="errorOcurrido">
            <fmt:parseDate
                parseLocale="es_ES" var="fecha"
                value="${param.dia}-${param.mes}-${param.anio}"></fmt:parseDate>
            <p>Mostrando la hora parseada:
                <fmt:formatDate value="${fecha}" dateStyle="full"></fmt:formatDate>
            </p>
        </c:catch>
        <c:if test="${not empty errorOcurrido}">
            <p>Error: el parametro día, supuestamente no es correcto: ${errorOcurrido}</p>
        </c:if>
    </body>
</html>
