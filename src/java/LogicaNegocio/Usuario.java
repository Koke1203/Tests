package LogicaNegocio;

public class Usuario {
    int cedula;
    String nombre;
    String apellido;
    String clave;
    int telefono;
    int tipo;
    
    public Usuario() {
    }
    
    public Usuario(int cedula, String clave){
        this.cedula = cedula;
        this.nombre = "";
        this.apellido = "";
        this.clave = clave;
        this.telefono = 0;
        this.tipo = 0;
    }
    
    public Usuario(int cedula, String nombre, String apellido, String clave, int telefono, int tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public int getCedula() {
        return cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
