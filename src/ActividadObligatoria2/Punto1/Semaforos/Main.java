package ActividadObligatoria2.Punto1.Semaforos;

public class Main {
    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        int z = 4;

        Compartido c = new Compartido();
        Thread t1 = new Thread(new Hilo(c, x, y, z, 1));
        Thread t2 = new Thread(new Hilo(c, x, y, z, 2));
        t1.start();
        t2.start();
        try {
            c.s3();
        } catch (Exception e) {
        }
        System.out.println(c.s4());
    }
}
