package LogicaNegocio;

import java.sql.Date;

public class Retiro {
    double monto;
    String fechaRetiro;
    int cuentas_NumCuentas;

    public Retiro() {
    }

    public Retiro(double monto, String fechaRetiro, int cuentas_NumCuentas) {
        this.monto = monto;
        this.fechaRetiro = fechaRetiro;
        this.cuentas_NumCuentas = cuentas_NumCuentas;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getCuentas_NumCuentas() {
        return cuentas_NumCuentas;
    }

    public void setCuentas_NumCuentas(int cuentas_NumCuentas) {
        this.cuentas_NumCuentas = cuentas_NumCuentas;
    }
    
    
}
