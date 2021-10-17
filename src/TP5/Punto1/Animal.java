package TP5.Punto1;

public class Animal implements Runnable{
    char tipo;
    Comedor comedor;
    public static final String verde = "\u001B[32m";
    public static final String naranja = "\u001B[33m";
    public static final String reset = "\u001B[0m";
    
    public Animal(char tipo, Comedor comedor){
        this.tipo = tipo;
        this.comedor = comedor;
    }

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + " está esperando para comer.");
            comedor.comer(tipo);
            System.out.println(verde+Thread.currentThread().getName() + " está comiendo."+reset);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " terminó de comer.");
            comedor.dejarDeComer(tipo);
        }catch(Exception e){}
    }
}