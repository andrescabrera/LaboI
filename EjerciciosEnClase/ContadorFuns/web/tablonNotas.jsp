<%-- 
    Document   : tablonNotas
    Created on : 07/02/2011, 03:18:53
    Author     : acabrera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mostrar" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Fichero tag</title>
        <style type="text/css" >
            body{
                width: 800px;
            }
            table{
                margin: 0 auto;
                border: 1px solid black;
            }
            tr{
                text-align: center;
            }
            td, tr{
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <h2>Notas de la asignatura Programaci&oacute;n Java:</h2>
        <table>
            <tr>
                <td>
                    <mostrar:mostrarTabla colorCab="#0000ff" colorFila="#ffc0c0"
                                          titulo="Nombre">
                        Isabel Mart&iacute;nez Pelayo<br/>
                        Luis Garc&iacute;a Severiano<br/>
                        Antonio Fern&aacute;ndez Orti<br/>
                    </mostrar:mostrarTabla>
                </td>
                <td>
                    <mostrar:mostrarTabla colorCab="#00fc00" colorFila="c0ffc0" titulo="Nota">
                        8.50<br/>
                        7<br/>
                        5.50<br/>
                    </mostrar:mostrarTabla>
                </td>
            </tr>
        </table>
    </body>
</html>
