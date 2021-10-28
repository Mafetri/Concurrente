package TP5.Punto6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int cantidadBabuinos = 13;
        Parque parque = new Parque(cantidadBabuinos);
        Thread[] babuinos = new Thread[cantidadBabuinos];

        System.out.println("En el parque hay "+ cantidadBabuinos +" de Babuinos");

        creaIniciaBabuinos(cantidadBabuinos, parque, babuinos);

        try{for(int i = 0; i < babuinos.length;i++){
            babuinos[i].join();
        }}catch(Exception e){}

        parque.parqueToString();
    }

    private static void creaIniciaBabuinos(int cantidadBabuinos, Parque parque, Thread[] babuinos) {
        for(int i = 0; i < cantidadBabuinos; i++){
            char lado = ladoRandom();
            babuinos[i] = new Thread(new Babuino(lado, parque), "Babuino " + i);
            babuinos[i].start();
        }
    }

    public static char ladoRandom(){
        //Retorna un lado random
        Random r = new Random();
        char lado = 'd';
        if(r.nextInt(2) == 0 )
            lado = 'i';

        return lado;
    }
}
