package Simulacros.SegundoParcial.Tema2.Punto2;

public class Main {
    public static void main(String[] args){
        Espacio espacio = new Espacio();
        int cantOxigeno = 20;
        int cantidadAtomos = cantOxigeno * 3;
        Thread[] atomos = new Thread[cantidadAtomos];
        for(int i=0; i<cantidadAtomos/3; i++){
            atomos[i] = new Thread(new Atomo(espacio, 'O'), "Atomo O:"+i);
            atomos[i].start();
        }
        for(int i= cantidadAtomos/3; i<cantidadAtomos; i++){
            atomos[i] = new Thread(new Atomo(espacio, 'H'), "Atomo H:"+i);
            atomos[i].start();
        }
    }
}
