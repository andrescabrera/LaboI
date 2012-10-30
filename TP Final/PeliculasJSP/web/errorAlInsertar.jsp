<%-- 
    Document   : errorAlInsertar
    Created on : 12/02/2011, 10:08:49
    Author     : acabrera
--%>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Error al insertar</title>
        <link rel="stylesheet" href="css/estilos.css" type="text/css"></link>
    </head>
    <body>
        <h1>Lo sentimos, no se pudo completar su solicitud: </h1>
        <p>Problema al insertar la pel&iacute;cula o registrar su g&eacute;nero.</p>
        <h2>Descripci&oacute;n t&eacute;cnica</h2>
        <p>Excepci&oacute;n: ${pageContext.errorData.throwable}</p>
        <p>Originado en: ${pageContext.errorData.requestURI}</p>
        <p>C&oacute;digo del error: ${pageContext.errorData.statusCode}</p>
    </body>
</html>