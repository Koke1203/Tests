package Controlador;

import LogicaNegocio.Cuenta;
import LogicaNegocio.Retiro;
import ModeloDAO.CuentaDAO;
import ModeloDAO.RetiroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorRetiro extends HttpServlet {

    String listar_cuentas = "presentacion/retiro/listar.jsp";
    String retiro = "presentacion/retiro/edit.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRetiro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRetiro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("buscar")) {
            acceso = listar_cuentas;
        } else if (action.equalsIgnoreCase("retiro")) {
            request.setAttribute("id-retiro", request.getParameter("id"));
            acceso = retiro;
        } else if (action.equalsIgnoreCase("Retirar")) {
            //efectua el retiro
            int numCuenta = Integer.parseInt(request.getParameter("txtNumCuenta"));
            int moneda = Integer.parseInt(request.getParameter("txtMoneda"));
            double saldo = Double.parseDouble(request.getParameter("txtSaldo"));
            double limiteDiario = Double.parseDouble(request.getParameter("txtLimiteDiario"));
            int usuario_cedula = Integer.parseInt(request.getParameter("txtUsuario"));

            double monto = Double.parseDouble(request.getParameter("txtMontoRetiro"));

            if (saldo >= monto) {
                //Variables
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                Date fechaNombre = new Date();
                String fecha = formatoFecha.format(fechaNombre);
                Cuenta cuenta = new Cuenta();
                CuentaDAO dao_cuenta = new CuentaDAO();
                RetiroDAO dao_retiro = new RetiroDAO();
                Retiro retiro1 = new Retiro();
                double saldoReal;
                //
                saldoReal = saldo - monto;

                cuenta.setNum_cuenta(numCuenta);
                cuenta.setMoneda(moneda);
                cuenta.setSaldo(saldoReal);
                cuenta.setLimite_diario(limiteDiario);
                cuenta.setUsuario(usuario_cedula);

                dao_cuenta.updateSaldo(cuenta);

                retiro1.setMonto(monto);
                retiro1.setFechaRetiro(fecha);
                retiro1.setCuentas_NumCuentas(numCuenta);
                
                dao_retiro.add(retiro1);
            }
            
            acceso = listar_cuentas;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
