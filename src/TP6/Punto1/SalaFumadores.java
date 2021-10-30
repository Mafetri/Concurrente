package TP6.Punto1;

public class SalaFumadores {
    private boolean[] ingredientes = new boolean[3];
    int cantidadColocada = 0;

    public SalaFumadores() {
        for(int i = 0; i < cantidadColocada; i++){
            ingredientes[i] = false;
        }
    }

    // ==== Fumador =====
    public synchronized void entraFumar(int id) throws InterruptedException{
        id -= 1;
        while(cantidadColocada != 2 || ingredientes[id] == true){
            wait();
        }
    }
    public synchronized void terminaFumar(){
        for(int i = 0; i < ingredientes.length; i++){
            ingredientes[i] = false;
        }
        cantidadColocada = 0;
        notifyAll();
    }

    // ==== Agente ====
    public synchronized void colocar(int id) throws InterruptedException{
        id -= 1;
        if(ingredientes[id] != true){
            System.out.println("El agente colocó: " + id);
            ingredientes[id] = true;
            cantidadColocada++;
        }
        if(cantidadColocada == 2){
            System.out.println("El agente colocó 2 ingredientes");
            notifyAll();
            while(ingredientes[id] != false){
                wait();
            }
        }
    }
}
