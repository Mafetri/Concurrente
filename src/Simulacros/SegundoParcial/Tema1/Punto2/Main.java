package Simulacros.SegundoParcial.Tema1.Punto2;

public class Main {
    public static void main(String[] args){
        Ferry f = new Ferry();
        Thread[] autos = new Thread[100];
        Thread control = new Thread(new ControlFerry(f));
        control.start();
        for(int i = 0; i < autos.length; i++){
            autos[i] = new Thread(new Auto(f), "Auto " + i);
            autos[i].start();
        }
    }
}
