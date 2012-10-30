<%-- 
    Document   : mostrarForm
    Created on : 08/02/2011, 05:41:41
    Author     : acabrera
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Concertar una tutoria</title>
    </head>
    <body>
        <h1>Concertar una tutoria</h1>
        <c:if test="${requestScope[numFilas] == 0}">
            <p>Todas las tutorias están concertadas</p>
        </c:if>
        <c:if test="${requestScope[numFilas] != 0}">
            <%-- Mostrar el formulario --%>
            <form action="SvTutorias" method="post">
                <p>
                    <label for="alumno">Alumno: </label>
                    <input id="alumno" type="text" name="alumno"></input>
                </p>
                <%-- Lista desplegable con los ids --%>
                <label for="idTutoria">Id de la Tutoria: </label>
                <select name="idTutoria">
                    <c:forEach
                        var="fila"
                        items="${requestScope.tutoriasDisponibles}">
                        <option>${fila.idTutoria}</option>
                    </c:forEach>
                </select>
                <%-- Mostrar el resultado (cjtRes) en una tabla --%>
                <table>
                    <%-- Cabeceras --%>
                    <tr>
                        <th>Id tutoria</th>
                        <th>Con el profesor</th>
                    </tr>
                    <%-- Filas --%>
                    <c:forEach
                        var="fila"
                        items="${requestScope.tutoriasDisponibles}">
                        <tr>
                            <td>${fila.idTutoria}</td>
                            <td>${fila.dia} a las ${fila.hora}</td>
                            <td>${fila.profesor}</td>
                        </tr>
                    </c:forEach>
                </table>
                <label for="asunto">Asunto: </label>
                <textarea name="asunto" rows="5" cols="53"></textarea>
                <input type="submit" value="Enviar"></input>
                <input type="reset"></input>
            </form>
        </c:if>
    </body>
</html>
