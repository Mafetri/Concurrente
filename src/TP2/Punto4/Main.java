package TP2.Punto4;

public class Main {
    public static void main(String[] args){
        // Declaro y creo dos hilos con los RunnableEjemplo y con su respectivo nombre de hilo
        Thread t1 = new Thread(new RunnableEjemplo(), "José");
        Thread t2 = new Thread(new RunnableEjemplo(), "Maria");

        // Inicio los threads
        t1.start(); t2.start();

        // Hago esperar al main hasta que terminen los threads
        try{t1.join();t2.join();}catch (InterruptedException e){}

        System.out.println("Termina el main.");
    }
}
