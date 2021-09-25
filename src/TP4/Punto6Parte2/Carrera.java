package TP4.Punto6Parte2;
import java.util.concurrent.*;

public class Carrera {
    int cantCorredores;
    private Semaphore[] testigo;
    private int posSiguienteTestigo = 0;

    public Carrera(int cantCorredores) {
        testigo = new Semaphore[cantCorredores];
        testigo[0] = new Semaphore(1);
        for(int i = 1; i <testigo.length; i++) {
            testigo[i] = new Semaphore(0);
        }
    }

    public void correr(int posActual) throws InterruptedException {
        testigo[posActual].acquire();
        System.out.println("-> " + Thread.currentThread().getName() + " agarró el testigo.");
    }

    public void soltar(){
        posSiguienteTestigo++;
        if(posSiguienteTestigo < testigo.length){
            testigo[posSiguienteTestigo].release();
            System.out.println(Thread.currentThread().getName() + " solto el testigo.");
        }else{
            System.out.println("Terminó la carrera");
        }
        
        
    }
}
