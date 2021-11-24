package parcial2_Triñanes_2738.Punto2;

public class Cocinero implements Runnable{
    private Pizzeria p;
    public Cocinero(Pizzeria p){
        this.p = p;
    }
    public void run() {
        Object[] pedido;
        try {
            while(true){
                pedido = p.hacerPizzas();
                // Si el pedido no es nulo es de cliente, sino es de repartidor
                if(pedido != null){
                    System.out.println(Thread.currentThread().getName() + " hace el pedido de " + pedido[0] + " de " + pedido[1] + " pizzas");
                    Thread.sleep((int)pedido[1]*1000); 
                }else{
                    System.out.println(Thread.currentThread().getName() + " hace pizza para repartidor.");
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + " entrega pedido");
                p.entregarPedido(pedido);
            }
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + " murio de " + e);
        }
    }
}
