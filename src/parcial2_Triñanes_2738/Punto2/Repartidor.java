package parcial2_Triñanes_2738.Punto2;

public class Repartidor implements Runnable {
    private Pizzeria p;
    private int cantEntregados;

    public Repartidor(Pizzeria p) {
        this.p = p;
    }
    public void run() {
        try{
            while(true){
                System.out.println(Thread.currentThread().getName() + " listo para trabajar.");
                if(cantEntregados < 2){
                    // Recoge pedido y lo entrega
                    System.out.println(Thread.currentThread().getName()+" recoge pedido de " + p.recogerPedido());
                    Thread.sleep(2000);
                    cantEntregados++;
                }else{
                    // Pide una pizza y se relaja comiendola
                    System.out.println(Thread.currentThread().getName() + " le pide pizza al cocinero.");
                    p.pedirPizzaACocinero();
                    cantEntregados = 0;
                    Thread.sleep(3000);
                }
            }
        } catch (Exception e){
            System.out.println(Thread.currentThread().getName() + " murio de " + e);
        }
    }
}
