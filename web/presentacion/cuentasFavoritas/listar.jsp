<%@page import="java.util.Iterator"%>
<%@page import="LogicaNegocio.CuentasFavoritas"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CuentasFavoritasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cuentas Favoritas</title>
        <%@ include file="/presentacion/head.jsp" %>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %><br>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-">
                    <h2>Cuentas Favoritas</h2><br>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Cédula Usuario</th>
                                <th scope="col">Cuenta Usuario</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <%
                            CuentasFavoritasDAO dao = new CuentasFavoritasDAO();
                            List<CuentasFavoritas> list = dao.listar();
                            Iterator<CuentasFavoritas> iter = list.iterator();
                            CuentasFavoritas fav = null;
                            while (iter.hasNext()) {
                                fav = iter.next();
                                if(fav.getUsuario_Cedula() == usuario.getCedula()){
                        %>
                        <tbody>
                            <tr>
                                <td><%= fav.getUsuario_Cedula()%></td>
                                <td><%= fav.getCuentas_NumCuentas()%></td>
                                <td>
                                    <a href="ControladorFavorito?accion=eliminar&id=<%=fav.getCuentas_NumCuentas()%>">eliminar</a>
                                    <a href="ControladorFavorito?accion=transferencia&id=<%=fav.getCuentas_NumCuentas()%>">Tranferir</a>
                                </td>
                            </tr>
                            <%}}%>
                        </tbody>
                    </table>
                    <a class="btn btn-outline-danger"  href="ControladorFavorito?accion=add">Agregar Nuevo</a>
                </div>
            </div>
        </div>
    </body>
</html>
