<%-- 
    Document   : index
    Created on : 07/02/2011, 16:14:12
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP: Formularios</title>
        <style type="text/css">
            body{
                width: 600px;
            }
            form{
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <c:if test="${!empty param['nombre']}">
            <jsp:forward page="saludo.jsp"></jsp:forward>
        </c:if>
        <h3>Rellenar un formulario</h3>
        <form action="index.jsp" method="get">
            <label for="nombre">Nombre:</label>
            <input id="nombre" name="nombre" type="text" value="${param['nombre']}"></input>
        </form>
    </body>
</html>
