package TP4.Punto10;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class Confiteria {
    private Semaphore servir = new Semaphore(0);
    private Semaphore comer = new Semaphore(0);
    private Semaphore hobbie = new Semaphore(0);
    private Lock silla = new ReentrantLock();

    // Empleado
    public boolean sentarse(){
        boolean exito = false;
        if(silla.tryLock()){
            exito = true;
            servir.release();
        }
        return exito;
    }
    public void comer() throws InterruptedException{
        comer.acquire();
    }
    public void dejarDeComer() throws InterruptedException{
        silla.unlock();
        servir.acquire();
        hobbie.release();
    }

    // Mozo
    public void atender() throws InterruptedException{
        servir.acquire();
    }
    public void servir() throws InterruptedException{
        comer.release();
        servir.release();
        hobbie.acquire();
    }
}
