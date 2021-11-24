package ActividadesObligatorias.ActividadObligatoria4.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.ArrayList;
public class CentroImpresion {
    private BlockingQueue<Object> impresionesA;
    private BlockingQueue<Object> impresionesB;
    private BlockingQueue<Object> impresionesC;
    private ArrayList<Object> impreso = new ArrayList<Object>();

    public CentroImpresion(int bufferA, int bufferB, int bufferC) {
        impresionesA = new ArrayBlockingQueue<Object>(bufferA);
        impresionesB = new ArrayBlockingQueue<Object>(bufferB);
        impresionesC = new ArrayBlockingQueue<Object>(bufferC);
    }

    // ==== Cliente ====
    public void dejarTrabajo(int tipo, Object pendrive) throws InterruptedException{
        switch(tipo){
            case 0: impresionesA.put(pendrive);
            break;
            case 1: impresionesB.put(pendrive);
            break;
            default: impresionesC.put(pendrive);
        }
    }

    public synchronized void esperarImpresion(Object elem) throws InterruptedException{
        while(!impreso.contains(elem)){
            wait();
        }
        impreso.remove(elem);
    }

    // ==== Impresoras ====
    public Object agarrarTrabajo(int tipo) throws InterruptedException{
        Object trabajo = null;
        if(impresionesC.isEmpty()){
            if(tipo == 0){
                trabajo = impresionesA.take();
            }else{
                trabajo = impresionesB.take();
            }
        }else{
            trabajo = impresionesC.take();
        }
        return trabajo;
    }
    
    public synchronized void entregarTrabajo(int tipo, Object elem) throws InterruptedException{
        impreso.add(elem);
        notifyAll();
    }
}
