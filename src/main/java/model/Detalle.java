package model;

import java.util.ArrayList;

/**
 *
 * @author Andres Felipe Franco
 */
public class Detalle {
    
    private ArrayList<Comidas> comidas;
    private int cantidad;
    private float total;

    public Detalle(ArrayList<Comidas> comidas) {
        this.comidas = comidas;
        this.cantidad = comidas.size();
        calcTotal();
    }
    
    private void calcTotal(){
        for(Comidas comida : comidas) {
            total += comida.getValor();
        }
    }

    public ArrayList<Comidas> getComidas() {
        return comidas;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public float getTotal(){
        return total;
    }    
}
