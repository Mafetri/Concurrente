package TP4.Punto6Parte2;

public class Main {
    public static void main(String[] args){
        String[] nombres = {"José", "Manuel", "Ulises", "Bruno"};
        Carrera carrera = new Carrera();
        
        Thread[] corredores = new Thread[nombres.length];
    
        for(int i = 0; i < corredores.length; i++){
            corredores[i] = new Thread(new Atleta(i, carrera), nombres[i]);
            corredores[i].start();
        }
    }
}
