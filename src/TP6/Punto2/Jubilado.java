package TP6.Punto2;

public class Jubilado implements Runnable {

    private Museo museo;

    Jubilado(Museo m) {
        this.museo = m;
    }

    public void run() {

        try {
            System.out.println("El " + Thread.currentThread().getName() + " esta esperando a entrar");
            museo.entrarSalaJubilado();
            System.out.println("El " + Thread.currentThread().getName() + " entro en la sala");
            Thread.sleep(3000);
            System.out.println("El " + Thread.currentThread().getName() + " salio de la sala");
            museo.salirSala();
        } catch (Exception e) {
            System.out.println("Le dio án párá ál viejo");
        }

    }

}
