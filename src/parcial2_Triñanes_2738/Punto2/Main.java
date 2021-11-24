package parcial2_Triñanes_2738.Punto2;

public class Main {
    public static void main(String[] args){
        Pizzeria p = new Pizzeria(10);
        Thread[] cocineros = new Thread[2];
        Thread[] repartidores = new Thread[2];
        Thread pedido = new Thread(new GeneradorPedidos(p));
        pedido.start();
        for(int i = 0; i < repartidores.length; i++){
            repartidores[i] = new Thread(new Repartidor(p), "Repartidor " + i);
            repartidores[i].start();
        }
        for(int i = 0; i < cocineros.length; i++){
            cocineros[i] = new Thread(new Cocinero(p), "Cocinero " + i);
            cocineros[i].start();
        }
    }
}
