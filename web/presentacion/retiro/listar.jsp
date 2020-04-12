<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="LogicaNegocio.Cuenta"%>
<%@page import="ModeloDAO.CuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retiro</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>

        <div class="encabezado">
            <h3>Retiro</h3>
            <p class="subtitulo">En esta seccion se hacen retiros de una cuenta ya sea por medio del numero de cuenta
                o cedula del dueno de la cuenta 
            </p>
        </div>
        <br><br><br><br>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-">
                    <h3 class="titulo-usuario">Usuarios</h3>
                    <input class="form-control" placeholder="Cedula / Numero de cuenta" 
                           id="searchTerm" type="text" onkeyup="doSearch()" />
                    <table id="datos" class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Numero de Cuenta</th>
                                <th scope="col">Moneda de Cuenta</th>
                                <th scope="col">Cedula Usuario</th>
                            </tr>
                        </thead>
                        <%
                            CuentaDAO dao = new CuentaDAO();
                            List<Cuenta> list = dao.listar();
                            Iterator<Cuenta> iter = list.iterator();
                            Cuenta per = null;
                            while (iter.hasNext()) {
                                per = iter.next();
                        %>
                        <tbody>
                            <tr>
                                <td><%= per.getNum_cuenta()%></td>
                                <td><%= per.getMoneda()%></td>
                                <td><%= per.getUsuario()%></td>
                                <td>
                                    <a href="ControladorRetiro?accion=retiro&id=<%= per.getNum_cuenta()%>">
                                        <img src="https://img.icons8.com/ultraviolet/40/000000/purchase-order.png"/>
                                    </a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            function doSearch() {
                var tableReg = document.getElementById('datos');
                var searchText = document.getElementById('searchTerm').value.toLowerCase();
                var cellsOfRow = "";
                var found = false;
                var compareWith = "";

                // Recorremos todas las filas con contenido de la tabla
                for (var i = 1; i < tableReg.rows.length; i++)
                {
                    cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
                    found = false;
                    // Recorremos todas las celdas
                    for (var j = 0; j < cellsOfRow.length && !found; j++)
                    {
                        compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                        // Buscamos el texto en el contenido de la celda
                        if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
                        {
                            found = true;
                        }
                    }
                    if (found)
                    {
                        tableReg.rows[i].style.display = '';
                    } else {
                        // si no ha encontrado ninguna coincidencia, esconde la
                        // fila de la tabla
                        tableReg.rows[i].style.display = 'none';
                    }
                }
            }
        </script>

    </body>
</html>
