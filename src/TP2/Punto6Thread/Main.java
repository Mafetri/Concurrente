package TP2.Punto6Thread;

public class Main {
    public static void main(String[] args){
        Cliente c1 = new Cliente("José", new int[]{2,2,1,5,2,3});
        Cliente c2 = new Cliente("Maria", new int[]{1,3,5,1,1});

        long initialTime = System.currentTimeMillis();

        Cajero cajero1 = new Cajero("Cajero 1", initialTime, c1);
        Cajero cajero2 = new Cajero("Cajero 2", initialTime, c2);

        cajero1.start();
        cajero2.start();
        
        try{cajero1.join();cajero2.join();}catch(Exception e){}

        System.out.println("Tiempo final: " + ((System.currentTimeMillis() - initialTime)/1000) + "seg.");
    }
}
