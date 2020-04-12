package LogicaNegocio;

public class Deposito {
    double monto;
    String fecha;
    int cedula_depositante;
    int cedula_receptor;
    String motivo;
    int tipo_operacion;
    int cuenta_usuario;

    public Deposito(double monto, String fecha, int cedula_depositante, int cedula_receptor, String motivo, int tipo_operacion, int cuenta_usuario) {
        this.monto = monto;
        this.fecha = fecha;
        this.cedula_depositante = cedula_depositante;
        this.cedula_receptor = cedula_receptor;
        this.motivo = motivo;
        this.tipo_operacion = tipo_operacion;
        this.cuenta_usuario = cuenta_usuario;
    }

    public Deposito() {
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCedula_depositante() {
        return cedula_depositante;
    }

    public void setCedula_depositante(int cedula_depositante) {
        this.cedula_depositante = cedula_depositante;
    }

    public int getCedula_receptor() {
        return cedula_receptor;
    }

    public void setCedula_receptor(int cedula_receptor) {
        this.cedula_receptor = cedula_receptor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(int tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public int getCuenta_usuario() {
        return cuenta_usuario;
    }

    public void setCuenta_usuario(int cuenta_usuario) {
        this.cuenta_usuario = cuenta_usuario;
    }
    
    
    
}
