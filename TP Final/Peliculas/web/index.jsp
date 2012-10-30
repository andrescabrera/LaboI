<%--
    Document   : index
    Created on : 10/02/2011, 02:22:46
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
        <title>Pagina de Bienvenida al Catalogo de Películas</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <h1>Bienvenido al Catalogo de Pel&iacute;culas</h1>
            <h2>Descripcion del Software</h2>
            <p>Proyecto realizado para la presentaci&oacute;n final de la materia <span>Laboratorio 1</span> de la <span>Universidad de Palermo</span></p>
            <p>Curso <span>a&ntilde;o 2010 segundo cuatrimestre</span>.</p>
            <p>Catedra: <span>Claudio Zamoszcyk</span>.</p>
            <h2>Se us&oacute; para esta demostraci&oacute;n</h2>
            <ul id="listaDemo">
                <li class="dstc"><p><a href="http://www.oracle.com/technetwork/java/javaee/jsp/index.html" title="JavaServer Pages Technology">JSP v2</a>, <a href="http://www.oracle.com/technetwork/java/index-jsp-135995.html" title="JavaServer Pages Standard Tag Library">JSTL v1.2</a>, JSP Expression Language</p></li>
                <li class="dstc"><p><a href="http://tomcat.apache.org/" title="Servidor de aplicaciones Tomcat">Apache Tomcat 6</a></p></li>
                <li class="dstc"><p><a href="http://www.mysql.com" title="Mysql Server">Mysql Server v5</a>, Conector J - JDBC Driver</p></li>
                <li class="dstc"><p><a href="http://validator.w3.org/" title="XHtml Validator">XHtml v1.1</a></p></li>
                <li class="dstc"><p><a href="http://jigsaw.w3.org/css-validator/" title="CSS Validator">CSS v2.1</a></p></li>
            </ul>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>