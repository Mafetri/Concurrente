package TP4.Punto4;

public class Main {
    public static void main(String[] args){
        // Ejercicio ilegal
        Cadena turno = new Cadena();
        Thread t1 = new Thread(new Letra('A', 4,turno));
        Thread t2 = new Thread(new Letra('B', 3,turno));
        Thread t3 = new Thread(new Letra('C', 5,turno));

        t1.start();
        t2.start();
        t3.start();
    }
}
