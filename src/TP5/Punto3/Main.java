package TP5.Punto3;

public class Main {
    public static void main(String[] args) {
        int capacidadMax = 13;
        int cantPasajeros = capacidadMax * 3;
        Tren tren = new Tren(capacidadMax);
        Thread vendedor = new Thread(new Vendedor(tren));
        Thread control = new Thread(new ControlTren(tren));
        Thread[] pasajeros = new Thread[cantPasajeros];
        vendedor.start();
        control.start();
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Thread(new Pasajero(tren), "Pasajero" + i);
            pasajeros[i].start();
        }
    }
}
