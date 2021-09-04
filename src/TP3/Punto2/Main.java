package TP3.Punto2;

public class Main {
    public static void main(String[] args){
        Heroe h1 = new Heroe();

        Thread t1 = new Thread(new Bot(h1), "Curandero");
        Thread t2 = new Thread(new Bot(h1), "Orco");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){

        }

        if(h1.getVida() > 0){
            System.out.println(" ==== Los curanderos ganan :) ==== ");
        }else{
            System.out.println(" ==== Los orcos ganan :( ==== ");
        }
    }
}
