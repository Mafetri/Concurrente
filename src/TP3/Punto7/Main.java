package TP3.Punto7;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        SumaTotal suma = new SumaTotal();
        int sumaTotal = 0;
        int[] arreglo = new int[50000];

        Random rand = new Random();
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = rand.nextInt((10 - 0) + 1) + 0;
            sumaTotal += arreglo[i];
        }

        Thread t1 = new Thread(new Contador(arreglo, suma, 0, 12500), "Contador 1");
        Thread t2 = new Thread(new Contador(arreglo, suma, 12500, 25000), "Contador 2");
        Thread t3 = new Thread(new Contador(arreglo, suma, 25000, 37500), "Contador 3");
        Thread t4 = new Thread(new Contador(arreglo, suma, 37500, 50000), "Contador 4");

        t1.start(); t2.start(); t3.start(); t4.start();

        try{t1.join();t2.join();t3.join();t4.join();}catch(InterruptedException e){}

        // Suma total de los hilos
        System.out.println(suma.getTotal());

        // Suma de referencia del main
        System.out.println(sumaTotal);
    }
}
