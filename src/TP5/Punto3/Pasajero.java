package TP5.Punto3;

public class Pasajero implements Runnable{

    private Tren tren;

    public Pasajero(Tren tren) {
        this.tren = tren;
    }

    public void run(){
        String nombre = Thread.currentThread().getName();
        try{
            System.out.println("El pasajero "+ nombre +" esta esperando a comprar el ticket");
            tren.comprarTiket();
            System.out.println("El pasajero "+ nombre +" compro su ticket y esta esperando a subirse al tren");
            tren.subirse();
            System.out.println("El pasajero "+ nombre +" se subio al tren esta esperando a que parta");
            tren.bajarse();
            System.out.println("El pasajero "+ nombre +" se bajo del tren");
        }catch(Exception e){
            System.out.println("Lo desaparecio thanos");
        }
    }
    
}
