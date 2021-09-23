package TP4.Punto6Parte2;
import java.util.concurrent.*;

public class Carrera {
    private Semaphore testigo = new Semaphore(1);
    private int posSiguienteTestigo = 0;

    public void correr(int posActual) throws InterruptedException {
        do{
            testigo.acquire();
            if(posSiguienteTestigo != posActual){
                testigo.release();
            }
        }while(posSiguienteTestigo != posActual);
        System.out.println(Thread.currentThread().getName() + " agarró");
    }

    public void soltar(){
        testigo.release();
        posSiguienteTestigo++;
    }
}
