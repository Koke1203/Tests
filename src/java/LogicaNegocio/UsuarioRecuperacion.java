package LogicaNegocio;

public class UsuarioRecuperacion {
    
    String cedula;
    String clave;
    
    public UsuarioRecuperacion(){
    }

    public UsuarioRecuperacion(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
