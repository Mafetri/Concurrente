package TP4.Punto9;

public class Main {
    public static void main(String[] args){
        Jaula jaula = new Jaula();
        int cantHamseters = 50;
        Thread[] hamsters = new Thread[cantHamseters];
        for(int i=0; i<hamsters.length; i++){
            hamsters[i] = new Thread(new Hamster(jaula), "Hamster "+i);
            hamsters[i].start();
        }
    }   
}
