package TP5.Punto4;

public class Main {
    public static void main(String[] args){
        Pista pista = new Pista();
        Thread torre = new Thread(new Torre(pista));
        torre.start();
        Thread[] aviones = new Thread[9];
        for(int i =0; i < aviones.length; i++){
            aviones[i] = new Thread(new Avion(pista), "Avion " + i);
            aviones[i].start();
        }
    }
}
