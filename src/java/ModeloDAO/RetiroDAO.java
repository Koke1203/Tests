
package ModeloDAO;

import Config.Conexion;
import LogicaNegocio.Deposito;
import LogicaNegocio.Retiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RetiroDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Retiro p = new Retiro();
    
    public List listar() {
        ArrayList<Retiro>list=new ArrayList<>();
        String sql="select * from retiro";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Retiro per=new Retiro();
                per.setMonto(rs.getDouble("monto"));
                per.setCuentas_NumCuentas(rs.getInt("cuentas_numCuentas"));
                per.setFechaRetiro(rs.getString("fecha"));        
                list.add(per);
            }
        } catch (Exception e) {
        }
       System.out.println("Conectado");
        return list;
    }
    
    public boolean add(Retiro ret) {
       String sql="insert into retiro(monto, fecha, cuentas_numCuentas)values("+ret.getMonto()+
               ",'"+ret.getFechaRetiro()+"',"+ret.getCuentas_NumCuentas()+")";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
}
