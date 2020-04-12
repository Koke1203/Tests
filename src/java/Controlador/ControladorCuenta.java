package Controlador;

import LogicaNegocio.Cuenta;
import LogicaNegocio.Deposito;
import ModeloDAO.CuentaDAO;
import ModeloDAO.DepositoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorCuenta extends HttpServlet {

    String listar = "presentacion/cuenta/listar.jsp";
    String add = "presentacion/cuenta/add.jsp";
    String edit = "presentacion/cuenta/edit.jsp";
    String interes = "presentacion/cuenta/interes.jsp";
    String bienvenida_cajero = "presentacion/usuario/cajero/bienvenida.jsp";

    Cuenta c = new Cuenta();
    CuentaDAO dao = new CuentaDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCuenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCuenta at " + request.getContextPath() + "</h1>");
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
            if (request.getParameter("moneda").equals("Moneda") && request.getParameter("usuario").equals("Usuario")) {
                Map<String, String> errores = new HashMap<>();
                request.setAttribute("errores", errores);
                errores.put("moneda", "Debe de seleccionar una moneda");
                errores.put("usuario", "Debe de seleccionar un usuario");
                acceso = add;
            } else {
                String moneda = request.getParameter("moneda");
                String saldo = request.getParameter("saldo");
                String limiteDiario = request.getParameter("limiteDiario");
                String usuario_cedula = request.getParameter("usuario");

                if (moneda.equals("Colon")) {
                    c.setMoneda(0);
                } else if (moneda.equals("Dolar")) {
                    c.setMoneda(1);
                }

                c.setSaldo(Double.parseDouble(saldo));
                c.setLimite_diario(Double.parseDouble(limiteDiario));
                c.setUsuario(Integer.parseInt(usuario_cedula));

                dao.add(c);
                acceso = listar;
            }
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id-cuenta", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            id = Integer.parseInt(request.getParameter("numCuentas"));
            String moneda = request.getParameter("moneda");
            String saldo = request.getParameter("saldo");
            String limiteDiario = request.getParameter("limiteDiario");
            String usuario_cedula = request.getParameter("usuario");

            if (moneda.equals("Colon")) {
                c.setMoneda(0);
            } else if (moneda.equals("Dolar")) {
                c.setMoneda(1);
            }

            c.setSaldo(Double.parseDouble(saldo));
            c.setLimite_diario(Double.parseDouble(limiteDiario));
            c.setUsuario(Integer.parseInt(usuario_cedula));
            c.setNum_cuenta(id);

            dao.edit(c);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            c.setNum_cuenta(id);
            dao.eliminar(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("agregarInteres")) {
            acceso = interes;
        } else if (action.equalsIgnoreCase("Correr Proceso")) {
            //Fecha 
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNombre = new Date();
            String fecha = formatoFecha.format(fechaNombre);
            //end
            //Corre el proceso de incluir intereses a todas las cuentas
            //enlisto todas las cuentas
            Cuenta cuenta = null;
            double interes = 0;
            CuentaDAO dao_cuenta = new CuentaDAO();
            DepositoDAO dao_deposito = new DepositoDAO();
            List<Cuenta> lista = dao_cuenta.listar();
            Iterator<Cuenta> iter = lista.iterator();
            double saldo;
            while (iter.hasNext()) {
                Deposito dep = new Deposito();
                cuenta = iter.next();
                if (cuenta.getMoneda() == 0) {
                    interes = cuenta.getSaldo() * 0.005;
                    saldo = cuenta.getSaldo() + interes;
                    cuenta.setSaldo(saldo);
                    
                } else { // solo hay dos tipos de monedas
                    interes = cuenta.getSaldo() * 0.003;
                    saldo = cuenta.getSaldo() + interes;
                    cuenta.setSaldo(saldo);
                }
                dep.setMonto(interes);
                dep.setFecha(fecha);
                dep.setCedula_depositante(0);
                dep.setCedula_receptor(cuenta.getUsuario());
                dep.setMotivo("Intereses ganados");
                dep.setTipo_operacion(0); //0 deposito, 1 transferencia 
                dep.setCuenta_usuario(cuenta.getNum_cuenta());
                
                dao_cuenta.edit(cuenta);
                dao_deposito.add(dep);
            }
            acceso = bienvenida_cajero;
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
