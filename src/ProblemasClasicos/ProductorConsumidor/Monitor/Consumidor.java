package ProblemasClasicos.ProductorConsumidor.Monitor;

public class Consumidor implements Runnable{
    private Buffer b;
    public Consumidor(Buffer b){this.b = b;}
    public void run(){
        try{
            while(true){
                b.agarrarProducto();                
                Thread.sleep(1000);
            }
        }catch(Exception e){System.out.println("El consumidor ripeo ☠️☠️");}
    }
}
