<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acreditación de intereses</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentacion/header.jsp" %>

        <div class="encabezado">
            <h3>Incorporacion de intereses</h3>
            <p class="subtitulo">
                En esta sección se puede correr un proceso que 
                acreditar intereses ganados a todas las cuentas
            </p>
        </div>
        <br><br>
        <div class="add-contenedor">
            <!--<h3 class="titulo-crear">Acreditar intereses</h3> <br>-->
            <form action="ControladorCuenta">
                <input type="submit" name="accion" value="Correr Proceso" class="btn-cuenta">
            </form>
        </div>

    </body>
</html>
