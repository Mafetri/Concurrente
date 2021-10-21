package ActividadObligatoria2.Punto2.Semaforos;
import java.util.concurrent.*;

public class Planta {
    private Semaphore semBotellas = new Semaphore(0);
    private Semaphore semEmbotellar = new Semaphore(10);

    public void embotellar() throws InterruptedException {
        semEmbotellar.acquire();
    }
    public void meterBotella(){
        semBotellas.release();
    }
    public void adquiereCaja() throws InterruptedException{
        semBotellas.acquire(10);
    }
    public void darCaja(){
        semEmbotellar.release(10);
    }
}
