package Simulacros.SegundoParcial.Tema1.Punto1;

public class Extractor implements Runnable{
    private Buffer b;
    public Extractor(Buffer b) {
        this.b = b;
    }
    public void run(){
        try{
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " extrajo " + b.extraer());
        }catch(Exception e){
            System.out.println("☠️☠️");
        }
    }
}
