<%-- 
    Document   : InsertarFila
    Created on : 08/02/2011, 06:08:20
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Registrar una tutoria</title>
    </head>
    <body>
        <%-- Responder al cliente --%>
        <c:if test="${requestScope.operFallida == 'NO'}">
            <h3>Su petici&oacute;n ha sido registrada, un saludo</h3>
        </c:if>
        <c:if test="${requestScope.operFallida == 'SI'}">
            <h3>Error: imposible realizar la operaci&oacute;n</h3>
            <form action="SvTutorias" method="get">
                <input type="submit" value="Continuar"></input>
            </form>
        </c:if>
    </body>
</html>