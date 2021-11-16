package ActividadesObligatorias.ActividadObligatoria3.Punto1;

public class Carpintero implements Runnable {
    private Carpinteria c;
    private int tipo;
    private int id;

    public Carpintero(Carpinteria c, int tipo, int id) {
        this.c = c;
        this.tipo = tipo;
        this.id = id;
    }

    public void run() {
        try {
            while (!c.fabricar(tipo, id)) {
                System.out.println(Thread.currentThread().getName() + " está fabricando. 🎄🌳🌲🪓");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " entrega su producto. 🎄🌳🌲🪓");
                c.entregar(tipo, id);
                System.out.println(Thread.currentThread().getName() + " vuelve al trabajo. 😔😥");
            }
            System.out.println(Thread.currentThread().getName() + " finde largo paaaa!! 🏃‍♂️🏃‍♂️🏃‍♂️");
        } catch (Exception e) {
            System.out.println(e.toString() + Thread.currentThread().getName() + " se fue a la casita. 🏠🏠");
        }
    }
}
