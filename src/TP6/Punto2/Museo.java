package TP6.Punto2;

public class Museo {
    int temp = 29;
    int tUmbral = 30;
    int capacidadMaxima = 50;
    int cantidadActual = 0;
    int filaJubilados = 0;

    public synchronized void entrarSala() throws InterruptedException {
        while (cantidadActual >= capacidadMaxima || filaJubilados > 0) {
            wait();
        }
        cantidadActual++;
        System.out.println("=========>" + cantidadActual + "<=========");
    }

    public synchronized void entrarSalaJubilado() throws InterruptedException {
        filaJubilados++;
        while (cantidadActual >= capacidadMaxima) {
            wait();
        }
        filaJubilados--;
        cantidadActual++;
        System.out.println("=========>" + cantidadActual + "<=========");
    }

    public synchronized void salirSala() {
        cantidadActual--;
        if (cantidadActual < capacidadMaxima) {
            notifyAll();
        }
    }

    public synchronized void notificarTemp(int temperatura) {
        temp = temperatura;
        if (temp >= tUmbral) {
            System.out.println("La capacidad maxima es de 35.");
            capacidadMaxima = 35;
        } else {
            System.out.println("La capacidad maxima es de 50.");
            capacidadMaxima = 50;
        }
    }
}
