package TP2.Punto6Lineal;

public class Main {
    public static void main(String[] args){
        Cliente c1 = new Cliente("José", new int[]{2,2,1,5,2,3});
        Cliente c2 = new Cliente("Maria", new int[]{1,3,5,1,1});
        Cajero cajero1 = new Cajero("Cajero 1");

        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(c1, initialTime);
        cajero1.procesarCompra(c2, initialTime);
        
    }
}
