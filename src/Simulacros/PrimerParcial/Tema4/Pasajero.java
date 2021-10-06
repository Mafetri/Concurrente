package Simulacros.PrimerParcial.Tema4;

public class Pasajero implements Runnable{
    private Tren tren;
    public Pasajero(Tren tren) {
        this.tren = tren;
    }
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" esta esperando que le vendan ticket");
            tren.comprarTiket();
            System.out.println(Thread.currentThread().getName()+" se sube al tren");
            tren.sentarse();
            tren.bajarse();
            System.out.println(Thread.currentThread().getName()+" se bajó del tren.");
        }catch(Exception e){}
    }
}
