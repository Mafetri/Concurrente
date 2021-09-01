package TP2.Punto6Lineal;

public class Cajero {
    private String nombre;

    public Cajero(String nombre){
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long tiempo) {
        System.out.println("El cajero " + this.nombre + ", comienza a procesar la compra del cliente " + cliente.getNombre() + ", en el tiempo: " + (System.currentTimeMillis() - tiempo)/1000 + "seg.");
    
        for(int i = 0; i < cliente.getCarrito().length; i++) {
            esperar(cliente.getCarrito()[i]);
            System.out.println("Procesado el producto " + (i+1) + " -> Tiempo: " + (System.currentTimeMillis() - tiempo)/1000  + "seg.");
        }

        System.out.println("El cajero " + nombre + " ha terminado con el cliente " + cliente.getNombre() + " en " + (System.currentTimeMillis() - tiempo)/1000  + "seg.");
    }

    public void esperar(int segundos){
        try{
            Thread.sleep(segundos*1000);
        }catch(InterruptedException e){
            System.out.println("CAJERO " + nombre.toUpperCase() + " INTERRUMPIDO!!!");
        }
    }
}
