<%-- 
    Document   : index
    Created on : 07/02/2011, 16:29:24
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Form: casillas de verificacion</title>
    </head>
    <body>
        <form action="casillaVer.jsp" method="post">
            <fieldset>
                <legend>Por favor selecciona los colores que
                    m&aacute;s te gustar</legend>
                <label>
                    <input type="checkbox" name="color" value="rojo"></input>
                    Rojo
                </label>
                <label>
                    <input type="checkbox" name="color" value="verde"></input>
                    Verde
                </label>
                <label>
                    <input type="checkbox" name="color" value="azul"></input>
                    Azul
                </label>
                <input type="submit" value="Enviar"></input>
            </fieldset>
        </form>
    </body>
</html>
