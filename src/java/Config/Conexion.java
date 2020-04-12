package Config;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/sistema_banco?user=root&password=1234&useSSL=false");  
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Error esta aquí"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
