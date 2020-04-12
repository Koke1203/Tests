<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenida Cliente</title>
        <%@ include file="/presentacion/head.jsp" %>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        
        <div class="encabezado">
            <h3>Bienvenido <%=usuario.getNombre()%> <%=usuario.getApellido()%> (cliente)</h3>
            <p class="subtitulo">El sistema del Banco de la Universidad Nacional de Costa Rica le da la bienvenida
            <br>A continuacion se muestran todas las posibles acciones que puedes hacer: 
            <br><br>-Realizar Transferencias
            <br><br>-Registrar Cuentas Favoritas para dichas transferencias
            <br><br>-Revisar Movimientos
            <br><br>-Se le muestran las cuentas que tienes registradas en nuestro sistema
            </p>
        </div>
        
    </body>
</html>
