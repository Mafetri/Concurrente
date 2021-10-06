package Simulacros.PrimerParcial.Tema3;

public class Main {
    public static void main(String[] args){
        Pista pista = new Pista();
        Thread torre = new Thread(new TorreControl(pista));
        Thread[] aviones = new Thread[10];

        // Inicio de hilos
        torre.start();
        for(int i = 0; i < aviones.length; i++){
            aviones[i] = new Thread(new Avion(pista), "Avion " + i);
            aviones[i].start();
        }
    }
}
