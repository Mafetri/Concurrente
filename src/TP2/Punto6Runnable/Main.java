package TP2.Punto6Runnable;

public class Main {
    public static void main(String[] args){
        Cliente c1 = new Cliente("José", new int[]{2,2,1,5,2,3});
        Cliente c2 = new Cliente("Maria", new int[]{1,3,5,1,1});

        long initialTime = System.currentTimeMillis();

        Thread t1 = new Thread(new Cajero("Cajero 1", initialTime, c1), "Cajero 1");
        Thread t2 = new Thread(new Cajero("Cajero 2", initialTime, c2), "Cajero 2");
        
        t1.start();
        t2.start();

        try{t1.join();t2.join();}catch(Exception e){}

        System.out.println("Tiempo final: " + ((System.currentTimeMillis() - initialTime)) + "ms.");
    }
}
