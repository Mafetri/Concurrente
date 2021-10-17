package Triñanes_2738.Ejercicio6b;

import java.util.concurrent.locks.*;

public class Carrera {
    private Lock testigo = new ReentrantLock();
    private boolean[] posicion;

    public Carrera(int cant) {
        posicion = new boolean[cant];
        posicion[0] = true;
        for (int i = 1; i < cant; i++) {
            posicion[i] = false;
        }
    }

    public boolean correr(int pos) {
        boolean exito = false;

        // El hilo corredor trata de agarrar el testigo
        if (testigo.tryLock()) {
            // Si no era su turno de correr, entonces lo suelta, sino corre
            if (posicion[pos] == true) {
                exito = true;
            } else {
                testigo.unlock();
            }
        }
        return exito;
    }

    public void soltarTestigo(int pos) {
        // Al soltar al testigo le permite a la siguiente posicion que pueda correr
        if (pos < posicion.length - 1) {
            posicion[pos + 1] = true;
            testigo.unlock();
        }
    }
}
