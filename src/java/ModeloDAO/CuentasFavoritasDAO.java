package ModeloDAO;

import Config.Conexion;
import LogicaNegocio.CuentasFavoritas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentasFavoritasDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    CuentasFavoritas p = new CuentasFavoritas();
    
    public List listar() {
        ArrayList<CuentasFavoritas>list=new ArrayList<>();
        String sql="select * from cuentasFavoritas";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                CuentasFavoritas per=new CuentasFavoritas();
                per.setUsuario_Cedula(rs.getInt("Usuario_cedula"));
                per.setCuentas_NumCuentas(rs.getInt("Cuentas_numCuentas"));         
                list.add(per);
            }
        } catch (Exception e) {
        }
        System.out.println("Conectado");
        return list;
    }
    
    //Hacer un listar que busque por medio de la cedula
    
    public boolean listSearch(int num_cuenta) {
        String sql = "select * from cuentasfavoritas where Cuentas_numCuentas=" + num_cuenta;
        boolean encuentra = true;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setCuentas_NumCuentas(rs.getInt("numCuentas"));
            }
        } catch (Exception e) {
        }
        
        if(p.getCuentas_NumCuentas()==0){
           encuentra = false;
        }
        
        return encuentra;
    }
    
    public boolean add(CuentasFavoritas per) {
       String sql="insert into cuentasFavoritas(Usuario_cedula, Cuentas_numCuentas)values("+per.getUsuario_Cedula()+
               ","+per.getCuentas_NumCuentas()+")";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
    public boolean eliminar(int cuenta) {
        String sql="delete from cuentasfavoritas where Cuentas_numCuentas="+cuenta;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
