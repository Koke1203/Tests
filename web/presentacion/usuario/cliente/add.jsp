<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4"><br>
                    <p class="h2">Registro Cliente</p>
                    <form name="form_registro" id="form_registro" onsubmit="return validaDatos()" action="ControladorUsuario">
                        <p class="h6">Cédula</p>
                        <input class="form-control" type="text" name="txtCedula" onkeypress="return solonumeros(event)" ><br>
                        <p class="h6">Nombre</p>
                        <input class="form-control" type="text" name="txtNombre" id="nombre" onkeypress="return sololetras(event)"><br>
                        <p class="h6">Apellido</p>
                        <input class="form-control" type="text" name="txtApellido" onkeypress="return sololetras(event)"><br>
                        <p class="h6">Password</p>
                        <input class="form-control" type="text" name="txtClave" ><br>
                        <p class="h6">Teléfono</p>
                        <input class="form-control" type="text" name="txtTelefono" onkeypress="return solonumeros(event)"><br>
                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Agregar1">&nbsp;
                        
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
