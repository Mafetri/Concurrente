package TP1;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Punto8 {
    public static void main(String[] args){
        // A)
        try{
            verificarEdad(19);
            System.out.println("Es mayor");
        }catch(Exception e){
            e.printStackTrace();
        }

        // B)
        try{
            ruleta(2);
            System.out.println("Numero ganador.");
        }catch(Exception e){
            e.printStackTrace();
        }

        // C)
        try{
            deMas();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    public static void verificarEdad(int edad) throws Exception {
        if(edad < 18){
            throw new Exception("Es menor de edad");
        }
    }
    public static void ruleta(int num) throws Exception{
        if(ThreadLocalRandom.current().nextInt(0, 3) != num){
            throw new Exception("No ganó.");
        }
    }
    public static void deMas() throws ArrayIndexOutOfBoundsException{
        int[] arreglo = new int[5];
        arreglo[0] = 1;
        arreglo[1] = 2;
        arreglo[2] = 3;
        arreglo[3] = 4;
        arreglo[4] = 5;

        try{
            for(int i = 0; i < 7; i++){
                System.out.print(arreglo[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("Se fue de mano");
        }
    }
}
