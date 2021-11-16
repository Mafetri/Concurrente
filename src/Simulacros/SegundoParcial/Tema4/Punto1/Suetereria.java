package Simulacros.SegundoParcial.Tema4.Punto1;
import java.util.concurrent.*;
public class Suetereria {
    private Semaphore hacerManga;
    private Semaphore hacerCuerpo;
    private Semaphore cuerposHechos = new Semaphore(0);
    private Semaphore mangasHechas  = new Semaphore(0);
    private int numMaxMangas;
    private int numMaxCuerpos;
    private int cajaSueteresMax;
    private int tandaSueteres = 0;
    
    public Suetereria(int numMangas, int numCuerpos, int cajaSueteresMax){
        numMaxMangas = numMangas;
        numMaxCuerpos = numCuerpos;
        this.cajaSueteresMax = cajaSueteresMax;
        hacerManga = new Semaphore(numMaxMangas);
        hacerCuerpo = new Semaphore(numMaxCuerpos);
    }

    // ==== Manguero ====
    public void hacerManga() throws InterruptedException{
        hacerManga.acquire();
        System.out.println("🧪  -> " + hacerManga.availablePermits());
    }
    public void meterMangaCesto() throws InterruptedException{
        mangasHechas.release();
    }
    
    // ==== Cuerperos ====
    public void hacerCuerpo() throws InterruptedException{
        hacerCuerpo.acquire();
        System.out.println("👄  -> " + hacerCuerpo.availablePermits());
    }
    public void meterCuerpoCesto() throws InterruptedException{
        cuerposHechos.release();
    }

    // ==== Ensamblador ====
    public void esperarMateriales() throws InterruptedException{
        mangasHechas.acquire(2);
        hacerManga.release(2);
        cuerposHechos.acquire();
        hacerCuerpo.release();
    }
    public boolean entregarSueter(){
        tandaSueteres++;
        if(tandaSueteres == cajaSueteresMax){
            tandaSueteres = 0;
            return true;
        }
        return false;
    }

    
}
