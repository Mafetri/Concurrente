package TP6.Punto4;

public class Main {
    public static void main(String[] args){
        int mostradorA = 5, mostradorP = 3, abridores = 10;
        Cuartel c = new Cuartel(mostradorA, mostradorP, abridores);
        Thread[] soldados = new Thread[100];
        for(int i = 0; i < soldados.length; i++){
            soldados[i] = new Thread(new Soldado(c), "Soldado " + i);
            soldados[i].start();
        }
    }
}
