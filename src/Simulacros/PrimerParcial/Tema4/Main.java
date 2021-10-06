package Simulacros.PrimerParcial.Tema4;

public class Main {
    public static void main(String[] args){
        Tren tren = new Tren(5);
        Thread ctrl = new Thread(new ControlTren(tren));
        Thread vendedor = new Thread(new Vendedor(tren));
        Thread[] hilos = new Thread[10];
        for(int i = 0; i < hilos.length; i++){
            hilos[i] = new Thread(new Pasajero(tren), "Pasajero " + i);
            hilos[i].start();
        }
        vendedor.start();
        ctrl.start();
    }
}
