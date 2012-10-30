<%-- 
    Document   : formInsertarPelicula
    Created on : 10/02/2011, 07:14:08
    Author     : acabrera
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${param.parAction}" method="post">
    <fieldset>
        <legend>Completar los datos de la pel&iacute;cula</legend>
        <p>
            <label for="nomPeli">Nombre: </label>
            <input id="nomPeli" type="text" name="nomPeli"></input>
        </p>
        <fieldset id="fecha">
            <legend>Fecha de Estreno: </legend>
            <label for="dia">Dia: </label>
            <select id="dia" name="dia">
                <option value="n">-</option>
                <c:forEach var="dia" begin="1" end="31">
                    <option value="${dia}">${dia}</option>
                </c:forEach>
            </select>
            <label for="mes">Mes: </label>
            <select id="mes" name="mes">
                <option value="n">-</option>
                <option value="ene">Enero</option>
                <option value="feb">Febrero</option>
                <option value="mar">Marzo</option>
                <option value="abr">Abril</option>
                <option value="may">Mayo</option>
                <option value="jun">Junio</option>
                <option value="jul">Julio</option>
                <option value="ago">Agosto</option>
                <option value="sep">Septiembre</option>
                <option value="oct">Octubre</option>
                <option value="nov">Noviembre</option>
                <option value="dic">Diciembre</option>
            </select>
            <label for="anio">A&ntilde;o: </label>
            <select id="anio" name="anio">
                <option value="n">-</option>
                <c:forEach begin="1900" end="2020" var="anio">
                    <option value="${anio}">${anio}</option>
                </c:forEach>
            </select>
        </fieldset>
        <jsp:include page="seleccionarGenero.jsp"></jsp:include>
    </fieldset>
</form>