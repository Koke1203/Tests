<%@page import="LogicaNegocio.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Informacion de Usuario</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4">
                    <%
                    UsuarioDAO dao=new UsuarioDAO();
                    int id=Integer.parseInt((String)request.getAttribute("idper"));
                    Usuario p=(Usuario)dao.list(id);
                    %>
                    <p class="h1">Editar Usuario</p>
                    <form action="ControladorUsuario">
                        <p class="h6">Nombre</p>
                        <input class="form-control" type="text" name="txtNombre" value="<%= p.getNombre()%>"><br>
                        <p class="h6">Apellido</p>
                        <input class="form-control" type="text" name="txtApellido" value="<%= p.getApellido()%>"><br>
                        <p class="h6">Clave</p>
                        <input class="form-control" type="text" name="txtClave" value="<%= p.getClave()%>"><br>
                        <p class="h6">Teléfono</p>
                        <input class="form-control" type="text" name="txtTelefono" value="<%= p.getTelefono()%>"><br>
                        <p class="h6">Tipo Usuario</p>
                        <input class="form-control" type="text" name="txtTipo" value="<%= p.getTipo()%>"><br>
                        <input type="hidden" name="txtCedula" value="<%= p.getCedula()%>">
                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-outline-danger" href="ControladorUsuario?accion=listar">Regresar</a>
                    </form>
                </div>
            </div>
       </div>
    </body>
</html>
