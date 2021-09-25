package TP4.Punto6Parte2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cantCorredores = 10;
        Carrera carrera = new Carrera(cantCorredores);
        Thread[] corredores = new Thread[cantCorredores];

        // Todo esto para que Vale este feliz con el arreglo shuffleado
        int[] posicion = new int[cantCorredores];
        for (int i = 0; i < posicion.length; i++) {
            posicion[i] = i;
        }
        shuffleArray(posicion);
        for (int i = 0; i < posicion.length; i++) {
            System.out.print(posicion[i]);
        }

        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new Thread(new Atleta(posicion[i], carrera), "Corredor " + i);
            corredores[i].start();
        }
    }

    static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
