package TP6.Punto2;

import java.util.Random;

public class Termometro implements Runnable {
    Museo museo;

    public Termometro(Museo museo) {
        this.museo = museo;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                museo.notificarTemp(tempMedida());
            }
        } catch (Exception e) {
            System.out.println("Se rompio del termometro");
        }

    }

    public int tempMedida() {
        Random r = new Random();
        return r.nextInt(35) + 25;
    }
}
