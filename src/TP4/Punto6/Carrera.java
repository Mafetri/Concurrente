package TP4.Punto6;

import java.util.concurrent.*;

public class Carrera {
    private Semaphore ladoIzq = new Semaphore(1);
    private Semaphore ladoDer = new Semaphore(0);

    public void correr(char lado) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " está esperando del lado " + lado);
        if (lado == 'i') {
            ladoIzq.acquire();

        } else {
            ladoDer.acquire();
        }
        System.out.println(Thread.currentThread().getName() + " agarró el testigo. ");
    }

    public void terminar(char lado) {
        System.out.println(Thread.currentThread().getName() + " soltó el testigo.");
        if (lado == 'i') {
            ladoDer.release();
        } else {
            ladoIzq.release();
        }
    }

}
