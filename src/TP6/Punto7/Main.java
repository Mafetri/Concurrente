package TP6.Punto7;

public class Main {
    public static void main(String[] args){
        int pesoMax = 35;
        int cantEmpaquetadores = 2;
        int tamMostrador = 10;
        int pesoA = 5;
        int pesoB = 10;
        int pesoC = 15;
        Pasteleria p = new Pasteleria(pesoMax, tamMostrador, pesoA, pesoB, pesoC, cantEmpaquetadores);
        Thread[] hornos = new Thread[3];
        Thread[] empaquetador = new Thread[cantEmpaquetadores];
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
