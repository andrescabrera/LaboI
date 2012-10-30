<%-- 
    Document   : seleccionarGenero
    Created on : 11/02/2011, 19:53:56
    Author     : acabrera
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<label for="selectPelis">Nombre del G&eacute;nero</label>
<select id="selectPelis" name="genPeli" multiple>
    <option></option>
    <c:if test="${pageContext.request.requestURI == '/PeliculasJSP/insertarPelicula.jsp'}">
        <option value="insGen">Insertar un nuevo Genero...</option>
    </c:if>
    <c:forEach items="${catalogo}" var="unGenero">
        <option value="${unGenero.idGen}">${unGenero.nombre}</option>
    </c:forEach>
</select>
<p>
    <input type="submit" value="Enviar"></input>
    <input type="reset" value="Restablecer"></input>
</p>