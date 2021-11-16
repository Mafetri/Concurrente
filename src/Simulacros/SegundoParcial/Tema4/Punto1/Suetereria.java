package Simulacros.SegundoParcial.Tema4.Punto1;
import java.util.concurrent.*;
public class Suetereria {
    private Semaphore hacerManga;
    private Semaphore hacerCuerpo;
    private Semaphore cuerposHechos = new Semaphore(0);
    private Semaphore mangasHechas  = new Semaphore(0);
    private int numMaxMangas;
    private int numMaxCuerpos;
    private int cantidadMangasActual;
    private int cantidadCuerposActuales;
    private int cajaSueteresMax;
    private int tandaSueteres = 0;
    
    public Suetereria(int numMangas, int numCuerpos, int cajaSueteresMax){
        numMaxMangas = numMangas;
        numMaxCuerpos = numCuerpos;
        this.cajaSueteresMax = cajaSueteresMax;
        hacerManga = new Semaphore(0);
        hacerCuerpo = new Semaphore(0);
    }

    // ==== Manguero ====
    public boolean hacerManga() throws InterruptedException{
        boolean hagoManga = false;
        if(cantidadMangasActual < numMaxMangas){
            hagoManga = true;
            cantidadMangasActual++;
            System.out.println("🧪" + cantidadMangasActual);
        }else{
            hacerManga.acquire();
        }
        return hagoManga;
    }
    public void meterMangaCesto() throws InterruptedException{
        mangasHechas.release();
    }
    
    
    public boolean hacerCuerpo() throws InterruptedException{
        boolean hagoCuerpo = false;
        if(cantidadCuerposActuales < numMaxCuerpos){
            hagoCuerpo = true;
            cantidadCuerposActuales++;
            System.out.println("👄   " + cantidadCuerposActuales);
        }else{
            hacerCuerpo.acquire();
        }
        return hagoCuerpo;
    }
    public void meterCuerpoCesto() throws InterruptedException{
        cuerposHechos.release();
    }

    // ==== Ensamblador ====
    public void esperarMateriales() throws InterruptedException{
        mangasHechas.acquire(2);
        cuerposHechos.acquire();
        cantidadMangasActual -= 2;
        cantidadCuerposActuales--;
        if(cantidadMangasActual+2 == numMaxMangas){
            hacerManga.release();
        }
        if(cantidadCuerposActuales+1 == numMaxCuerpos){
            hacerCuerpo.release();
        }
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
