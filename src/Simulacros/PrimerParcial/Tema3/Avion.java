package Simulacros.PrimerParcial.Tema3;

import java.util.*;

public class Avion implements Runnable {
    private Pista pista;
    public static final String verde = "\u001B[32m";
    public static final String rojo = "\u001B[33m";
    public static final String reset = "\u001B[0m";

    public Avion(Pista pista) {
        this.pista = pista;
    }

    public void run() {
        switch (accionRandom()) {
            case 1:
                despegar();
                break;
            case 2:
                aterrizar();
                break;
        }
    }

    private void despegar() {
        try {
            System.out.println(rojo+"El avion " + Thread.currentThread().getName() + " esta esperando para despegar."+reset);
            pista.solicitarDespegue();
            System.out.println(rojo+"El avion " + Thread.currentThread().getName() + " esta despegando."+reset);
            Thread.sleep(3000);
            pista.liberarPista();
            System.out.println(rojo+"El avion " + Thread.currentThread().getName() + " liberó el eje de pista."+reset);
        } catch (Exception e) {
        }

    }

    private void aterrizar() {
        try {
            System.out.println(verde+"El avion " + Thread.currentThread().getName() + " esta en cola para aterrizar."+reset);
            pista.solicitarAterrizaje();
            System.out.println(verde+"El avion " + Thread.currentThread().getName() + " esta aterrizando."+reset);
            Thread.sleep(3000);
            pista.liberarPista();
            System.out.println(verde+"El avion " + Thread.currentThread().getName() + " liberó pista."+reset);
        } catch (Exception e) {
        }
    }

    private int accionRandom() {
        Random ran = new Random();
        return ran.nextInt(2)+1;
    }
}
