package TP5.Punto4;
import java.util.Random;

public class Avion implements Runnable{
    private Pista pista;
    public static final String verde = "\u001B[32m";
    public static final String naranja = "\u001B[33m";
    public static final String reset = "\u001B[0m";
    
    public Avion(Pista pista){
        this.pista = pista;
    }
    public void run(){
        String nombre = Thread.currentThread().getName();
        int accion = rand();
        try{
            System.out.println(nombre+" se comunica con la torre.");
            pista.comunicarTorre();
            switch(accion){
                case 0: System.out.println(nombre+" espera para aterrizar."); pista.solicitarAterrizaje(); break;
                case 1: System.out.println(nombre+" espera para despegar"); pista.solicitarDespegue();
            }
            if(accion == 0){
                System.out.println(verde+nombre+" está aterrizando"+reset);
            }else{
                System.out.println(naranja+nombre+" está despegando"+reset);
            }
            Thread.sleep(1000);
            System.out.println(nombre+" libera pista");
            pista.liberarPista();
            
        }catch(Exception e){System.out.println("Mayday Mayday");}
    }

    public int rand(){
        Random r = new Random();
        return r.nextInt(2);
    }
}
