package TP4.Punto4Ilegal;
import java.util.concurrent.*;

public class Letra implements Runnable {
    private char letra;
    private int cantVeces;
    private Turnos turnos;

    public Letra(char letra, int cantVeces, Turnos turnos) {
        this.letra = letra;
        this.cantVeces = cantVeces;
        this.turnos = turnos;
    }
    public void run() {
        try{
            Semaphore sem = turnos.esTurno(letra);
            for(int i = 0; i < cantVeces; i++) {
                System.out.print(this.letra);
            }
            sem.release();
        }catch(Exception e){
            System.out.println("Error en hilo " + Thread.currentThread().getName());
        }
    }
}
