package parcial2_Triñanes_2738.Punto2;
import java.util.Random;
public class GeneradorPedidos implements Runnable{
    Pizzeria p;
    char nombreActual = 65;
    public GeneradorPedidos(Pizzeria p) {
        this.p = p;
    }
    public void run() {
        try{
            while(true){
                p.hacerPedido(nombreActual, random());
                Thread.sleep(1000);
                nombreActual++;
                if(nombreActual == 90){
                    nombreActual = 65;
                }
            }
        } catch (Exception e){
            System.out.println(Thread.currentThread().getName() + " murio de " + e);
        }
    }
    public int random(){
        Random r = new Random();
        return r.nextInt(2)+1;
    }
}
