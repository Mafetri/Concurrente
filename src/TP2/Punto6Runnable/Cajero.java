package TP2.Punto6Runnable;

public class Cajero implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Cajero(String nombre, long tiempo, Cliente cliente){
        this.nombre = nombre;
        initialTime = tiempo;
        this.cliente = cliente;
    }

    public void run(){
        System.out.println("El cajero " + this.nombre + ", comienza a procesar la compra del cliente " + this.cliente.getNombre() + ", en el tiempo: " + (System.currentTimeMillis() - initialTime)/1000 + "seg.");
        
        for(int i = 0; i < cliente.getCarrito().length; i++) {
            esperar(cliente.getCarrito()[i]);
            System.out.println("Procesado el producto " + (i+1) + " del cliente " + this.cliente.getNombre() + " -> Tiempo: " + (System.currentTimeMillis() - initialTime)/1000  + "seg.");
        }

        System.out.println("El cajero " + this.nombre + " ha terminado con el cliente " + this.cliente.getNombre() + " en " + (System.currentTimeMillis() - initialTime)/1000  + "seg.");
    }

    public void esperar(int segundos){
        try{
            Thread.sleep(segundos*1000);
        }catch(InterruptedException e){
            System.out.println("CAJERO " + nombre.toUpperCase() + " INTERRUMPIDO!!!");
        }
    }
}
