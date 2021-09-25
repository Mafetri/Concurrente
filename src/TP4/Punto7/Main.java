package TP4.Punto7;

public class Main {
    public static void main(String[] args){
        Taxi taxi = new Taxi();
        Thread taxista = new Thread(new Taxista(taxi));
        Thread[] pasajeros = new Thread[6];

        taxista.start();
        for(int i = 0; i < pasajeros.length; i++){
            pasajeros[i] = new Thread(new Pasajero(taxi), "Pasajero " + i);
            pasajeros[i].start();
        }

    }
}
