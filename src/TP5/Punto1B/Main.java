package TP5.Punto1B;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int cantPlatos = 2, cantAnimales = 20, permisos = 3;

        Comedor comedor = new Comedor(cantPlatos, permisos);
        Thread[] animales = new Thread[cantAnimales];

        for(int i = 0; i < cantAnimales; i++){
            char tipo = random();
            animales[i] = new Thread(new Animal(tipo, comedor), "Animal tipo " + tipo+i);
            animales[i].start();
        }
    }
    
    public static char random(){
        Random r = new Random();
        int caracter;
        caracter = r.nextInt(2);
        if(caracter == 0){
            return 'g';
        }else{
            return 'p';
        }
    }
}
