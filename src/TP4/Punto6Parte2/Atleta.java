package TP4.Punto6Parte2;

import java.util.Random;

public class Atleta implements Runnable{
    private int pos;
    private Carrera carrera;
    
    public Atleta(int pos, Carrera carrera){
        this.pos = pos;
        this.carrera = carrera;
    }
    
    public void run(){
        Random r = new Random();
        
        try{
            carrera.correr(this.pos);
            long ini = System.currentTimeMillis();
            Thread.sleep((r.nextInt(3) + 9)*100);
            long total = System.currentTimeMillis() - ini;
            carrera.soltar();
            System.out.println("El corredor " + Thread.currentThread().getName() + " tardó " + total + "ms.");
        }catch(InterruptedException e){}
    }
}