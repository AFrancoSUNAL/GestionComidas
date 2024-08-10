package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Comidas;
import view.Index;

/**
 *
 * @author Andres Felipe Franco
 */
public class ComidasController {
    
    private final Connection context = HomeController.model.conn;
    
    public ArrayList<Comidas> getComidas() {
        
        ArrayList<Comidas> datos = new ArrayList<>();
        
        try{
            PreparedStatement consulta;
            consulta = context.prepareStatement("SELECT * FROM comidas");
            
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                datos.add(new Comidas(resultado.getInt("id"),
                                       resultado.getString("nombre"),
                                       resultado.getString("tipo"),
                                       resultado.getFloat("valor"),
                                       resultado.getInt("cantDisponible")
                ));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        } 
        
        return datos;
    }
    
    public void createComida(Comidas comida) {
        
        try {
            PreparedStatement consulta;
            consulta = context.prepareStatement("INSERT INTO comidas (nombre, tipo, valor, cantDisponible) VALUES (?, ?, ?, ?)");
            consulta.setString(1, comida.getNombre());
            consulta.setString(2, comida.getTipo());
            consulta.setFloat(3, comida.getValor());
            consulta.setInt(4, comida.getCantDisponible());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(new Index(), "Comida creada con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void deleteComida(int id) {
        
        try {
            PreparedStatement consulta;
            consulta = context.prepareStatement("DELETE FROM comidas WHERE id = ?");
            consulta.setInt(1, id);
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(new Index(), "Comida eliminada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void updateComida(int id, String nombre, String tipo, Float valor, int cantDisponible) {
        
        try {
            PreparedStatement consulta;
            consulta = context.prepareStatement("UPDATE comidas SET nombre = ?, tipo = ?, valor = ?, cantDisponible = ? WHERE id = ?");
            consulta.setString(1, nombre);
            consulta.setString(2, tipo);
            consulta.setFloat(3, valor);
            consulta.setInt(4, cantDisponible);
            consulta.setInt(5, id);
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(new Index(), "Comida editada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Index(), ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
