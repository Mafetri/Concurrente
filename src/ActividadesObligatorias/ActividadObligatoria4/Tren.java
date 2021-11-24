package ActividadesObligatorias.ActividadObligatoria4;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.CountDownLatch;

public class Tren {
    BlockingDeque<Character> hola = new LinkedBlockingDeque();

    CountDownLatch latch = new CountDownLatch(20);
    CountDownLatch latch2 = new CountDownLatch(1);

    // ==== Cliente ====
    public void comprarTicket(){
      
    }

    public void subirTren() throws InterruptedException{
        if(latch.getCount() == 0){
            latch2.await();
        }
        latch.countDown();
    }

    // ==== Vendedor ====


    
    // ==== Control Tren ====
    public void esperarPasajeros()throws InterruptedException{
        latch.await();
    }
    public void llegaEstacion(){
        latch2.countDown();
        latch = new CountDownLatch(20);
    }
}
