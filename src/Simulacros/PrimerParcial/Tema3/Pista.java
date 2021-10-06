package Simulacros.PrimerParcial.Tema3;
import java.util.concurrent.*;

public class Pista {
    Semaphore semHobby = new Semaphore(0);
    Semaphore semAterrizaje = new Semaphore(0, true);
    Semaphore semDespegue = new Semaphore(0, true);
    Semaphore pistaVacia = new Semaphore(1);
    int esperandoAterrizaje = 0;
    int esperandoDespegue = 0;

    // ---- Avion ----
    // Depegue
    public void solicitarDespegue() throws InterruptedException{
        semHobby.release();
        esperandoDespegue++;
        semDespegue.acquire();
    }
    // Aterrizaje
    public void solicitarAterrizaje() throws InterruptedException{
        semHobby.release();
        // Le pide permiso de aterrizaje
        esperandoAterrizaje++;
        semAterrizaje.acquire();
    }
    public void liberarPista(){
        pistaVacia.release();
    }

    // ---- Controlador ----
    public void esperarAviones() throws InterruptedException {
        if(esperandoAterrizaje + esperandoDespegue >= 0){
            // si no habia trafico, espera a que alguien lo despierte
            semHobby.acquire();
        }
    }
    public void controlar() throws InterruptedException {
        pistaVacia.acquire();
        if(esperandoAterrizaje > 0){
            semAterrizaje.release();
            esperandoAterrizaje--;
        }else{
            semDespegue.release();
            esperandoDespegue--;
        }
    }
}
