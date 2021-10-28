package TP5.Punto3;
import java.util.concurrent.*;

public class Tren {
    private Semaphore bajarse = new Semaphore(0);
    private Semaphore asientos;
    private Semaphore semVendedor = new Semaphore(0, true);
    private Semaphore vacio;
    private Semaphore ticket = new Semaphore(0);
    private Semaphore viajar = new Semaphore(0);
    private int asientosOcupados;
    private int capacidadMaxima;

    public Tren(int capacidad) {
        this.asientos = new Semaphore(capacidad, true);
        vacio = new Semaphore(capacidad, true);
        this.capacidadMaxima = capacidad;
    }

    // ==== Pasajero ====
    public void comprarTiket() throws InterruptedException {
        semVendedor.release();
        ticket.acquire();
    }
    public void subirse() throws InterruptedException {
        vacio.acquire();
        asientosOcupados++;
        asientos.acquire();
        if(asientosOcupados == capacidadMaxima){
            viajar.release();
        }
    }
    public void bajarse() throws InterruptedException {
        bajarse.acquire();
        asientosOcupados--;
        asientos.release();
        if(asientosOcupados <= 0){
            vacio.release(capacidadMaxima);
        }
    }

    // ==== Vendedor ====
    public void esperarCliente() throws InterruptedException {
        semVendedor.acquire();
    }
    public void venderTicket() throws InterruptedException {
        ticket.release();
    }

    // ==== Control Tren ====
    public void destino() throws InterruptedException {
        bajarse.release(this.capacidadMaxima);
    }
    public void esperarLlenado() throws InterruptedException {
        viajar.acquire();
    }
}
