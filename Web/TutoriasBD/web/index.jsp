<?xml version="1.0" encoding="UTF-8"?>
<%--
    Document   : index
    Created on : 17/01/2011, 02:57:17
    Author     : acabrera
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
    <head>
        <title>Concertar una Tutoria</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
        <style type="text/css">
            form {
                width: 350px;
                margin: auto;
            }
            legend {
                font-weight: bold;
            }
            #alumno, #profesor {
                width: 300px;
            }
            #seleccionTurno {
                margin: 1em 0;
                padding: 1em;
                border: 1px solid #ccc;
                background: #f8f8f8;
            }
            #seleccionHora, #seleccionHora legend {
                font-weight: normal;
                border: solid 0 transparent;
            }
            textarea {
                width: 300px;
                height: 100px;
            }
            input.radio {
                float: left;
                margin-right: 1em;
            }
            input:focus, textarea:focus {
                background: #ffc;
            }
            .vertical {
                display: block;
            }
            #datosTutoria label {
                display: block;
            }
            #seleccionTurno label {
                width: 10em;
            }
        </style>
    </head>
    <body>
        <div id="formulario">
            <form action="SvTutorias" method="post">
                <fieldset>
                    <legend>Concertar una Tutoria</legend>
                    <div id="datosTutoria">
                        <p>
                            <label for="alumno">Alumno:</label>
                            <input id="alumno" type="text" name="alumno" />
                            <!-- o de otra forma
                            <label>Alumno
                                <input name="alumno" type="text"/>
                            </label>
                            -->
                        </p>
                        <p>
                            <label for="profesor">Con el profesor:</label>
                            <select id="profesor" name="profesor">
                                <option>Fco. Javier ceballos Sierra</option>
                                <option>Inmaculada Rodriguez Santiago</option>
                                <option>Concha batanero Ochaita</option>
                                <option>M. Dolores Rodr&iacute;guez Moreno</option>
                                <option>Mart&iacute;n Knobaluch revuelta</option>
                            </select>
                        </p>
                    </div>
                    <fieldset id="seleccionTurno">
                        <legend>Seleccione su turno</legend>
                        <div>
                            <p>
                                <label class="vertical" for="dia">D&iacute;a</label>
                                <select id="dia" name="dia">
                                    <option>Lunes</option>
                                    <option>Martes</option>
                                    <option>Miercoles</option>
                                    <option>Jueves</option>
                                    <option>Viernes</option>
                                </select>
                            </p>
                        </div>
                        <div>
                            <fieldset id="seleccionHora">
                                <legend>Hora:</legend>
                                <p>
                                    <label for="diez">10</label>
                                    <input id="diez" class="radio" type="radio" name="hora" value="10" checked="checked" />
                                </p>
                                <p>
                                    <label for="doce">12</label>
                                    <input id="doce" class="radio" type="radio" name="hora" value="12" />
                                </p>
                                <p>
                                    <label for="catorce">14</label>
                                    <input id="catorce" class="radio" type="radio" name="hora" value="14" />
                                </p>
                                <p>
                                    <label for="dieciocho">18</label>
                                    <input id="dieciocho" class="radio" type="radio" name="hora" value="18" />
                                </p>
                            </fieldset>
                        </div>
                    </fieldset>
                    <p>
                        <label class="vertical" for="asunto">Asunto:</label>
                        <textarea id="asunto" name="asunto" rows="5" cols="40"></textarea>
                    </p>
                    <input type="submit" value="Enviar datos"/>
                    <input type="reset" value="Borrar formulario"/>
                </fieldset>
            </form>
        </div>
    </body>
</html>
