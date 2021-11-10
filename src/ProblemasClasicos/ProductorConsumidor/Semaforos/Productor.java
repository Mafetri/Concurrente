package ProblemasClasicos.ProductorConsumidor.Semaforos;

public class Productor implements Runnable{
    private Buffer buffer;

    Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        while (true) {
            try {
                System.out.println("El productor esta esperando a reponer 🥃");
                buffer.ponerProducto();
                System.out.println("El productor puso un 🌽");
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("El productor 💀");
            }
        }
    }
    
}
