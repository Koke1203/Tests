package ModeloDAO;

import Config.Conexion;
import LogicaNegocio.Deposito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepositoDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Deposito d = new Deposito();
    
    public DepositoDAO(){
        
    }
    
    public List listar() {
        ArrayList<Deposito>list=new ArrayList<>();
        String sql="select * from deposito";
        try {
            con=cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Deposito dep = new Deposito();
                dep.setMonto(rs.getDouble("monto"));
                dep.setFecha(rs.getString("fecha"));
                dep.setCedula_depositante(rs.getInt("cedula_deposit"));
                dep.setCedula_receptor(rs.getInt("cedula_recept"));
                dep.setMotivo(rs.getString("motivo"));    
                dep.setTipo_operacion(rs.getInt("tipo_operacion"));
                dep.setCuenta_usuario(rs.getInt("cuentas_numCuentas"));
                list.add(dep);
            }
        } catch (Exception e) {
        }
       System.out.println("Conectado");
        return list;
    }
    
    public Deposito list(int num_cuenta) {
        String sql="select * from deposito where cuentas_numCuentas="+num_cuenta;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                d.setMonto(rs.getDouble("monto"));
                d.setFecha(rs.getString("fecha"));
                d.setCedula_depositante(rs.getInt("cedula_deposit"));
                d.setCedula_receptor(rs.getInt("cedula_recept"));
                d.setMotivo(rs.getString("motivo"));
                d.setTipo_operacion(rs.getInt("tipo_operacion"));
                d.setCuenta_usuario(rs.getInt("cuentas_numCuentas"));
            }
        } catch (Exception e) {
        }
        return d;
    }
    
    public boolean add(Deposito dep) {
       String sql="insert into deposito(monto, fecha, cedula_deposit, cedula_recept, motivo, tipo_operacion, cuentas_numCuentas"
               + ")values("+dep.getMonto()+",'"+dep.getFecha()+"',"+dep.getCedula_depositante()+","+dep.getCedula_receptor()+",'"
               +dep.getMotivo()+"' "+ ","+dep.getTipo_operacion()+","+dep.getCuenta_usuario()+")";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
    public boolean eliminar() {
        String sql = "delete from deposito";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
