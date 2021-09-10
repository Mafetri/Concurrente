package TP3.Punto4;
import java.util.concurrent.ThreadLocalRandom;

public class Hamster implements Runnable {
    private Jaula jaula;

    public Hamster(Jaula jaula) {
        this.jaula = jaula;
    }

    public void run(){
        for(int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            switch(randomNum) {
                case 0: if(jaula.getPlato() == null){jaula.setPlato(this);dormir(1000);jaula.setPlato(null);};break;
                case 1: if(jaula.getRueda() == null){jaula.setRueda(this);dormir(1000);jaula.setRueda(null);}break;
                case 2:if(jaula.getHamaca() == null){jaula.setHamaca(this);dormir(3000);jaula.setHamaca(null);}
            }
        }
    }
    public void dormir(int i){
        try{Thread.sleep(i);}catch(InterruptedException e){}
    }
}
