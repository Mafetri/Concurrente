package ProblemasClasicos.ProductorConsumidor.Semaforos;
import java.util.concurrent.*;

public class Buffer {
    private Semaphore producto = new Semaphore(0);
    private Semaphore espacioDisponible;

    public Buffer(int capacidadMax) {
        espacioDisponible = new Semaphore(capacidadMax);
    }

    public void agarrarProducto() throws InterruptedException{
        System.out.println("Hay " + producto.availablePermits() + " 🌽");
        producto.acquire();
        espacioDisponible.release();
    }
    
    public void ponerProducto() throws InterruptedException{
        System.out.println("Hay " + espacioDisponible.availablePermits() + " lugares disponibles");
        espacioDisponible.acquire();
        producto.release();
    }
}
