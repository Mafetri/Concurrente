package TP5.Punto1B;
import java.util.concurrent.*;

public class Comedor {
    private Semaphore semComederos;
    private Semaphore colaGatos = new Semaphore(0);
    private Semaphore colaPerros = new Semaphore(0);
    private Semaphore esperarVaciamiento = new Semaphore(0);
    private int cantEsperando;
    private int comidos = 0;

    public Comedor(int cantMax){
        semComederos = new Semaphore(cantMax);
    }

    public void comer(char tipo) throws InterruptedException{
        if(tipo == 'p'){
            colaPerros.acquire();
        }else{
            colaGatos.acquire();
        } 
        cantEsperando++;
        semComederos.acquire();
    }

    public void dejarDeComer(char tipo) throws InterruptedException{
        semComederos.release();
        comidos++;
        if(comidos == cantEsperando){
            esperarVaciamiento.release(1);
        }
    }

    // ===== Gestor ====
    public void comerPerros(int permisos){
        comidos = 0;
        cantEsperando = 0;
        colaPerros.release(permisos);
    }
    public void esperarVaciamiento() throws InterruptedException{
        esperarVaciamiento.acquire();
    }
    public void comerGatos(int permisos){
        comidos = 0;
        cantEsperando = 0;
        colaGatos.release(permisos);
    }
}
