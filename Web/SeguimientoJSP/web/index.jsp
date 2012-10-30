<%@page contentType="text/html"%>
<html>
<head><title>Página JSP cuenta</title></head>
<body>
<!--Incrementar el contador para esta página. El valor es
    guardado en el objeto implícito application con el nombre
    "atrCuenta".
-->
  <%
    Integer cuenta = (Integer)application.getAttribute("atrCuenta");
    String s = " vez.";
    if (cuenta == null)
      cuenta = new Integer(1);
    else
    {
      cuenta = new Integer(cuenta.intValue() + 1);
      s = " veces.";
    }
    application.setAttribute("atrCuenta", cuenta);
  %>
    <h1>Demostración de seguimiento a nivel de aplicación</h1>
    <!-- Visualizar la cuenta para esta página -->
    Has visitado esta página <%= cuenta %> <%= s %>
</body>
</html>
