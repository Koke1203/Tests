package LogicaNegocio;
public class CuentasFavoritas {
    
    int usuario_Cedula;
    int cuentas_NumCuentas;

    public CuentasFavoritas() {
    }

    public CuentasFavoritas(int usuario_Cedula, int cuentas_NumCuentas) {
        this.usuario_Cedula = usuario_Cedula;
        this.cuentas_NumCuentas = cuentas_NumCuentas;
    }

    public int getUsuario_Cedula() {
        return usuario_Cedula;
    }

    public void setUsuario_Cedula(int usuario_Cedula) {
        this.usuario_Cedula = usuario_Cedula;
    }

    public int getCuentas_NumCuentas() {
        return cuentas_NumCuentas;
    }

    public void setCuentas_NumCuentas(int cuentas_NumCuentas) {
        this.cuentas_NumCuentas = cuentas_NumCuentas;
    }
    
}
