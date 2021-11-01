package TP6.Punto5;

public class Puente {
    private int autosEnPuente = 0;
    private int colaSur = 0;
    private int turnoSur = 0;
    private int colaNorte = 0;
    private int colaTotalNorte = 0;
    private int colaTotalSur = 0;
    private int turnoNorte = 0;
    private int tandaActual = 0;
    private char direccionActual = 'n';

    public synchronized void entrarCocheDelNorte() throws InterruptedException {
        if(turnoSur == 0) {
            direccionActual = 'n';
        }
        System.out.println("El " + Thread.currentThread().getName() + " esta esperando en el norte");
        int turno = colaTotalNorte;
        colaTotalNorte++;
        colaNorte++;
        while (direccionActual == 's' || tandaActual >= 10 || turno != turnoNorte) {
            wait();
        }
        colaNorte--;
        turnoNorte++;
        tandaActual++;
        autosEnPuente++;
        System.out.println("El " + Thread.currentThread().getName() + " esta cruzando");
        notifyAll();
    }
    public synchronized void salirCocheDelNorte() {
        autosEnPuente--;
        if (autosEnPuente == 0 && (tandaActual >= 10 || colaNorte == 0)) {
            if (colaSur != 0) {
                System.out.println("El " + Thread.currentThread().getName() + " hizo cambiar el sentido a sur");
                direccionActual = 's';
            }
            tandaActual = 0;
            notifyAll();
        }
    }

    public synchronized void entrarCocheDelSur() throws InterruptedException {
        if(turnoNorte == 0) {
            direccionActual = 's';
        }
        System.out.println("El " + Thread.currentThread().getName() + " esta esperando en el sur");
        int turno = colaTotalSur;
        colaTotalSur++;
        colaSur++;
        while (direccionActual == 'n' || tandaActual >= 10 || turno != turnoSur) {
            wait();
        }
        colaSur--;
        turnoSur++;
        tandaActual++;
        autosEnPuente++;
        System.out.println("El " + Thread.currentThread().getName() + " esta cruzando");
        notifyAll();
    }
    
    public synchronized void salirCocheDelSur() {
        autosEnPuente--;
        if (autosEnPuente == 0 && (tandaActual >= 10 || colaSur == 0)) {
            if (colaNorte != 0) {
                System.out.println("El " + Thread.currentThread().getName() + " hizo cambiar el sentido a norte");
                direccionActual = 'n';
            }
            tandaActual = 0;
            notifyAll();
        }
    }
}
