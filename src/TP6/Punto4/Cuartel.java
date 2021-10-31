package TP6.Punto4;

import java.util.concurrent.*;

public class Cuartel {
    Semaphore mostradorComida;
    Semaphore mostradorPostre;
    Semaphore abridores;

    public Cuartel(int cantMostradorComida, int cantMostradorPostre, int cantAbridores) {
        mostradorComida = new Semaphore(cantMostradorComida);
        mostradorPostre = new Semaphore(cantMostradorPostre);
        abridores = new Semaphore(cantAbridores);
    }

    public void mostradorAlmuerzo(boolean gaseosa) throws InterruptedException {
        mostradorComida.acquire();
        if (gaseosa) {
            System.out.println("El " + Thread.currentThread().getName() + " está esperando para la gaseosa.");
            abridores.acquire();
        }
    }

    public void dejarMostradorAlmuerzo(boolean gaseosa) {
        mostradorComida.release();
        if (gaseosa) {
            System.out.println("El " + Thread.currentThread().getName() + " abrió la gaseosa anashe. 🥶");
            abridores.release();
        }
    }

    public void mostradorPostre() throws InterruptedException {
        mostradorPostre.acquire();
    }

    public void dejarMostradorPostre() {
        mostradorPostre.release();
    }
}