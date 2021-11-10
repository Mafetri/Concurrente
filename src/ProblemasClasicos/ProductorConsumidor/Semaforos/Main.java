package ProblemasClasicos.ProductorConsumidor.Semaforos;

public class Main {
    public static void main(String[] args){
        Buffer b = new Buffer(10);
        Thread[] consumidores = new Thread[1];
        Thread[] productores = new Thread[5];
        for(int i = 0; i < consumidores.length; i++){
            consumidores[i] = new Thread(new Consumidor(b), "Consumidor " + i);
            consumidores[i].start();
        }
        for(int i = 0; i < productores.length; i++){
            productores[i] = new Thread(new Productor(b), "Productor " + i);
            productores[i].start();
        }
    }
}