package Model;

import LogicaNegocio.UsuarioRecuperacion;

public class ModelLogin {
    
    UsuarioRecuperacion current;
    
    public ModelLogin() {
        this.reset();
    }
    
    private void reset() {
        setCurrent(new UsuarioRecuperacion());
    }

    public UsuarioRecuperacion getCurrent() {
        return current;
    }

    public void setCurrent(UsuarioRecuperacion current) {
        this.current = current;
    }
    
}
