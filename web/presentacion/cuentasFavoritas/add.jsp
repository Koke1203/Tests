<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario Favorito</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
           %>
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4">
                    <p class="h1">Registarse</p>
                    <form name="form_registro" id="form_registro" onsubmit="return validaDatos()" action="ControladorFavorito">
                        <input class="form-control" type="text" name="txtUsuarioCedula" onkeypress="return solonumeros(event)" value="<%=usuario.getCedula()%>" hidden><br>
                        <p class="h6">Numero de Cuenta</p>
                        <input class="<%=erroneo("cuenta",errores)%> form-control"  type="text" name="txtNumCuenta" id="nombre" onkeypress="return solonumeros(event)" title="<%=title("cuenta",errores)%>" required><br>
                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Agregar">
                        <a class="btn btn-outline-danger" href="ControladorFavorito?accion=listar">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }
    
    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }
%>