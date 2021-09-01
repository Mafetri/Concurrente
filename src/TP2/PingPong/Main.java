package TP2.PingPong;

public class Main {
    public static void main(String[] args) {
        PingPong t1 = new PingPong("PING", 100);
        PingPong t2 = new PingPong("PONG", 300);

        // Activación
        t1.start();
        t2.start();

        // Espera unos segundos
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
        }

        System.out.println("hola");
    }
}
