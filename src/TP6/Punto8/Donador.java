package TP6.Punto8;

public class Donador implements Runnable{
    public Centro c;
    public Donador(Centro c){
        this.c = c;
    }
    public void run(){
        try{
            System.out.println("El " + Thread.currentThread().getName() + " llegó al centro.");
            c.entrarSala();
            System.out.println("El " + Thread.currentThread().getName() + " se está sacando sangre. 🩸🩸");
            Thread.sleep(5000);
            c.irse();
        }catch(Exception e){}
    }
}
