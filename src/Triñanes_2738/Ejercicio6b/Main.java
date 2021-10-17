package Triñanes_2738.Ejercicio6b;

public class Main {
    public static void main(String[] args){
        int cantCorredores = 5;
        Carrera carrera = new Carrera(cantCorredores);
        Thread[] corredores = new Thread[cantCorredores];

        for(int i=0; i<cantCorredores; i++){
            corredores[i] = new Thread(new Corredor(carrera, i), "Corredor " + i);
            corredores[i].start();
        }
    }

}
