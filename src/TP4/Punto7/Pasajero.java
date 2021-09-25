package TP4.Punto7;

public class Pasajero implements Runnable{
    private Taxi taxi;
    
    public Pasajero(Taxi taxi){
        this.taxi=taxi;
    }

    public void run() {
        try {
            taxi.viajar();
            System.out.println(Thread.currentThread().getName() + " terminó su viaje.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}