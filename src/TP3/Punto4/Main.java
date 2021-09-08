package TP3.Punto4;

public class Main {
    public static void main(String[] args){
        Jaula jaula = new Jaula();
        Thread t1 = new Thread(new Hamster(jaula), "Tuti");
        Thread t2 = new Thread(new Hamster(jaula), "José");
        Thread t3 = new Thread(new Hamster(jaula), "María");
        
        System.out.println("======= Inicia la vida ======");
        t1.start();
        t2.start();
        t3.start();
        try{t1.join(); t2.join(); t3.join();}catch(Exception e){}
        System.out.println("======= FIN =======");
    }   
}
