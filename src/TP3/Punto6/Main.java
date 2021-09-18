package TP3.Punto6;

public class Main {
    public static void main(String[] args){
        Gasolinera estacion = new Gasolinera();
        Thread t1 = new Thread(new Auto(10, "AB12", "Fiorino", "Fiat", estacion, 100), "Auto 1");
        Thread t2 = new Thread(new Auto(10, "AB13", "Fiorino", "Fiat", estacion, 100), "Auto 2");
        Thread t3 = new Thread(new Auto(10, "AB14", "Fiorino", "Fiat", estacion, 100), "Auto 3");
        Thread t4 = new Thread(new Auto(10, "AB15", "Fiorino", "Fiat", estacion, 100), "Auto 4");
        Thread t5 = new Thread(new Auto(10, "AB16", "Fiorino", "Fiat", estacion, 100), "Auto 5");
        Thread t6 = new Thread(new Auto(10, "AB17", "Fiorino", "Fiat", estacion, 100), "Auto 6");

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start();
    }
}