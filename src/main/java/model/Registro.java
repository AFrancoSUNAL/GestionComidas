package model;

/**
 *
 * @author Andres Felipe Franco
 */
public class Registro {
    
    private int id; 
    private Cliente usuario;

    public Registro(int id, Cliente usuario) {
        this.id = id;
        this.usuario = usuario;
    }
    
    public void crearRegistro(){
        
    }

    public int getId() {
        return id;
    }

    public Cliente getUsuario() {
        return usuario;
    }
    
}
