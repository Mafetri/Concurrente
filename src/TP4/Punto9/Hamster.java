package TP4.Punto9;

import java.util.concurrent.ThreadLocalRandom;

public class Hamster implements Runnable {
    private Jaula jaula;

    public Hamster(Jaula jaula) {
        this.jaula = jaula;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            switch (randomNum) {
                case 0:
                    jaula.obtenerPlato();
                    System.out.println(Thread.currentThread().getName() + " está comiendo.");
                    dormir(1000);
                    jaula.soltarPlato();
                    System.out.println(Thread.currentThread().getName() + " dejó de comer.");
                    break;
                case 1:
                    jaula.obtenerRueda();
                    System.out.println(Thread.currentThread().getName() + " está corriendo.");
                    dormir(1000);
                    jaula.soltarRueda();
                    System.out.println(Thread.currentThread().getName() + " dejó de correr.");
                    break;
                case 2:
                    jaula.obtenerHamaca();
                    System.out.println(Thread.currentThread().getName() + " está hamacandose.");
                    dormir(1000);
                    jaula.soltarHamaca();
                    System.out.println(Thread.currentThread().getName() + " dejó de hamacarse.");
            }
        }
    }

    public void dormir(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
        }
    }
}
