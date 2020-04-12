package LogicaNegocio;

public class Cuenta {
    int num_cuenta;
    int moneda;
    double saldo;
    double limite_diario;
    int usuario;
    
    public Cuenta() {}

    public Cuenta(int num_cuenta, int moneda, double saldo, double limite_diario, int usuario) {
        this.num_cuenta = num_cuenta;
        this.moneda = moneda;
        this.saldo = saldo;
        this.limite_diario = limite_diario;
        this.usuario = usuario;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public int getMoneda() {
        return moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite_diario() {
        return limite_diario;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimite_diario(double limite_diario) {
        this.limite_diario = limite_diario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
}
