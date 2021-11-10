package ProblemasClasicos.ProductorConsumidor.Monitor;

public class Productor implements Runnable{
    private Buffer buffer;

    Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        while (true) {
            try {
                buffer.ponerProducto();
                //Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("El productor 💀");
            }
        }
    }
}
