package Controlador;

import LogicaNegocio.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorUsuario extends HttpServlet {

    String listar = "presentacion/usuario/listar.jsp";
    String addCliente = "presentacion/usuario/cliente/add.jsp";
    String addCajero = "presentacion/usuario/cajero/add.jsp";
    String edit = "presentacion/usuario/edit.jsp";
    String principalCliente = "presentacion/usuario/cliente/bienvenida.jsp";
    String principalCajero = "presentacion/usuario/cajero/bienvenida.jsp";
    Usuario p = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("addCliente")) {
            acceso = addCliente;
        } else if (action.equalsIgnoreCase("addCajero")) {
            acceso = addCajero;
        } else if (action.equalsIgnoreCase("principalCliente")) {
            acceso = principalCliente;
        } else if (action.equalsIgnoreCase("principalCajero")) {
            acceso = principalCajero;
        } else if (action.equalsIgnoreCase("Agregar0")) {
            String cedula = request.getParameter("txtCedula");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String clave = request.getParameter("txtClave");
            String telefono = request.getParameter("txtTelefono");
            String tipo = "0";
            p.setCedula(Integer.parseInt(cedula));
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setClave(clave);
            p.setTelefono(Integer.parseInt(telefono));
            p.setTipo(Integer.parseInt(tipo));
            dao.add(p);
            acceso = principalCajero;
        } else if (action.equalsIgnoreCase("Agregar1")) {
            String cedula = request.getParameter("txtCedula");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String clave = request.getParameter("txtClave");
            String telefono = request.getParameter("txtTelefono");
            String tipo = "1";
            p.setCedula(Integer.parseInt(cedula));
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setClave(clave);
            p.setTelefono(Integer.parseInt(telefono));
            p.setTipo(Integer.parseInt(tipo));
            dao.add(p);
            acceso = principalCliente;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtCedula"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String clave = request.getParameter("txtClave");
            String telefono = (request.getParameter("txtTelefono"));
            String tipo = (request.getParameter("txtTipo"));

            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setClave(clave);
            p.setTelefono(Integer.parseInt(telefono));
            p.setTipo(Integer.parseInt(tipo));
            p.setCedula(id);

            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setCedula(id);
            dao.eliminar(id);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
