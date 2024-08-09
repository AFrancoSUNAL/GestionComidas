package model;

/**
 *
 * @author Andres Felipe Franco
 */
public class Usuarios {
    
    private final int id;
    private final String nombre;
    private final String usuario;
    private final String telefono;
    private final String correo;

    public Usuarios(int id, String nombre, String usuario, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
    
}
