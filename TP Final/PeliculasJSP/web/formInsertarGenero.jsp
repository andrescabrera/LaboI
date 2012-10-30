<%-- 
    Document   : formInsertarGenero
    Created on : 10/02/2011, 07:13:56
    Author     : acabrera
--%>
<form action="insertarGenero.jsp" method="POST">
    <fieldset>
        <legend>Datos del Genero</legend>
        <p>
            <label for="nombre">Nombre: </label>
            <input type="text" name="nombre" id="nombre"></input>
        </p>
        <p>
            <label for="descripcion">Descripci&oacute;n: </label>
            <textarea cols="50" rows="10" name="descripcion"></textarea>
        </p>
        <input type="submit" value="Enviar"></input>
        <input type="reset" value="Borrar"></input>
    </fieldset>
</form>