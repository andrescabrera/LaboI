<%@page contentType="text/html"%>
<html>
<head><title>P�gina JSP cuenta</title></head>
<body>
<!--Incrementar el contador para esta p�gina. El valor es
    guardado en el objeto impl�cito application con el nombre
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
    <h1>Demostraci�n de seguimiento a nivel de aplicaci�n</h1>
    <!-- Visualizar la cuenta para esta p�gina -->
    Has visitado esta p�gina <%= cuenta %> <%= s %>
</body>
</html>
