<%@page import="LogicaNegocio.Retiro"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.DepositoDAO"%>
<%@page import="ModeloDAO.RetiroDAO"%>
<%@page import="LogicaNegocio.Deposito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Depositos</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>

        <div class="encabezado">
            <h3>Movimientos</h3>
            <p class="subtitulo">En esta seccion se muestran los movimientos de las transacciones que haz realizado</p>
        </div>

        <%
            DepositoDAO dao = new DepositoDAO();
            RetiroDAO dao_retiro = new RetiroDAO();
            List<Deposito> lista = dao.listar();
            List<Retiro> lista_retiro = dao_retiro.listar();
            Iterator<Deposito> iter = lista.iterator();
            Iterator<Retiro> iter_retiro = lista_retiro.iterator();
            Deposito dep = null;
            Retiro retiro = null;
            int id = Integer.parseInt((String) request.getAttribute("id-cuenta"));
        %>

        <div class="table-wrapper-scroll-y my-custom-scrollbar contenedor_cuenta">
            <table id="datos" class="table tabla_cuenta">
                <caption class="titulo_cuenta">
                    <img class="imagen_cuenta" src="images/card.png">&nbsp; Movientes de la Cuenta
                    &nbsp; <p class="usuario"><%=id%></p>
                </caption><br>
                <input class="form-control col-3" id="searchTerm" type="text" onkeyup="doSearch()" placeholder="Filtre por fecha" />
                <thead>
                    <tr>
                        <th scope="col">Monto</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (iter.hasNext()) {
                            dep = iter.next();
                            if (dep.getCuenta_usuario() == id) {
                    %>
                    <tr>
                        <td><%=dep.getMonto()%></td>
                        <td><%=dep.getFecha()%></td>
                        <td>Deposito</td>
                    </tr>
                    <%}
                        }%>
                    <%
                        while (iter_retiro.hasNext()) {
                            retiro = iter_retiro.next();
                            if (retiro.getCuentas_NumCuentas() == id) {
                    %>
                    <tr>
                        <td><%=retiro.getMonto()%></td>
                        <td><%=retiro.getFechaRetiro()%></td>
                        <td>Retiro</td>
                    </tr>
                    <%}
                        }%>
                    </div>
            </table><br>
            <a class="btn btn-outline-danger"  href="ControladorCuenta?accion=listar">Regresar</a>
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
