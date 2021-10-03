package TP4.Punto7;
import java.util.concurrent.*;

public class Taxi {
    private Semaphore taxiOcupado = new Semaphore(1);
    private Semaphore taxistaDormir = new Semaphore(1);
    private Semaphore destino = new Semaphore(0);

    // El pasajero ocupa el taxi, despierta al taxista y epera a destino, y se despierta
    public void viajar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " está esperando.");
        taxiOcupado.acquire();
        taxistaDormir.release();
        System.out.println(Thread.currentThread().getName() + " está viajando.");
        destino.acquire(); // VIAJANDO PA
    }

    // TAXISTA
    public void dejarViajar() throws InterruptedException {
        taxiOcupado.release();
        destino.release();
        System.out.println(Thread.currentThread().getName() + " está durmiendo.");
        taxistaDormir.acquire();
    }

    public void trabajar() throws InterruptedException{
        taxistaDormir.acquire();
    }
}
