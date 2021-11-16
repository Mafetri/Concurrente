package Simulacros.SegundoParcial.Tema4.Punto2;

public class Perro implements Runnable{
    private Comedor c;
    public Perro(Comedor c){
        this.c = c;
    }
    public void run() {
        try{
            c.comer();
            Thread.sleep(1000);
            c.dejarComer();
        }catch(Exception e){
            System.out.println("💀💀");
        }
    }
}
