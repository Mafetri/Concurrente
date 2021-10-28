package TP5.Punto5;
import java.util.*;

public class Cliente implements Runnable {
    Toboganes toboganes;
    public static final String verde = "\u001B[32m";
    public static final String naranja = "\u001B[33m";
    public static final String reset = "\u001B[0m";

    public Cliente(Toboganes toboganes) {
        this.toboganes = toboganes;
    }

    public void run() {
        try {
            // Espera que lo atiendan
            System.out.println(Thread.currentThread().getName() + " está esperando que lo atiendan.");
            toboganes.solicitarBajar();

            // Espera mientras le asignan un tobogan y se tira por ese
            System.out.println(Thread.currentThread().getName() + " está esperando que le asignen un tobogan.");
            int toboganUsado = toboganes.bajar();
            System.out.println(naranja + Thread.currentThread().getName() + " está usando el tobogan " + toboganUsado + reset);

            // Simula el tiempo que tarda en bajar
            int tiempo = sleepAleatorio();

            // Una vez abajo, se baja del tobogan usado
            System.out.println(verde + Thread.currentThread().getName() + " dejó de usar el tobogan " + toboganUsado + " despues de " + tiempo + "ms"+ reset);
            toboganes.salirTobogan(toboganUsado);
           
        } catch (Exception e) {
            System.out.println(e + ". El cliente " + Thread.currentThread().getName() + " tuvo un percance.");
        }
    }
    
    private int sleepAleatorio() throws Exception{
        Random rand = new Random();
        int tiempo = rand.nextInt(4000 - 3000 + 1) + 3000;
        Thread.sleep(tiempo);
        return tiempo;
    }
}
