<%-- 
    Document   : mostrarTabla
    Created on : 07/02/2011, 03:01:05
    Author     : acabrera
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="colorCab" %>
<%@attribute name="colorFila" %>
<%@attribute name="titulo" %>

<!-- estilos parametrizados -->
<style type="text/css">
    #estiloCabecera{
        background-color: ${colorCab};
    }
    #estiloFilas{
        background-color: ${colorFila};
    }

    #estiloTitulo{
        font-weight: bold;
    }
</style>
    
<table>
    <tr id="estiloCabecera">
        <th id="estiloTitulo">${titulo}</th>
    </tr>
    <tr id="estiloFilas">
        <td>
            <jsp:doBody></jsp:doBody>
        </td>
    </tr>
</table>