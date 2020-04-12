<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="Model.ModelLogin"%>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%@ include file="/presentacion/head.jsp" %>
    </head>
    <body style="background-image: url(https://www.ealde.es/wp-content/uploads/2017/08/sistema-bancario.jpg); background-size: 100% 100%;background-attachment: fixed">

        <% ModelLogin model = (ModelLogin) request.getAttribute("modelLogin"); %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        <div class="modal-dialog text-center">
            <div class="col-sm-9 main-section">
                <div class="modal-content">
                    
                    <div class="col-12 user-img">
                        <img src="https://img.icons8.com/dusk/100/000000/user-group-man-man.png">
                    </div>
                    
                    <div class="col-12 form-input">
                        <form action="ControladorLogin">
                            <div class="form-group">
                                <input type="text" id="user" class="<%=erroneo("user", errores)%> form-control" 
                                       placeholder="Enter User" name="user" title="<%=title("user", errores)%>"
                                       value="<%=form.get("user")[0]%>" required>
                            </div>
                            <div class="form-group">
                                <input type="password" id="password" class="<%=erroneo("password", errores)%> form-control"
                                       placeholder="Enter Password" name="password" title="<%=title("password", errores)%>"
                                       value="<%=form.get("password")[0]%>" required>
                            </div>
                            <button type="submit" class="btn btn-success" name="accion" value="Ingresar">Ingresar</button>
                        </form>
                    </div>

                    <div class="col-12 forgot">
                        <a href="ControladorUsuario?accion=addCliente">Registrarse</a>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>

<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }
    
    private Map<String,String[]> getForm(ModelLogin model){
       Map<String,String[]> values = new HashMap<>();
       values.put("user", new String[]{/*model.getCurrent().getCedula()*/""});
       values.put("password", new String[]{/*model.getCurrent().getClave()*/""});
       return values;
    }
%>