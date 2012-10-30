<%-- 
    Document   : index
    Created on : 07/02/2011, 16:52:38
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Formulario con listas</title>
    </head>
    <body>
        <form action="listas.jsp" method="post">
            <fieldset>
                <legend>Seleccione la fecha</legend>
                <select name="dia">
                    <c:forEach begin="1" end="31" var="dia">
                        <option>${dia}</option>
                    </c:forEach>
                </select>
                <select name="mes">
                    <option value="ene">Enero</option>
                    <option value="feb">Febrero</option>
                    <option value="mar">Marzo</option>
                    <option value="abri">Abril</option>
                    <option value="may">Mayo</option>
                    <option value="jun">Junio</option>
                    <option value="jul">Julio</option>
                    <option value="ago">Agosto</option>
                    <option value="sep">Septiembre</option>
                    <option value="oct">Octubre</option>
                    <option value="nov">Noviembre</option>
                    <option value="dic">Diciembre</option>
                </select>
                <select name="anio">
                    <c:forEach begin="1980" end="2015" var="anio">
                        <option>${anio}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Enviar"></input>
            </fieldset>
        </form>
    </body>
</html>
