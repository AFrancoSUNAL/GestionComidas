package model;

import java.util.HashMap;

/**
 *
 * @author Andres Felipe Franco
 */
public class Detalle {
    
    private final int id;
    private final int registro;
    private final HashMap<Comidas, Integer> comidas;
    private final int cantidadTotal;
    private float total;

    public Detalle(int id, int registro, HashMap<Comidas, Integer> comidas) {
        this.id = id;
        this.registro = registro;
        this.comidas = comidas;
        this.cantidadTotal = comidas.size();
        calcTotal();
        
    }
    
    private void calcTotal() {
        comidas.forEach((value, key) -> {
            this.total += value.getValor();
        });
    }    
    
    public void agregarComida(Comidas comida, int cantidad) {
        comidas.put(comida, cantidad);
    }

    public int getId() {
        return id;
    }

    public int getRegistro() {
        return registro;
    }

    public HashMap<Comidas, Integer> getComidas() {
        return comidas;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public float getTotal() {
        return total;
    }
    
    
}
