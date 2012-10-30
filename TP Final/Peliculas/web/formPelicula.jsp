<%-- 
    Document   : formPelicula
    Created on : 26/02/2011, 02:36:41
    Author     : acabrera
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>Datos de la pel&iacute;cula</legend>
    <p>
        <label for="nomPeli">Nombre: </label>
        <input id="nomPeli" type="text" name="nomPeli"></input>
    </p>
    <fieldset id="fecha">
        <legend>Fecha de Estreno: </legend>
        <label for="dia">Dia: </label>
        <select id="dia" name="dia">
            <option value="">-</option>
            <c:forEach var="dia" begin="1" end="31">
                <option value="${dia}">${dia}</option>
            </c:forEach>
        </select>
        <label for="mes">Mes: </label>
        <select id="mes" name="mes">
            <option value="">-</option>
            <option value="01">Enero</option>
            <option value="02">Febrero</option>
            <option value="03">Marzo</option>
            <option value="04">Abril</option>
            <option value="05">Mayo</option>
            <option value="06">Junio</option>
            <option value="07">Julio</option>
            <option value="08">Agosto</option>
            <option value="09">Septiembre</option>
            <option value="10">Octubre</option>
            <option value="11">Noviembre</option>
            <option value="12">Diciembre</option>
        </select>
        <label for="anio">A&ntilde;o: </label>
        <select id="anio" name="anio">
            <option value="">-</option>
            <c:forEach begin="1895" end="2012" var="anio">
                <option value="${anio}">${anio}</option>
            </c:forEach>
        </select>
    </fieldset>
</fieldset>