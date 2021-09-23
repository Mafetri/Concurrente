package TP4.Punto6;
import java.util.Random;

public class Atleta implements Runnable{
    private Carrera carrera;
    private boolean primero;

    Atleta(Carrera c , boolean primero){
        this.carrera = c;
        this.primero = primero;
    }

    public void run() {
        Random r = new Random();
        synchronized(Atleta.class){
            if(primero){
                correr();
            }
        }
        if(!primero){
            correr();
        }
        
    }

    
    public void correr(){
        Random r = new Random();
        
        try{
            carrera.agarrar();
            long ini = System.currentTimeMillis();
            Thread.sleep((r.nextInt(3) + 9)*100);

            carrera.soltar();
            long fin = System.currentTimeMillis();

            System.out.println("El corredor "+Thread.currentThread().getName()+" finalizo en un tiempo de "+ (fin - ini));
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + " se le atrancó el pati");
        }
    }


}