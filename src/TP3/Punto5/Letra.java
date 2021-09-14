package TP3.Punto5;

public class Letra implements Runnable{
    private Impresora impresora;

    public Letra(Impresora impresora){
        this.impresora = impresora;
    }

    public void run() {
        // Bucle infinito
        do{
            // Si es su tuno de imprimir, imprime, sino, el hilo duerme 30ms
            // para dejar a otro hilo probar
            if(!impresora.esTurno()){
                try{Thread.sleep(30);}catch(InterruptedException e){}
            }
        }while(2 == 2);
    }
}
