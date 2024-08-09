package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuarios;
import view.Index;

/**
 *
 * @author Andres Felipe Franco
 */
public class UsuariosController {
    
    private final Connection context = HomeController.model.conn;
    
    public ArrayList<Usuarios> getUsuarios() {
        
        ArrayList<Usuarios> datos = new ArrayList<>();
        
        try{
            PreparedStatement consulta;
            consulta = context.prepareStatement("SELECT * FROM usuarios");
            
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                datos.add(new Usuarios(resultado.getInt("id"),
                                       resultado.getString("nombre"),
                                       resultado.getString("usuario"),
                                       resultado.getString("telefono"),
                                       resultado.getString("correo")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        } 
        
        return datos;
    }
    
    public void createUsuario(Usuarios usuario) {
        
        try {
            PreparedStatement consulta;
            consulta = context.prepareStatement("INSERT INTO usuarios (nombre, usuario, telefono, correo) VALUES (?, ?, ?, ?)");
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getUsuario());
            consulta.setString(3, usuario.getTelefono());
            consulta.setString(4, usuario.getCorreo());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(new Index(), "Usuario creado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void deleteUsuario(int id){
        
        try {
            PreparedStatement consulta;
            consulta = context.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            consulta.setInt(1, id);
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(new Index(), "Usuario eliminado");
        } catch (SQLException ex) {
            
        }
        
    }
}
