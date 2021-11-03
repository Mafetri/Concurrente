package TP6.Punto8;

public class Main {

    public static void main(String[] args) {
        int revistas = 9, camillas = 4;
        Centro c = new Centro(revistas, camillas);
        Thread[] donantes = new Thread[20];

        for (int i = 0; i < donantes.length; i++) {
            donantes[i] = new Thread(new Donador(c), "Donante " + i);
            donantes[i].start();
        }
    }

}
