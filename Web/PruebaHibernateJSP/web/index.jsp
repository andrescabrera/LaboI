<%-- 
    Document   : index
    Created on : 20/01/2011, 02:26:07
    Author     : acabrera
--%>

<%@page import="org.hibernate.Hibernate"%>
<%@page import="entidades.Cuentas"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entidades.consultaCuentas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de Hibernate</title>
    </head>
    <body>
        <h1>Probando Hibernate</h1>
        <%
                    consultaCuentas conexion = new consultaCuentas();
                    List cuentas = conexion.getCuentas();
                    try {
                        Iterator iterador = cuentas.iterator();
                        while (iterador.hasNext()) {
                            Cuentas c = (Cuentas) iterador.next(); //el casting
        %>
        <div class="cuentasBancarias">
            <p>Numero de Cuenta: <%=c.getId()%></p>
            <p>Fecha de Apertura: <%=c.getFechaApertura()%></p>
            <p>Saldo: <%=c.getSaldo()%></p>
        </div> <!-- div cuentasBancarias -->
        <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        %>
    </body>
</html>
