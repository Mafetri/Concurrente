package TP2.Punto4;

public class RunnableEjemplo implements Runnable {

    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termino el thread: " + Thread.currentThread().getName());
    }
}
