<%@page import="LogicaNegocio.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");  %>

<div class="header">
    <img class="una" src="images/logo_una.png">
    <!-- Hay que poner un png que sea sobre el logout al final del header, dentro de un div, el png
        va tener a la par la palabra salir para que sea mas obvio, los dos dentro de un div para
        ponerle accion a todo el div
    -->
</div>


<!-- Esta parte de navbar es sobre el menu vertical al lado izquierdo-->
<nav>
    <div id="sidebar">
        <div class="toggle-btn">
            <span></span>
            <span></span>
            <span></span>
        </div>
        <ul class="mainmenu">
            <%if (usuario != null && usuario.getTipo() == 1) {%>
                <!--DATOS CORRESPONDIENTES AL CLIENTE-->
                <li><a class="menu" href="ControladorUsuario?accion=principalCliente">Inicio</a></li>
                <li><a class="menu" href="ControladorCuenta?accion=listar">Cuentas</a></li>
                <li><a class="menu">Cuentas Favoritas</a>
                    <ul class="submenu">
                        <li><a class="menu" href="ControladorFavorito?accion=listar">Ver cuentas</a></li>
                        <li><a class="menu" href="ControladorFavorito?accion=add">Agregar cuentas</a></li>
                    </ul>
                </li>
                <li>
                    <a class="menu" href="ControladorUsuario?accion=editar&id=<%=usuario.getCedula()%>">
                    Datos Personales (<%=usuario.getNombre()%>)</a>
                </li>
                <li><a class="menu" href="ControladorLogin?accion=salir">Salir</a></li>
            <%}%>

            <%if (usuario != null && usuario.getTipo() == 0) {%>
                <!--DATOS CORRESPONDIENTES AL CAJERO-->
                <li><a class="menu" href="ControladorUsuario?accion=principalCajero">Inicio</a></li>
                <li><a class="menu" href="ControladorCuenta?accion=add">Registrar Cuenta</a></li>
                <li><a class="menu" href="ControladorDeposito?accion=buscar">Realizar Deposito</a></li>
                <li><a class="menu" href="ControladorRetiro?accion=buscar">Realizar Retiro</a></li>
                <li><a class="menu" href="ControladorCuenta?accion=agregarInteres">Intereses</a></li>
                <li><a class="menu">Usuarios</a>
                    <ul class="submenu">
                        <li><a class="menu" href="ControladorUsuario?accion=addCliente">Agregar Cliente</a></li>
                        <li><a class="menu" href="ControladorUsuario?accion=addCajero">Agregar Cajero</a></li>
                    </ul>
                </li>
                <li><a class="menu" href="ControladorLogin?accion=salir">Salir</a></li>
            <%}%>

            <%if (usuario == null) {%>
                <li><a class="menu" href="index.jsp">Login</a></li>
            <%}%>
        </ul>
    </div>
</nav>
<!-- Termina menu -->