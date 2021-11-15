package Simulacros.SegundoParcial.Tema1.Punto2;
import java.util.concurrent.locks.*;

public class Ferry {
    private Lock mutex = new ReentrantLock();
    private Condition esperarDestino = mutex.newCondition(), esperarVaciamiento = mutex.newCondition(),
            esperarFerry = mutex.newCondition(), esperarLlenado = mutex.newCondition();
    private int cantMax = 10;
    private int cantActual = 0;

    // ==== Auto ====
    public void subirAlFerry() throws InterruptedException {
        mutex.lock();
        while (cantActual >= cantMax) {
            esperarFerry.await();
        }
        System.out.println(Thread.currentThread().getName() + " se sube al ferry ⬅️🚗");
        cantActual++;
        if (cantActual == cantMax) {
            esperarLlenado.signal();
        }
        mutex.unlock();
    }

    public void bajar() throws InterruptedException{
        mutex.lock();
        esperarDestino.await();
        cantActual--;
        System.out.println(Thread.currentThread().getName() + " se baja del ferry ➡️🚗");
        if(cantActual == 0){
            System.out.println(Thread.currentThread().getName() + " bajo ultimo ➡️🚗 ");
            esperarVaciamiento.signal(); 
        }else{
            esperarDestino.signal();
        }
        mutex.unlock();
    }

    public void llenar() throws InterruptedException{
        mutex.lock();
        esperarFerry.signalAll();
        esperarLlenado.await();
        mutex.unlock();
    }
    public void llegarDestino() throws InterruptedException {
        mutex.lock();
        esperarDestino.signal();
        esperarVaciamiento.await();
        mutex.unlock();
    }

}

