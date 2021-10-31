package TP6.Punto4;
import java.util.Random;

public class Soldado implements Runnable{
    private Cuartel c;
    private boolean gaseosa;
    private boolean postre;

    Soldado(Cuartel c){
        this.c = c;
        this.gaseosa = random();
        this.postre = random();
    }

    public void run(){
        String nombre = Thread.currentThread().getName();
            try{
            System.out.println("El "+nombre+ " entra al comedor.");
            c.mostradorAlmuerzo(gaseosa);
            Thread.sleep(500);
            c.dejarMostradorAlmuerzo(gaseosa);
            System.out.println("El "+nombre+ " acaba de comer.");
            if(postre){
                System.out.println("El "+nombre+ " espera para el postre.");
                c.mostradorPostre();
                Thread.sleep(500);
                System.out.println("El "+nombre+ " comió el postre. 🤑");
                c.dejarMostradorPostre();
            }
            
        }catch(Exception e){}
    }
    
    public boolean random(){
        Random r = new Random();
        switch(r.nextInt(2)){
            case 0: return true;
            default: return false;
        }
    }
}