package TP2.Punto6Thread;

public class Cliente {
    private String nombre;
    private int[] carrito;

    public Cliente(String nombre, int[] carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
    }
    public int[] getCarrito() {
        return carrito;
    }
}
