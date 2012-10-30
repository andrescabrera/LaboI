<%-- 
    Document   : error
    Created on : 15/02/2011, 19:58:33
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="css/estilos.css"></link>
        <title>Error</title>
    </head>
    <body>
        <div id="contenedorPrincipal">
            <jsp:include page="menu.jsp"></jsp:include>
            <h1>Error al procesar su solicitud</h1>
            <p>Vuelva a intentarlo.</p>
            <h2>Descripci&oacute;n t&eacute;cnica</h2>
            <p>Excepci&oacute;n: ${pageContext.errorData.throwable.message}</p>
            <p>Originado en: ${pageContext.errorData.requestURI}</p>
            <p>C&oacute;digo del error: ${pageContext.errorData.statusCode}</p>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
