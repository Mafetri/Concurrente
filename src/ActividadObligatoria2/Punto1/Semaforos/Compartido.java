package ActividadObligatoria2.Punto1.Semaforos;
import java.util.concurrent.*;

public class Compartido {
    private Semaphore sem3 = new Semaphore(0);
    private int a, b, c, w;

    public void s1(int x, int y){
        a = x+y;
        sem3.release();
    }
    public void s2(int z){
        b = z - 1;
        sem3.release();
    }

    public void s3() throws InterruptedException{
        sem3.acquire(2);
        c = a - b;
    }
    public int s4(){
        w = c + 1;
        return w;
    }

}
