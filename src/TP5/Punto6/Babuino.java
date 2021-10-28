package TP5.Punto6;

public class Babuino implements Runnable {

    private char lado;          //Se usa para saber de que lado del cañon empieza
    private Parque parque;

    Babuino(char l, Parque p) {
        this.lado = l;
        this.parque = p;
    }

    public void run() {
         String nombre = Thread.currentThread().getName();

        try {
            empiezaCruzar(nombre);
            cruzandoCuerda(nombre);
            terminaCruzar(nombre);
        } catch (InterruptedException e) {
            System.out.println("Se rompio la cuerda, chau monito");
        }
    }

    private void empiezaCruzar(String nombre) throws InterruptedException {
        //Hace cosas de babuino mientras espera a que se desocupe la cuerda
        System.out.println("El " + nombre + " esta esperando a cruzar la cuerda, mientras come fruta en el lado " + this.lado);

        //Si esta libre la cuerda entonces cruza
        this.parque.cruzarCuerda(this.lado);
    }

    private void cruzandoCuerda(String nombre) throws InterruptedException {
        System.out.println("El babuino " + nombre +this.lado+ " esta cruzando la cuerda.");
        //Simula el cruze de la cuerda
        Thread.sleep(2000);
    }

    private void terminaCruzar(String nombre) throws InterruptedException{
        //Termina de cruzar la cuerda, libera y se va a hacer cosas de babuinos
        System.out.println("El babuino " + nombre + this.lado +" termino de cruzar la cuerda");
        this.parque.soltarCuerda(this.lado);
    }
}
