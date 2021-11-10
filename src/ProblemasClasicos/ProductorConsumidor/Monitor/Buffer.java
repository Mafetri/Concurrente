package ProblemasClasicos.ProductorConsumidor.Monitor;
import java.util.concurrent.locks.*;
public class Buffer {
    private int espacioDisponible;
    private int capacidadMax;
    private ReentrantLock mutex = new ReentrantLock();
    private Condition hayEspacio = mutex.newCondition(), hayProducto = mutex.newCondition();
    public Buffer(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        this.espacioDisponible = capacidadMax;
    }
    public void agarrarProducto() throws InterruptedException{
        mutex.lock();
        try{
            while(espacioDisponible >= capacidadMax){
                System.out.println("El "+Thread.currentThread().getName()+" espera a que haya productos");
                hayProducto.await();
            }
            System.out.println("El "+Thread.currentThread().getName()+" agarró un producto.");
            espacioDisponible++;
            hayEspacio.signal();
        }finally{
            mutex.unlock();
        }
    }

    public void ponerProducto() throws InterruptedException{
        mutex.lock();
        try{
            while(espacioDisponible <= 0){
                System.out.println("El productor esta esperando a reponer 🥃");
                hayEspacio.await();
            }
            espacioDisponible--;
            System.out.println("El productor puso un 🌽");
            hayProducto.signal();
        }finally{mutex.unlock();}
    }
}

