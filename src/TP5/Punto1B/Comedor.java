package TP5.Punto1B;
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
        }else{
            colaGatos.acquire();
        } 
        semComederos.acquire();
    }

    public synchronized void dejarDeComerPerros() throws InterruptedException{
        semComederos.release();
        comidos++;
        if(semComederos.availablePermits() == cantComederos && comidos >= turnos){
            colaGatos.release(turnos);
            comidos = 0;
        }
    }
    public synchronized void dejarDeComerGatos() throws InterruptedException{
        semComederos.release();
        comidos++;
        if(semComederos.availablePermits() == cantComederos && comidos >= turnos){
            colaPerros.release(turnos);
            comidos = 0;
        }
    }
}
