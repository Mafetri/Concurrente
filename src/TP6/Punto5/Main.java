package TP6.Punto5;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        Puente p = new Puente();
        Thread[] autos = new Thread[30];
        
        for(int i = 0; i < autos.length; i++){
            autos[i] = new Thread(new Auto(direccionRandom(),p), "Auto " + i);
            autos[i].start();
        }    
        

    }
    public static char direccionRandom(){
        Random rand = new Random();
        switch(rand.nextInt(2)){
            case 0: return 'n';
            default: return 's';
        }
    }
}
