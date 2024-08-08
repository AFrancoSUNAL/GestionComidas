package controller;

import java.sql.SQLException;
import model.Context;

/**
 *
 * @author Andres Felipe Franco
 */
public class HomeController {
    
    public Context context;
    
    public HomeController () throws SQLException {
        context = new Context();
    }
    
}
