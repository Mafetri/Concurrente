package Simulacros.PrimerParcial.Tema2;

import java.util.Random;

public class Recepcionista implements Runnable {
    private CentroMedico cm;
    public static final String color = "\u001B[36m";
    public static final String reset = "\u001B[0m";

    public Recepcionista(CentroMedico cm) {
        this.cm = cm;
    }

    public void run() {
        Random r = new Random();

        while (true) {
            try {
                System.out.println("La recepcionista esta procesando y almacenado en sangre en heladeras");
                cm.esperarLlamado();
                System.out.println("La esta atendiendo.");
                Thread.sleep(1000 * r.nextInt(3));
                System.out.println(color+"Corta la llamada"+reset);
                cm.cortarLlamada();
            } catch (Exception e) {}
        }
    }

}
