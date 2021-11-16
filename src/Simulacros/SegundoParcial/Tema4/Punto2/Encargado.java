package Simulacros.SegundoParcial.Tema4.Punto2;

public class Encargado implements Runnable {

    private Comedor c;

    public Encargado(Comedor c) {
        this.c = c;
    }

    public void run() {
        try {
            while (true) {
                c.esperarDormido();
                Thread.sleep(2000);
                c.llenaPlatos();
            }
        } catch (Exception e) {
            System.out.println("El encargado murio");
        }
    }
}