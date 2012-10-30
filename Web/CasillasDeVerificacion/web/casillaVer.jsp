<%-- 
    Document   : casillaVer
    Created on : 07/02/2011, 16:41:36
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Casillas de verificacion seleccionadas.</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty paramValues.color}">
                <h2>Tus colores favoritos son:</h2>
                <ul>
                    <c:forEach var="item" items="${paramValues.color}">
                        <li>${item}</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <h2>No te gusta ninguno de esos colores, nabo?</h2>
            </c:otherwise>
        </c:choose>
    </body>
</html>
