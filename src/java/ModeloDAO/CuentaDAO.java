package ModeloDAO;

import Config.Conexion;
import LogicaNegocio.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cuenta c = new Cuenta();

    public List listar() {
        ArrayList<Cuenta> list = new ArrayList<>();
        String sql = "select * from cuentas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setNum_cuenta(rs.getInt("numCuentas"));
                cuenta.setMoneda(rs.getInt("moneda"));
                cuenta.setSaldo(rs.getDouble("saldo"));
                cuenta.setLimite_diario(rs.getDouble("limiteDiario"));
                cuenta.setUsuario(rs.getInt("usuario_cedula"));
                list.add(cuenta);
            }
        } catch (Exception e) {
        }
        System.out.println("Conectado");
        return list;
    }
    
    public Cuenta list(int num_cuenta) {
        String sql = "select * from cuentas where numCuentas=" + num_cuenta;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNum_cuenta(rs.getInt("numCuentas"));
                c.setMoneda(rs.getInt("moneda"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setLimite_diario(rs.getDouble("limiteDiario"));
                c.setUsuario(rs.getInt("usuario_cedula"));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    public Cuenta listF(int cedula) {
        String sql = "select * from cuentas where usuario_cedula=" + cedula;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNum_cuenta(rs.getInt("numCuentas"));
                c.setMoneda(rs.getInt("moneda"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setLimite_diario(rs.getDouble("limiteDiario"));
                c.setUsuario(rs.getInt("usuario_cedula"));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    public boolean listSearch(int num_cuenta) {
        String sql = "select * from cuentas where numCuentas=" + num_cuenta;
        boolean encuentra = true;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNum_cuenta(rs.getInt("numCuentas"));
            }
        } catch (Exception e) {
        }
        
        if(c.getNum_cuenta()==0){
           encuentra = false;
        }
        
        return encuentra;
    }

    public boolean add(Cuenta cuenta) {
        String sql = "insert into cuentas(moneda, saldo, limiteDiario, usuario_cedula)values(" + cuenta.getMoneda() + ","
                + cuenta.getSaldo() + "," + cuenta.getLimite_diario() + "," + cuenta.getUsuario() + ")";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean edit(Cuenta cuenta) {
        String sql = "update cuentas set moneda=" + cuenta.getMoneda() + ",saldo="
                + cuenta.getSaldo() + ",limiteDiario=" + cuenta.getLimite_diario() + ",usuario_cedula="
                + cuenta.getUsuario()+ " where numCuentas=" + cuenta.getNum_cuenta();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se ejecuto la consulta");
        }
        return false;
    }
    
    public boolean updateSaldo(Cuenta cuenta) {
        String sql = "update cuentas set saldo=" + cuenta.getSaldo() + " where numCuentas=" + cuenta.getNum_cuenta();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se ejecuto la consulta");
        }
        return false;
    }

    public boolean eliminar(int num_cuenta) {
        String sql = "delete from cuentas where numCuentas=" + num_cuenta;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
