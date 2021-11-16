package Simulacros.SegundoParcial.Tema4.Punto2;

public class Main {
    public static void main(String[] args){
        Comedor comedor = new Comedor(5);
        Thread[] perros = new Thread[15];
        Thread en = new Thread(new Encargado(comedor), "💁🏿‍♀️💁🏿‍♀️");
        en.start();
        for(int i = 0; i < perros.length; i++){
            perros[i] = new Thread(new Perro(comedor), "Perro " + i);
            perros[i].start();
        }
    }
}
