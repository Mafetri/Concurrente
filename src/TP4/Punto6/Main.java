package TP4.Punto6;

public class Main {
    public static void main(String[] args){
        String[] nombres = {"Jose", "Manuel", "Ulises", "Bruno puto"};
        Carrera carrera = new Carrera(nombres);
        
        Thread[] corredores = new Thread[nombres.length];
        corredores[0] = new Thread(new Atleta(carrera, true), nombres[0]);
        corredores[0].start();

        for(int i = 1; i < corredores.length; i++){
            corredores[i] = new Thread(new Atleta(carrera, false), nombres[i]);
            corredores[i].start();
        }
    }
}
