package Controlador;

import LogicaNegocio.Cuenta;
import LogicaNegocio.CuentasFavoritas;
import LogicaNegocio.Deposito;
import ModeloDAO.CuentaDAO;
import ModeloDAO.CuentasFavoritasDAO;
import ModeloDAO.DepositoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorFavorito extends HttpServlet {

    String listar = "presentacion/cuentasFavoritas/listar.jsp";
    String add = "presentacion/cuentasFavoritas/add.jsp";
    String trans = "presentacion/cuentasFavoritas/transferencia.jsp";
    CuentasFavoritas p = new CuentasFavoritas();
    CuentasFavoritasDAO dao = new CuentasFavoritasDAO();
    int id;
    Deposito d = new Deposito();
    DepositoDAO daoD = new DepositoDAO();
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
            out.println("<title>Servlet ControladorFavorito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFavorito at " + request.getContextPath() + "</h1>");
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
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String numCuenta = request.getParameter("txtNumCuenta");
            String usuarioCedula = request.getParameter("txtUsuarioCedula");
            
            CuentaDAO dao_cuenta = new CuentaDAO();
            
            System.out.println("Valor del metodo: "+dao_cuenta.listSearch(Integer.parseInt(numCuenta)));
            
            if (dao_cuenta.listSearch(Integer.parseInt(numCuenta)) == false || 
                    dao.listSearch(Integer.parseInt(numCuenta)) == true) {
                Map<String, String> errores = new HashMap<>();
                request.setAttribute("errores", errores);
                errores.put("cuenta", "Cuenta ingresada no existente o ya registrada como favorita");
                acceso = add;
            } else {
                p.setCuentas_NumCuentas(Integer.parseInt(numCuenta));
                p.setUsuario_Cedula(Integer.parseInt(usuarioCedula));
                dao.add(p);
                acceso = listar;
            }
            
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setCuentas_NumCuentas(id);
            dao.eliminar(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("transferencia")) {
            request.setAttribute("idFav", request.getParameter("id"));
            acceso = trans;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            //Fecha 
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNombre = new Date();
            String fecha = formatoFecha.format(fechaNombre);
            //Datos del depositante
            int idDeposit = Integer.parseInt(request.getParameter("txtCedulaDepositante"));
            int cuentaDeposit = Integer.parseInt(request.getParameter("txtCuentaDepositante"));
            double limiteDeposit = Double.parseDouble(request.getParameter("txtLimiteDepositante"));
            double saldoDeposit = Double.parseDouble(request.getParameter("txtSaldoDepositante"));
            int monedaDeposit = Integer.parseInt(request.getParameter("txtMonedaDepositante"));
            // Valores a digitar
            double monto = Double.parseDouble(request.getParameter("txtMontoDepos"));
            double montoDep;
            String motivo = request.getParameter("txtMotivo");
            // Datos del Receptor
            String tipo_operacion = "3";
            int idRecep = Integer.parseInt(request.getParameter("txtCedulaReceptor"));
            int cuentaRecep = Integer.parseInt(request.getParameter("txtNumCuentaReceptor"));
            double saldoRecep = Double.parseDouble(request.getParameter("txtSaldoReceptor"));
            int monedaRecep = Integer.parseInt(request.getParameter("txtMonedaReceptor"));
            //Validacion del limite
            if (limiteDeposit > monto) {
                acceso = listar;
            } // Validaciones del tipo de moneda
            // 0 = colones y 1 = dolares
            else if (monedaDeposit == 0 && monedaRecep == 1) {
                montoDep = monto / 564;
            } else if (monedaDeposit == 1 && monedaRecep == 0) {
                montoDep = monto * 564;
            }
            //Deposito Historial
            d.setMonto(monto);
            d.setFecha(fecha);
            d.setCedula_depositante(idDeposit);
            d.setCedula_receptor(idRecep);
            d.setMotivo(motivo);
            d.setTipo_operacion(Integer.parseInt(tipo_operacion));
            d.setCuenta_usuario(cuentaDeposit);
            daoD.add(d);
            //Cambio de saldo en la cuenta
         /*   c.setNum_cuenta(numCuenta);
             c.setSaldo(Double.parseDouble(saldo)+Double.parseDouble(monto));
             cdao.updateSaldo(c);
            
             acceso = buscar;
             */
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
