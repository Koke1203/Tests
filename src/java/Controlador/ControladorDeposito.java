package Controlador;

import LogicaNegocio.Cuenta;
import LogicaNegocio.Deposito;
import ModeloDAO.CuentaDAO;
import ModeloDAO.DepositoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorDeposito extends HttpServlet {

    String listarMovimiento = "presentacion/deposito/cliente/listar.jsp";
    String buscar = "presentacion/deposito/cajero/search.jsp";
    String deposito = "presentacion/deposito/cajero/deposito.jsp";

    Deposito d = new Deposito();
    DepositoDAO dao = new DepositoDAO();
    Cuenta c = new Cuenta();
    CuentaDAO cdao = new CuentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeposito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDeposito at " + request.getContextPath() + "</h1>");
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
            request.setAttribute("id-cuenta", request.getParameter("id"));
            acceso = listarMovimiento;
        } else if (action.equalsIgnoreCase("buscar")) {
            acceso = buscar;
        } else if (action.equalsIgnoreCase("deposito")) {
            request.setAttribute("idDep", request.getParameter("id"));
            acceso = deposito;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            String monto = request.getParameter("txtMontoDepos");
            //Fecha 
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNombre = new Date();
            String fecha = formatoFecha.format(fechaNombre);
            //end
            int idRecept = Integer.parseInt(request.getParameter("txtCedulaReceptor"));
            int idDeposit = Integer.parseInt(request.getParameter("txtCedulaDepositante"));
            String motivo = request.getParameter("txtMotivo");
            String tipo_operacion = "0";
            int numCuenta = Integer.parseInt(request.getParameter("txtNumCuenta"));
            String saldo = request.getParameter("txtSaldo");

            d.setMonto(Double.parseDouble(monto));
            d.setFecha(fecha);
            d.setCedula_depositante(idDeposit);
            d.setCedula_receptor(idRecept);
            d.setMotivo(motivo);
            d.setTipo_operacion(Integer.parseInt(tipo_operacion));
            d.setCuenta_usuario(numCuenta);
            dao.add(d);

            c.setNum_cuenta(numCuenta);
            c.setSaldo(Double.parseDouble(saldo) + Double.parseDouble(monto));
            cdao.updateSaldo(c);
            acceso = buscar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
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
