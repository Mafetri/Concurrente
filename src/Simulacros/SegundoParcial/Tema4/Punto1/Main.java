package Simulacros.SegundoParcial.Tema4.Punto1;

public class Main {
    public static void main(String[] args){
        Suetereria s = new Suetereria(10, 5, 10);
        Thread m = new Thread(new Manguero(s), "Manguero 1");
        Thread c = new Thread(new Cuerpero(s), "Cuerpero 1");
        Thread e = new Thread(new Ensamblador(s), "Ensamblador 1");
        m.start();
        c.start();
        e.start();
    }
}
