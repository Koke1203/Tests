
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

        <div class="container">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col-lg-4">
                    <%
                        CuentaDAO dao = new CuentaDAO();
                        int id = Integer.parseInt((String) request.getAttribute("id-retiro"));
                        Cuenta p = (Cuenta) dao.list(id);
                    %>
                    <p class="h3">Realizar Retiro</p>
                    <form action="ControladorRetiro">          
                        <p class="h6">Numero de cuenta</p>
                        <input class="form-control" type="text" value="<%=p.getNum_cuenta()%>" name="txtNumCuenta" readonly><br>

                        <p class="h6">Cedula</p>
                        <input class="form-control" type="text" value="<%=p.getUsuario()%>" name="txtCedula" readonly><br>
                        
                        <p class="h6">Moneda</p>
                        <%if(p.getMoneda()==0){%>
                        <input class="form-control" type="text" value="Colon" name="txtMoneda" readonly><br>
                        <%}else{%>
                        <input class="form-control" type="text" value="Dolar" name="txtMoneda" readonly><br> 
                        <%}%>
                        
                        <p class="h6">Monto a Retirar</p>
                        <input class="form-control" type="text" name="txtMontoRetiro"><br>

                        <input class="form-control" value="<%=p.getSaldo()%>" type="text" name="txtSaldo" hidden>
                        <input class="form-control" value="<%=p.getLimite_diario()%>" type="text" name="txtLimiteDiario" hidden>
                        <input class="form-control" value="<%=p.getUsuario()%>" type="text" name="txtUsuario" hidden>
                        
                        <input class="btn btn-outline-danger" type="submit" name="accion" value="Retirar">
                        <a class="btn btn-outline-danger" href="ControladorRetiro?accion=buscar">Regresar</a>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
