package parcial2_Triñanes_2738.Punto2;
import java.util.concurrent.*;
import java.util.LinkedList;
import java.util.Queue;

public class Pizzeria {
    private Semaphore semMesada;    // Se usa para controlar el numero max de pedidos que puede haber en la mesada
    private Semaphore semPedido = new Semaphore(0); // Se usa para que el repartidor espere por pizzas para repartir
    private Semaphore hayPedidos = new Semaphore(0); // Se usa para que el cocinero se bloquee si no hay pizzas pedidas
    private Semaphore semPedirPizza = new Semaphore(0); // Se usa para que el repartidor se bloquee esperando por una pizza del cocinero para él
    private int pizzaParaRepartidor;    // Se usa para saber cuantas pizzas para repartidores hay que hacer
    private Queue<Object[]> pedidos = new LinkedList<Object[]>();   // Se usa para generar una cola de pedidos a realizar
    private Queue<Character> pedidosParaEntregar = new LinkedList<Character>();     // Se usa para que el repartidor agarre de la mesada en el orden que se hayan hecho los pedidos

    public Pizzeria(int tamMesada){
        semMesada = new Semaphore(tamMesada);
    }

    // ==== GeneradorPedidos ====
    public void hacerPedido(char nombre, int tipo){
        hayPedidos.release();
        Object[] tupla = new Object[2];
        tupla[0] = nombre;
        tupla[1] = tipo;
        pedidos.add(tupla);
    }

    // ===== Cocinero ====
    // Pregunta que pizza hay que hacer y devuelve null si es para repartidor o el pedido de un cliente
    public Object[] hacerPizzas() throws InterruptedException{
        Object[] pedido;
        // Si hay pizzas para repartidores
        if(pizzaParaRepartidor != 0){
            // Se encarga de hacer esa pizza
            pizzaParaRepartidor--;
            pedido = null;
        }else{
            // Sino se encarga de pizzas de clientes
            // Se queda esperando por pedidos
            hayPedidos.acquire();
            // Si hay pedidos, entonces lo quita de la cola y lo hace
            pedido = pedidos.remove();
        }
        return pedido;
    }
    public void entregarPedido(Object[] pedido) throws InterruptedException{
        // Si el pedido pasado por parametro no es null
        if(pedido != null){
            // Entonces agrega el pedido a la cola de pedidos para entregar si es que hay lugar en la mesada
            // Sino se queda con la pizza en la mano hasta que se desocupe un lugar
            semMesada.acquire();
            pedidosParaEntregar.add((char)pedido[0]);
            // Le avisa al reaprtido que ya hay pizza para retirar
            semPedido.release();
        }else{
            // Le avisa al repartidor que su pizza esta lista
            semPedirPizza.release();
        }
        
    }

    // ==== Repartidor ====
    public char recogerPedido() throws InterruptedException{
        // Espera que haya pedidos para retirar
        semPedido.acquire();
        // Agarra el pedido y desocupa el lugar de la mesada
        semMesada.release();
        return pedidosParaEntregar.remove();
    }
    public void pedirPizzaACocinero() throws InterruptedException{
        // Hace lugar en la mesada, pide una pizza y espera que se la hagan
        // Esto hace que la mesada ahora contenga cantMax+pizzaParaRepartidor para que el cocinero deje el pedido
        // que tiene en las manos y haga la pizza del repartidor
        pizzaParaRepartidor++;
        semMesada.release();
        semPedirPizza.acquire();
    }
}
