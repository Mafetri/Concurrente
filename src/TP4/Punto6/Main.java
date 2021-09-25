package TP4.Punto6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cantCorredores = 4;
        Carrera carrera = new Carrera();
        Thread[] corredores = new Thread[cantCorredores];

        // Todo esto para que Vale este feliz con el arreglo shuffleado
        char[] lado = new char[cantCorredores];
        for (int i = 0; i < lado.length; i++) {
            if (i % 2 == 0) {
                lado[i] = 'i';
            } else {
                lado[i] = 'd';
            }
        }
        shuffleArray(lado);

        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new Thread(new Atleta(carrera, lado[i]), "Corredor " + i);
            corredores[i].start();
        }
    }

    static void shuffleArray(char[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
