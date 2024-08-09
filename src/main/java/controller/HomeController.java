package controller;

import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Context;
import view.ComidasView;
import view.Index;
import view.RegistrosView;
import view.UsuariosView;

/**
 *
 * @author Andres Felipe Franco
 */
public class HomeController {
    
    public static Context model;
    
    public static void main(String args[]){
        try {
            model = new Context();
        } catch (SQLException ex) {
            JOptionPane error = new JOptionPane(ex, JOptionPane.ERROR_MESSAGE);
            error.setVisible(true);
        }
        getIndex();
    }
        
    public static void getIndex(){
        Index index = new Index();
        index.setVisible(true);
    }
    
    public static void getComidasView(JDesktopPane display){
        if(validate(display, new ComidasView())) return;
        getPage(display, new ComidasView());
    }
    
    public static void getRegistrosView(JDesktopPane display){
        if(validate(display, new RegistrosView())) return;
        getPage(display, new RegistrosView());
    }
    
    public static void getUsuariosView(JDesktopPane display){
        if(validate(display, new UsuariosView())) return;
        getPage(display, new UsuariosView());
    }
    
    private static void getPage(JDesktopPane display, JInternalFrame frame){
        display.add(frame);
        frame.setVisible(true);
    }
    
    private static boolean validate(JDesktopPane display, JInternalFrame frame){
        for(JInternalFrame element : display.getAllFrames()) {
            if(element.getClass().equals(frame.getClass())){
                return true;
            }
        }
        return false;
    }
}
