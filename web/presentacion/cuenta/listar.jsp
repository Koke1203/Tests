<%@page import="Model.ModelLogin"%>
<%@page import="java.util.Iterator"%>
<%@page import="LogicaNegocio.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de cuentas</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">

        <%@ include file="/presentacion/header.jsp" %>

        <div class="encabezado">
            <h3>Resumen de cuentas</h3>
            <p class="subtitulo">En esta seccion se muestran las cuentas que pueden consultar los clientes del banco UNA</p>
        </div>

        <div class="table-wrapper-scroll-y my-custom-scrollbar contenedor_cuenta">
            <table class="table tabla_cuenta"> 

                <caption class="titulo_cuenta">
                    <img class="imagen_cuenta" src="images/card.png">&nbsp; Cuentas del cliente
                    &nbsp; <p class="usuario"><%=usuario.getNombre()%> <%=usuario.getApellido()%></p>
                </caption>

                <thead>
                    <tr>
                        <th scope="col">Numero de cuenta</th>
                        <th scope="col">Moneda</th>
                        <th scope="col">Saldo</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">...</th>
                        <th scope="col">...</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CuentaDAO dao = new CuentaDAO();
                        List<Cuenta> list = dao.listar();
                        Iterator<Cuenta> iter = list.iterator();
                        Cuenta cuenta = null;
                        while (iter.hasNext()) {
                            cuenta = iter.next();
                    %>
                    <tr>
                        <%if (cuenta.getUsuario() == usuario.getCedula()) {%>
                        <th scope="row"><%=cuenta.getNum_cuenta()%></th>
                            <%if (cuenta.getMoneda() == 0) {%>
                        <td>Colon</td>
                        <%} else if (cuenta.getMoneda() == 1) {%>
                        <td>Dolar</td>
                        <%}%>
                        <td><%=cuenta.getSaldo()%></td>
                        <td><%=cuenta.getUsuario()%></td>
                        <td>
                            <a href="ControladorCuenta?accion=editar&id=<%= cuenta.getNum_cuenta()%>">Editar</a>
                            <a href="ControladorCuenta?accion=eliminar&id=<%= cuenta.getNum_cuenta()%>">Eliminar</a>
                        </td>
                        <td>
                            <a href="ControladorDeposito?accion=listar&id=<%= cuenta.getNum_cuenta()%>">Movimientos</a>
                        </td>
                        <%}%>
                    </tr>

                    <%}%>
                    </div>
            </table>
        </div>
    </body>
</html>