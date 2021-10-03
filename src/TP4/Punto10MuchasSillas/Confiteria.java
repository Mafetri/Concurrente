package TP4.Punto10MuchasSillas;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class Confiteria {
    private Semaphore servir = new Semaphore(0);
    private Semaphore comer = new Semaphore(0);
    private Lock[] sillas;

    public Confiteria(int cantSillas) {
        sillas = new ReentrantLock[cantSillas];
        for(int i = 0; i < cantSillas; i++){
            sillas[i] = new ReentrantLock();
        }
    }

    // Empleado
    public int sentarse(){
        int sillaUsada = -1;
        int i = 0;
        do{
            if(sillas[i].tryLock()){
                sillaUsada = i;
                // Le dice al mozo que lo atienda (el estaba en su hobbie)
                servir.release();
            }
            i++;
        }while(sillaUsada == -1 && i < sillas.length);
        
        return sillaUsada;
    }
    public void comer() throws InterruptedException{
        // Espera que le sirvan el plato
        comer.acquire();
        // Se pone a comer
    }
    public void dejarDeComer(int sillaUsada) throws InterruptedException{
        // Deja de comer y libera la silla
        sillas[sillaUsada].unlock();
    }

    // Mozo
    public void atender() throws InterruptedException{
        // Esta en su hobbie esperando atender
        servir.acquire();
    }
    // ---- El mozo prepara la comida ----
    public void servir() throws InterruptedException{
        // Le dice al empleado que coma
        comer.release();
    }

}
