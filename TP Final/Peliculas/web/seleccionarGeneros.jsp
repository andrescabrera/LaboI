<%-- 
    Document   : seleccionarGenero
    Created on : 27/02/2011, 15:03:18
    Author     : acabrera
--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset>
    <label for="selectPelis">Nombre del G&eacute;nero</label>
    <select id="selectPelis" name="genPelis" multiple>
        <c:forEach items="${catalogo}" var="unGenero">
            <option value="${unGenero.value.idGen}">${unGenero.value.nombre}</option>
        </c:forEach>
    </select>
</fieldset>