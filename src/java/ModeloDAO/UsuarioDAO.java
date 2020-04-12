package ModeloDAO;

import Config.Conexion;
import LogicaNegocio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario p = new Usuario();
    
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from usuario";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario per=new Usuario();
                per.setCedula(rs.getInt("cedula"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setTelefono(rs.getInt("telefono"));
                per.setClave(rs.getString("clave"));    
                per.setTipo(rs.getInt("tipoUsuario"));
                list.add(per);
            }
        } catch (Exception e) {
        }
       System.out.println("Conectado");
        return list;
    }
    
   
    public Usuario list(int cedula) {
        String sql="select * from usuario where cedula="+cedula;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setCedula(rs.getInt("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setClave(rs.getString("clave"));
                p.setTelefono(rs.getInt("telefono"));
                p.setTipo(rs.getInt("tipoUsuario"));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public boolean add(Usuario per) {
        String sql="insert into usuario(cedula, nombre, apellido, clave, telefono, tipoUsuario)values("+per.getCedula()+
               ",'"+per.getNombre()+"','"+per.getApellido()+"',"+per.getClave()+","+per.getTelefono()+","+per.getTipo()+")";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
    public boolean edit(Usuario per) {
        String sql = "update usuario set nombre='" + per.getNombre()+ "',apellido='"
                + per.getApellido()+ "',clave='" + per.getClave()+ "',telefono="
                + per.getTelefono()+ ",tipoUsuario=" + per.getTipo()+ " where cedula=" + per.getCedula();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("No se ejecuto la consulta");
        }
        return false;
    }
    
    public boolean eliminar(int cedula) {
        String sql="delete from usuario where cedula="+cedula;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}