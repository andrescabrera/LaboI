<%-- 
    Document   : formEliminarPelicula
    Created on : 12/02/2011, 20:06:14
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:query var="cdr" dataSource="${bd}">
    SELECT id, nombre FROM Pelicula ORDER BY nombre LIMIT 0, 200;
</sql:query>
<form action="eliminarPelicula.jsp" action="POST">
    <fieldset>
        <legend>Eliminar una pel&iacute;cula</legend>
        <p>
            <label for="selectPelis">Seleccionar una pel&iacute;cula</label>
            <select name="idPelis" id="selectPelis" multiple>
                <c:forEach var="unaPeli" items="${cdr.rows}">
                    <option value="${unaPeli.id}">${unaPeli.nombre}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <input type="submit" value="Eliminar"></input>
            <input type="reset" value="Restablecer"></input>
        </p>
    </fieldset>
</form>
