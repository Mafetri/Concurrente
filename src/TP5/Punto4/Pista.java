package TP5.Punto4;

import java.util.concurrent.*;

public class Pista {
    Semaphore semPista = new Semaphore(1);
    Semaphore semTorre = new Semaphore(0);
    Semaphore prioridad = new Semaphore(10);
    Semaphore semAterrizar = new Semaphore(1);
    Semaphore semDespegue = new Semaphore(0);
    private int avionParaAterrizar = 0;

    // ==== Avion ====
    public void comunicarTorre() {
        semTorre.release();
    }

    public void solicitarAterrizaje() throws InterruptedException {
        synchronized (Avion.class) {
            avionParaAterrizar++;
        }
        semAterrizar.acquire();
        synchronized (Avion.class) {
            avionParaAterrizar--;
        }
    }

    public void solicitarDespegue() throws InterruptedException {
        semDespegue.acquire();
    }

    public void liberarPista() {
        semPista.release();
    }

    // ==== Torre ====
    public void esperarAvion() throws InterruptedException {
        semTorre.acquire();
    }

    public void darOrden() throws InterruptedException {
        semPista.acquire();
        if (avionParaAterrizar == 0) {
            semDespegue.release();
        } else if (!prioridad.tryAcquire()) {
            semDespegue.release();
            prioridad.release(10);
        } else {
            semAterrizar.release();
        }
    }

}
