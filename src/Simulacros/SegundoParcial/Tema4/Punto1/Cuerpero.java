package Simulacros.SegundoParcial.Tema4.Punto1;

public class Cuerpero implements Runnable{

    private Suetereria suetereria;

    public Cuerpero(Suetereria suetereria){
        this.suetereria = suetereria;
    }

    public void run(){
        
        try{
            while(true){
                suetereria.hacerCuerpo();
                Thread.sleep(1000);
                System.out.println("El cuerpero metio un cuerpo al cesto");
                suetereria.meterCuerpoCesto();
            }
        }catch(InterruptedException e){
            System.out.println("💀");
        }
    }
    
}
