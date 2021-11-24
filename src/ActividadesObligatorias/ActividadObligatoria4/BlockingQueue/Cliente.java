package ActividadesObligatorias.ActividadObligatoria4.BlockingQueue;
import java.util.Random;
public class Cliente implements Runnable {

    private int tipo;
    private CentroImpresion centro;
    private Object trabajo;

    public Cliente(int t, CentroImpresion c, Object trabajo) {
        tipo = t;
        centro = c;
        this.trabajo = trabajo;
    }


    public void run() {
        try {
            Random r=new Random();
            Thread.sleep(500*r.nextInt(3));
            System.out.println(Thread.currentThread().getName() + " espera a dejar el trabajo: "+ tipo);
            centro.dejarTrabajo(tipo, trabajo);
            System.out.println("Esperanding");
            centro.esperarImpresion(trabajo);
            System.out.println(Thread.currentThread().getName() +" Retiro su trabajo: "+ tipo);
        } catch (InterruptedException e) {
            System.out.println("Se murio esperando");
        }
    }
}
