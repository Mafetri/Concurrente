package ActividadesObligatorias.ActividadObligatoria4.BlockingQueue;

public class Impresora implements Runnable{

    private int tipo;
    private CentroImpresion centro;
    
    public Impresora(CentroImpresion c, int t){
        centro=c;
        tipo=t;
    }

    public void run() {
        Object elem = null;
        try{
            while(true){
                System.out.println(Thread.currentThread().getName() + tipo + " espera a que hayan trabajos.");
                elem = centro.agarrarTrabajo(tipo);
                System.out.println(Thread.currentThread().getName() + tipo + " imprime " + elem.toString());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + tipo + " entrega " + elem.toString());
                centro.entregarTrabajo(tipo, elem);
            }
        }catch (InterruptedException e) {
            System.out.println("Se murio esperando");
        }
    }
}
