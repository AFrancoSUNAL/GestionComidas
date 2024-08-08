package model;

/**
 *
 * @author Andres Felipe Franco
 */
public class Comidas {
    
    private int id;
    private String nombre;
    private String tipo;
    private float valor;
    private int cantDisponible;

    public Comidas(int id, String nombre, String tipo, float valor, int cantDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.cantDisponible = cantDisponible;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    
    public float getValor(){
        return valor;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }
    
    
    
}
