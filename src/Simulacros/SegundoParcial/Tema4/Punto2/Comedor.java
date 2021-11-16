package Simulacros.SegundoParcial.Tema4.Punto2;
import java.util.concurrent.locks.*;
public class Comedor {
    Lock mutex = new ReentrantLock();
    private int cantPlatos, racionesComida, perrosComiendo;
    Condition esperarLlenado = mutex.newCondition(), dormirEncargado = mutex.newCondition(), esperarVaciamiento = mutex.newCondition();
    
    public Comedor(int n){
        this.cantPlatos = n;
        this.perrosComiendo = 0;
        this.racionesComida = 0;    
    }

    public void comer() throws InterruptedException{
        mutex.lock();
        while(racionesComida == 0){
            while(perrosComiendo != 0){
                esperarVaciamiento.await();
            }
            System.out.println(Thread.currentThread().getName() + " espera por comida.");
            dormirEncargado.signal();
            esperarLlenado.await();
        }
        System.out.println(Thread.currentThread().getName() + " come.");
        racionesComida--;
        perrosComiendo++;
        mutex.unlock();
    }

    public void dejarComer(){
        mutex.lock();
        perrosComiendo--;
        System.out.println(Thread.currentThread().getName() + " dejó de comer.");
        if(perrosComiendo == 0){
            System.out.println(Thread.currentThread().getName() + " fue el ultimo en salir.");
            esperarVaciamiento.signalAll();
        }
        mutex.unlock();
    }

    public void esperarDormido() throws InterruptedException{
        mutex.lock();
        while(racionesComida != 0){
            dormirEncargado.await();
        }
        System.out.println(Thread.currentThread().getName() + " rellena los platos.");
        mutex.unlock();
    }
    public void llenaPlatos(){
        mutex.lock();
        racionesComida = cantPlatos;
        System.out.println(Thread.currentThread().getName() + " llenó los platos.");
        esperarLlenado.signalAll();
        mutex.unlock();
    }
}
