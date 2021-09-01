package TP2.PingPong;

public class PingPong extends Thread {
    private String cadena; // Lo que va a escribir.
    private int delay; // Tiempo entre escritura

    public PingPong(String cartel, int cantMs) {
        cadena = cartel;
        delay = cantMs;
    }

    public void run(){
        for (int i = 1; i < 10; i++){
            System.out.print(cadena + " ");
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
        
            }
        }
        
    }
} 
