package TP6.Punto7;

public class Main {
    public static void main(String[] args){
        Pasteleria p = new Pasteleria(50, 10, 5, 10, 15);
        Thread[] hornos = new Thread[3];
        Thread[] empaquetador = new Thread[2];
        Thread brazo = new Thread(new Brazo(p), "Brazo 1");

        brazo.start();
        for(int i = 0; i < hornos.length; i++){
            hornos[i] = new Thread(new Horno(p,(char)(97+i)), "Horno " + i);
            hornos[i].start();
        }

        for(int i = 0; i < empaquetador.length; i++){
            empaquetador[i] = new Thread(new Empaquetador(p), "Empaquetador " + i);
            empaquetador[i].start();
        }
    }
    
}
