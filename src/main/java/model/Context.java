package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Felipe Franco Sepulveda
 */
public class Context {
    
    public Connection conn;
    
    public Context() throws SQLException {
        dbConnect();
    }
    
    public void dbConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gestioncomidas";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conexión exitosa");
//            create(conn, "Andres", "1085834023", "email@domain.com");
//            update(conn, "1085834023", "1000834023", "Rodrigo", "pipefs@correo.com");
//            read(conn, "1000834023");
//            delete(conn, "1000834023");
        }catch(SQLException ex) {
            System.out.println(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
