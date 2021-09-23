package TP4.Punto6;
import java.util.concurrent.*;
import java.util.*;

public class Carrera {
    private Semaphore testigo = new Semaphore(1);
    private ArrayList<String> ladoDer = new ArrayList<String>();
    private ArrayList<String> ladoIzq = new ArrayList<String>();
    private char poseedorTestigo;

    public Carrera(String[] nombres) {
        for(int i = 0; i < nombres.length/2; i++) {
            ladoIzq.add(nombres[i]);
        }
        for(int i = nombres.length/2; i < nombres.length; i++){
            ladoDer.add(nombres[i]);
        }
    }

    public void agarrar() throws InterruptedException{
        boolean corresponde = false;
        
        do{
            // Agarra el testigo, si alguien ya lo tenia, se queda esperando
            testigo.acquire();

            // Si no le correspondia el adquirir el testigo, lo suelta y loopea para volver a intentar adquirirlo
            if(!correspondeLado()){
                testigo.release();
            }else{
                // Si le correspondia, entonces rompe el loop y continua
                corresponde = true;
            }
        }while(!corresponde);

        // Ahora el poseedorTestigo actualiza el char del lado del que salió el que tiene el testigo
        poseedorTestigo = deQueLado();
        System.out.println("> El corredor " + Thread.currentThread().getName() + " me agarró el testigo de geová.");
    }

    public void soltar(){
        String nombre = Thread.currentThread().getName();
        testigo.release();
        System.out.println("> El corredor " + nombre + " me soltó el testigo de geová.");
        if(ladoIzq.remove(nombre)){
            ladoDer.add(nombre);
        }else if(ladoDer.remove(nombre)){
            ladoIzq.add(nombre);
        }
    }

    public char deQueLado(){
        if(ladoIzq.contains(Thread.currentThread().getName())){
            return 'i';
        }else{
            return 'd';
        }
    }

    // Devuelve true si el testigo esta en manos de una persona que salio del lado opuesto y falso en caso contrario
    public boolean correspondeLado(){
        boolean corresponde = false;
        // Si el lado izquierdo posee al atleta y el testigo no esta en manos de alguien del mismo lado, true
        if(ladoIzq.contains(Thread.currentThread().getName()) && poseedorTestigo != 'i'){
            corresponde = true;
        }else if(ladoDer.contains(Thread.currentThread().getName()) && poseedorTestigo != 'd'){
            corresponde = true;
        }
        return corresponde;
    }
}
