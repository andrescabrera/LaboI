<%-- 
    Document   : menu
    Created on : 10/02/2011, 05:48:52
    Author     : acabrera
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p id="marca">Gesti&oacute;n del catalogo de pel&iacute;culas</p>
<ul id ="menu">
    <li class="first"><a href="/Peliculas">Inicio</a></li>
    <li><a href="ControladorPeliculas?opc=5">Insertar Pel&iacute;cula</a></li>
    <li><a href="ControladorPeliculas?opc=3">Eliminar Pel&iacute;cula</a></li>
    <li><a href="ControladorPeliculas?opc=1">Mostrar Pel&iacute;culas</a></li>
    <li><a href="ControladorPeliculas?opc=7">Buscar Pel&iacute;culas</a></li>
    <li><a href="ControladorPeliculas?opc=2">Mostrar Generos</a></li>
    <li><a href="ControladorPeliculas?opc=6">Insertar Genero</a></li>
    <li><a href="ControladorPeliculas?opc=4">Eliminar Genero</a></li>
</ul>
<div id="mensaje">
    <p>${resltOp}</p>
</div>