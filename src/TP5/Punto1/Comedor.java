package TP5.Punto1;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Comedor {
    private char tipo;
    private Semaphore semComederos;
    private Semaphore esperarVaciamiento;
    private int cantidadComiendo = 0;
    private int cantMax;
    private Lock mutex1 = new ReentrantLock();
    private Lock mutex2 = new ReentrantLock();

    public Comedor(int cantMax){
        this.cantMax = cantMax;
        semComederos = new Semaphore(cantMax);
        esperarVaciamiento = new Semaphore(0);
        tipo = 'z';
    }

    public void comer(char tipo) throws InterruptedException{
        if(this.tipo != 'z' && tipo != this.tipo){
            esperarVaciamiento.acquire();
        }
        mutex1.lock();
        cantidadComiendo++;
        this.tipo = tipo;
        semComederos.acquire();
        mutex1.unlock();
    }

    public void dejarDeComer(char tipo) throws InterruptedException{
        mutex2.lock();
        cantidadComiendo--;
        semComederos.release();
        if(cantidadComiendo == 0){
            esperarVaciamiento.release(cantMax);
        }
        mutex2.unlock();
    }
}
