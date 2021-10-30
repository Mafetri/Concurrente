package TP6.Punto1;
import java.util.Random;

public class Agente implements Runnable{
    private SalaFumadores sala;
    private Random r;

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    public void run() {
        while (true) {
            try{sala.colocar(r.nextInt(3) + 1);}catch(Exception e){}
        }
    }
}
