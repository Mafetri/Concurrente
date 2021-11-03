package TP6.Punto8;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Centro {
    private int revistas;
    private int camillas;

    public Centro (int revistas, int camillas){
        this.revistas = revistas;
        this.camillas = camillas;
    }

    public synchronized void entrarSala() throws InterruptedException{
        boolean tieneRevista = false;
        while(camillas <= 0){
            if(!tieneRevista && revistas > 0){
                tieneRevista = true;
                revistas--;
                System.out.println("El " + Thread.currentThread().getName() + " agarró una revista. 📰📰");
            }else if(!tieneRevista){
                System.out.println("El " + Thread.currentThread().getName() + " esta mirando tele. 📺📺");
            }
            wait();
        }
        if(tieneRevista){
            revistas++;
        }
        camillas--;
    }

    public synchronized void irse(){
        camillas++;
        System.out.println("El " + Thread.currentThread().getName() + " liberó una camilla. 🛏️🛏️");
        notifyAll();
    }
}
