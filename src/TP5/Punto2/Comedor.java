package TP5.Punto2;
import java.util.concurrent.*;

public class Comedor {
    private Semaphore semComederos;
    private Semaphore colaGatos = new Semaphore(0);
    private Semaphore colaPerros;
    private int comidos = 0;
    private int turnos;
    private int cantComederos;

    public Comedor(int cantMax, int turnos){
        cantComederos = cantMax;
        semComederos = new Semaphore(cantComederos);
        this.turnos = turnos;
        colaPerros = new Semaphore(turnos);
    }

    public void comer(char tipo) throws InterruptedException{
        if(tipo == 'p'){
            colaPerros.acquire();
            semComederos.acquire(2);
        }else{
            colaGatos.acquire();
            semComederos.acquire();
        } 
    }

    public synchronized void dejarDeComerPerros() throws InterruptedException{
        semComederos.release(2);
        comidos++;
        if(semComederos.availablePermits() == cantComederos && (comidos >= turnos || !colaPerros.hasQueuedThreads())){
            colaGatos.release(turnos);
            comidos = 0;
            if(!colaGatos.hasQueuedThreads()){
                colaPerros.release(colaPerros.getQueueLength());
            }
        }
    }
    public synchronized void dejarDeComerGatos() throws InterruptedException{
        semComederos.release();
        comidos++;
        if(semComederos.availablePermits() == cantComederos && (comidos >= turnos || !colaGatos.hasQueuedThreads())){
            colaPerros.release(turnos);
            comidos = 0;
            if(!colaPerros.hasQueuedThreads()){
                colaGatos.release(colaGatos.getQueueLength());
            }
        }
    }
}
