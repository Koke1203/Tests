<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="LogicaNegocio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar cuenta</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body>

        <%@ include file="/presentacion/header.jsp" %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>

        <div class="encabezado">
            <h3>Formulario de Registro de Cuentas</h3>
            <p class="subtitulo">En esta sección se muestra un formulario para la solicitud de cuentas de los clientes
                del banco UNA</p>
        </div>
        
        <br><br>

        <div class="add-contenedor">
            <h3 class="titulo-crear">Crear cuenta</h3> <br>
            <form name="form_registro" id="form_registro" action="ControladorCuenta">

                <select name="usuario" class="<%=erroneo("usuario", errores)%> form-input selectores"
                        title="<%=title("usuario",errores)%>">
                    <option>Usuario</option>
                    <%
                        UsuarioDAO dao = new UsuarioDAO();
                        List<Usuario> list = dao.listar();
                        Iterator<Usuario> iter = list.iterator();
                        Usuario per = null;
                        while (iter.hasNext()) {
                            per = iter.next();
                            if (per.getTipo() == 1) { %>
                                <option> <%= per.getCedula()%> </option>
                            <%}
                        }
                    %>
                </select>
                &nbsp; &nbsp; &nbsp;
                <select name="moneda" placeholder="Moneda" class="<%=erroneo("moneda", errores)%> form-input selectores"
                        title="<%=title("moneda",errores)%>">
                    <option>Moneda</option>
                    <option>Colon</option>
                    <option>Dolar</option>
                </select>

                <br><br>
                <input type="text" name="saldo" placeholder="Saldo" class="form-input" required>
                &nbsp; &nbsp; &nbsp; 
                <input type="text" name="limiteDiario" placeholder="Limite Diario" class="form-input" required>

                <br><br>
                <input type="submit" name="accion" value="Agregar" class="btn btn-outline-danger">
                <a class="btn btn-outline-danger" href="ControladorUsuario?accion=addCliente">Agregar Cliente</a>
                <br>

            </form>
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
