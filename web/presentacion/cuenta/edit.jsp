<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="LogicaNegocio.Cuenta"%>
<%@page import="ModeloDAO.CuentaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="LogicaNegocio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cuenta</title>
        <link href="http://localhost:8080/SistemaBanco/css/style_cuenta.css" rel="stylesheet">
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentacion/header.jsp" %>

        <%
            CuentaDAO dao = new CuentaDAO();
            int id = Integer.parseInt((String) request.getAttribute("id-cuenta"));
            Cuenta c = (Cuenta) dao.list(id);
        %>

        <div class="encabezado">
            <h3>Edición de cuentas</h3>
            <p class="subtitulo">En esta sección se puede editar las cuentas de los clientes del banco UNA</p>
        </div>
        
        <br><br>

        <div class="add-contenedor">

            <h3 class="titulo-crear">Editar cuenta</h3> <br>
            <form action="ControladorCuenta">

                <select name="usuario" class="form-input selectores" >
                    <option>Usuario</option>
                    <%
                        UsuarioDAO dao_user = new UsuarioDAO();
                        List<Usuario> list = dao_user.listar();
                        Iterator<Usuario> iter = list.iterator();
                        Usuario per = null;
                        while (iter.hasNext()) {
                            per = iter.next();
                            if (per.getTipo() == 1) {
                    %>
                    <option> <%= per.getCedula()%> </option>
                    <%}
                        }%>
                </select>
                &nbsp; &nbsp; &nbsp;
                <select name="moneda" placeholder="Moneda" class="form-input selectores">
                    <option>Moneda</option>
                    <option>Colon</option>
                    <option>Dolar</option>
                    <option>Euro</option>
                </select>

                <br><br>
                <input type="text" name="saldo" value="<%=c.getSaldo()%>" placeholder="Saldo" class="form-input" required>
                &nbsp; &nbsp; &nbsp; 
                <input type="text" value="<%=c.getLimite_diario()%>" name="limiteDiario" placeholder="Limite Diario" class="form-input" required>
                <input type="hidden" name="numCuentas" value="<%= c.getNum_cuenta()%>">
                
                <br><br>
                <input type="submit" name="accion" value="Actualizar" class="btn-cuenta"><br>
                <a href="ControladorCuenta?accion=listar" >Regresar</a>
                <br>
                
            </form>
        </div>

    </body>
</html>
