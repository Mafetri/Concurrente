package Simulacros.PrimerParcial.Tema4;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class Tren {
    private int cantPasajeros;
    private int maxPasajeros;
    Semaphore vendedor = new Semaphore(0);
    Semaphore ticket = new Semaphore(0);
    Semaphore destino = new Semaphore(0);
    Semaphore trenLleno = new Semaphore(0);
    Semaphore vendedorPuedeVender = new Semaphore(1);
    Semaphore trenLibre = new Semaphore(1);

    public Tren(int max) {
        this.maxPasajeros = max;
        this.cantPasajeros = 0;
    }
    // Pasajero
    public void comprarTiket() throws InterruptedException {
        // Espera a recibir un ticket
        ticket.acquire();
    }
    public void sentarse() throws InterruptedException {
        // Espera a destino
        destino.acquire();
    }
    public synchronized void bajarse() throws InterruptedException {
        // Se baja del tren
        cantPasajeros--;
        // Permite que el proximo se baje del tren
        destino.release();
        // Si el tren ya esta vacio, el ultimo pasajero da aviso a los otros pasajeros con ticket
        if(cantPasajeros == 0){
            trenLibre.release();
            destino.acquire();
        }
    }

    // ---- Vendedor -----
    public void esprandoATren() throws InterruptedException{
        // Esperando que llegue el tren
        vendedorPuedeVender.acquire();
        // Espera a que se vacie
        trenLibre.acquire();
    }
    public synchronized boolean darTicket() throws InterruptedException{
        boolean dar = true;

        if(cantPasajeros < maxPasajeros){
            // Si no se llego al maximo de pasajeros, da un ticket
            ticket.release();
            cantPasajeros++;
        }else{
            // Sino avisa que el tren esta lleno y cierra las puertas
            trenLleno.release();
            dar = false;
        }
        return dar;
    }

    // ---- Control tren ----
    public void enEstacion()throws InterruptedException{
        destino.release();
        vendedorPuedeVender.release();
    }
    public void viajar() throws InterruptedException{
        trenLleno.acquire();
    }
}
