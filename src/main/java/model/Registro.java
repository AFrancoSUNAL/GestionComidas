package model;

/**
 *
 * @author Andres Felipe Franco
 */
public class Registro {
    
    private final int id; 
    private final Usuarios usuario;

    public Registro(int id, Usuarios usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }
    
}
