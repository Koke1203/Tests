<%@page import="LogicaNegocio.Cuenta"%>
<%@page import="ModeloDAO.CuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposito a Usuario</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body class="lista_cuenta">
        <%@ include file="/presentacion/header.jsp" %>
        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4">
                    <%
                    CuentaDAO dao=new CuentaDAO();
                    int id=Integer.parseInt((String)request.getAttribute("idDep"));
                    Cuenta p=(Cuenta)dao.list(id);
                    %>
                    <p class="h1">Editar Usuario</p>
                    <form action="ControladorDeposito">             
                        <p class="h6">Cédula Depositante</p>
                        <input class="form-control" type="text" name="txtCedulaDepositante"><br>
                        <p class="h6">Monto a Depositar</p>
                        <input class="form-control" type="text" name="txtMontoDepos"><br>
                        <p class="h6">Motivo</p>
                        <input class="form-control" type="text" name="txtMotivo"><br>
                        <!--Cedula del Receptor del Dinero-->
                        <input class="form-control" type="hidden" name="txtCedulaReceptor" value="<%= p.getUsuario()%>"><br>
                        <!--Numero de cuenta del Receptor del dinero-->
                        <input class="form-control" type="hidden" name="txtNumCuenta" value="<%= p.getNum_cuenta()%>"><br>
                        <!--Saldo del Receptor del Dinero-->
                        <input class="form-control" type="hidden" name="txtSaldo" value="<%= p.getSaldo()%>"><br>
                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-outline-danger" href="ControladorDeposito?accion=buscar">Regresar</a>
                    </form>
                </div>
            </div>
       </div>
    </body>
</html>
