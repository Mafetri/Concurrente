package ProblemasClasicos.ProductorConsumidor.Semaforos;

public class Consumidor implements Runnable{
    private Buffer b;
    public Consumidor(Buffer b){this.b = b;}
    public void run(){
        try{
            while(true){
                b.agarrarProducto();
                System.out.println("El " + Thread.currentThread().getName() + " esta esperando para agarrar otro producto");
                Thread.sleep(1000);
            }
        }catch(Exception e){System.out.println("El consumidor ripeo ☠️☠️");}
    }
}
