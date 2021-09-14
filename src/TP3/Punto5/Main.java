package TP3.Punto5;

public class Main {
    public static void main(String[] args){
        Impresora impresora = new Impresora();
        Thread t1 = new Thread(new Letra(impresora), "A");
        Thread t2 = new Thread(new Letra(impresora), "B");
        Thread t3 = new Thread(new Letra(impresora), "C");

        t1.start();
        t2.start();
        t3.start();
    }
}
