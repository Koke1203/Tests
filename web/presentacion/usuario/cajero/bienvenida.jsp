<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenida Cajero</title>
        <%@ include file="/presentacion/head.jsp" %>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
    </head>
    <body class="lista_cuenta">
        
        <%@ include file="/presentacion/header.jsp" %>
        
        <div class="encabezado">
            <h3>Bienvenido <%=usuario.getNombre()%> <%=usuario.getApellido()%> (cajero)</h3>
            <p class="subtitulo">El sistema del Banco de la Universidad Nacional de Costa Rica le da la bienvenida
            <br>A continuacion se muestran todas las posibles acciones que puedes hacer:
            <br><br>-Realizar Depositos
            <br><br>-Registrar un Usuario
            <br><br>-Registrar un Cajero
            </p>
        </div>
        
    </body>
</html>
