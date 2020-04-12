<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="LogicaNegocio.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
        <%@ include file="/presentacion/head.jsp" %>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-">
                    <h1 class="titulo-usuario">Usuarios</h1>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Cédula</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Clave</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <%
                            UsuarioDAO dao = new UsuarioDAO();
                            List<Usuario> list = dao.listar();
                            Iterator<Usuario> iter = list.iterator();
                            Usuario per = null;
                            while (iter.hasNext()) {
                                per = iter.next();

                        %>
                        <tbody>
                            <tr>
                                <td><%= per.getCedula()%></td>
                                <td><%= per.getNombre()%></td>
                                <td><%= per.getApellido()%></td>
                                <td><%= per.getTelefono()%></td>
                                <td><%= per.getClave()%></td>
                                <td>
                                    <a href="ControladorUsuario?accion=editar&id=<%= per.getCedula()%>">
                                    <img src="https://img.icons8.com/dusk/50/000000/edit-link.png">
                                    </a>
                                    &nbsp;&nbsp;&nbsp;
                                    <a href="ControladorUsuario?accion=eliminar&id=<%= per.getCedula()%>">
                                    <img src="https://img.icons8.com/dusk/50/000000/remove-user-male.png">
                                    </a>
                                </td>
                            </tr>
                             <%}%>
                        </tbody>
                    </table>
                        <a class="btn btn-outline-danger"  href="ControladorUsuario?accion=add">Agregar Nuevo</a>
                </div>
            </div>
        </div>
    </body>
</html>
