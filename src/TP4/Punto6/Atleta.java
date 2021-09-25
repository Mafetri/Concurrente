package TP4.Punto6;

import java.util.Random;

public class Atleta implements Runnable {
    private Carrera carrera;
    private char lado;

    Atleta(Carrera c, char l) {
        this.carrera = c;
        this.lado = l;
    }

    public void run() {
        Random r = new Random();
        try {
            carrera.correr(lado);
            long ini = System.currentTimeMillis();
            Thread.sleep((r.nextInt(3) + 9) * 1000);
            carrera.terminar(lado);
            long fin = System.currentTimeMillis();
            System.out.println(
                    "El corredor " + Thread.currentThread().getName() + " finalizo en un tiempo de " + (fin - ini));
        } catch (Exception e) {
        }
    }
}