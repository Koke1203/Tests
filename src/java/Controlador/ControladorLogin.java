package Controlador;

import Model.ModelLogin;
import LogicaNegocio.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorLogin extends HttpServlet {

    String listar = "presentacion/usuario/listar.jsp";
    String error = "presentacion/error.jsp";
    String login = "index.jsp";
    String bienvenida_cliente = "presentacion/usuario/cliente/bienvenida.jsp";
    String bienvenida_cajero = "presentacion/usuario/cajero/bienvenida.jsp";

    UsuarioDAO dao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //inicio el model de sesion del usuario
        request.setAttribute("modelLogin", new ModelLogin());
        //----
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("Ingresar")) {
            HttpSession session = request.getSession(true);

            List<Usuario> list = dao.listar();
            Iterator<Usuario> iter = list.iterator();
            Usuario per = null;

            boolean es_falso = true;
            //
            while (iter.hasNext()) {
                per = iter.next();
                if (request.getParameter("user").equals(per.getCedula() + "") && request.getParameter("password").equals(per.getClave())) {
                    if (per.getTipo() == 0) {
                        acceso = bienvenida_cajero;
                    } else if (per.getTipo() == 1) {
                        acceso = bienvenida_cliente;
                    }
                    updateModel(request);
                    es_falso = true;
                    session.setAttribute("usuario", per);
                    break;
                } else {
                    es_falso = false;
                }
            }

            if (es_falso == false) {
                //Por medio de Maps, setear errores a la vista 
                Map<String, String> errores = new HashMap<>();
                request.setAttribute("errores", errores);
                errores.put("user", "Usuario o clave incorrectos");
                errores.put("password", "Usuario o clave incorrectos");
                acceso = "index.jsp";
            }
        } else if (action.equalsIgnoreCase("salir")) {
            HttpSession session = request.getSession(true);
            session.removeAttribute("usuario");
            session.invalidate();
            acceso = login;
        } else if (action.equalsIgnoreCase("login")) {
            ModelLogin model = (ModelLogin) request.getAttribute("modelLogin");
            model.getCurrent().setCedula("");
            model.getCurrent().setClave("");
            acceso = login;
        }
        
        //Para devolver la vista 
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    void updateModel(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("modelLogin");
        model.getCurrent().setCedula(request.getParameter("user"));
        model.getCurrent().setClave(request.getParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
