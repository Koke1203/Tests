<%@page import="LogicaNegocio.Cuenta"%>
<%@page import="ModeloDAO.CuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferencia de Usuario a Usuario</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4">
                    <%
                        CuentaDAO dao = new CuentaDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idFav"));
                        Cuenta p = (Cuenta) dao.list(id);

                        CuentaDAO dao2 = new CuentaDAO();
                        int usu = usuario.getCedula();
                        Cuenta f = (Cuenta) dao2.listF(usu);

                    %>
                    <p class="h1">Editar Usuario</p>
                    <form action="ControladorFavorito">             
                        <p class="h6">Cédula Depositante</p>
                        <input class="form-control" type="text" name="txtCedulaDepositante" value="<%= f.getUsuario()%>"><br>
                        <p class="h6">Cuenta Depositante</p>
                        <input class="form-control" type="text" name="txtCuentaDepositante" value="<%= f.getNum_cuenta()%>"><br>
                        <p class="h6">Limite Depositante</p>
                        <input class="form-control" type="text" name="txtLimiteDepositante" value="<%= f.getLimite_diario()%>"><br>
                        <p class="h6">Saldo Depositante</p>
                        <input class="form-control" type="text" name="txtSaldoDepositante" value="<%= f.getSaldo()%>"><br>
                        <p class="h6">Moneda Depositante</p>
                        <input class="form-control" type="text" name="txtMonedaDepositante" value="<%= f.getMoneda()%>"><br>
                        <p class="h6">Monto a Depositar</p>
                        <input class="form-control" type="text" name="txtMontoDepos"><br>
                        <p class="h6">Motivo</p>
                        <input class="form-control" type="text" name="txtMotivo"><br>

                        <input class="form-control" type="text" name="txtCedulaReceptor" value="<%= p.getUsuario()%>"><br>

                        <input class="form-control" type="text" name="txtNumCuentaReceptor" value="<%= p.getNum_cuenta()%>"><br>

                        <input class="form-control" type="text" name="txtSaldoReceptor" value="<%= p.getSaldo()%>"><br>

                        <input class="form-control" type="text" name="txtMonedaReceptor" value="<%= p.getMoneda()%>"><br>

                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-outline-danger" href="ControladorFavorito?accion=listar">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
