package TP3.Punto4;
import java.util.Random;

public class Hamster implements Runnable {
    private Jaula jaula;

    public Hamster(Jaula jaula) {
        this.jaula = jaula;
    }

    public void run(){
        for(int i = 0; i < 5; i++) {
            int randomNum = new Random().nextInt((3 - 0) + 1) + 0;
            switch(randomNum) {
                case 0: jaula.setPlato(this); break;
                case 1: jaula.setHamaca(this); break;
                case 2: jaula.setRueda(this);
            }
        }
    }
}
