package Simulacros.SegundoParcial.Tema2.Punto1;
import java.util.*;
import java.util.concurrent.*;
public class CentroImpresion {
    Semaphore semBufferP = new Semaphore(1);
    Semaphore semBufferS = new Semaphore(1);
    Semaphore semImpresora = new Semaphore(0);
    ArrayList<Object> peticiones = new ArrayList<Object>();
    Queue<Object> bufferPrimario = new LinkedList<Object>();
    Queue<Object> bufferSecundario = new LinkedList<Object>();
    private int capacidadBufferPrimario;
    private int impresionActual;
    
    public CentroImpresion(int tam){
        this.capacidadBufferPrimario = tam;
    }

    // ==== Usuario ====
    public void registrarPeticion(Object id) throws InterruptedException {
        semImpresora.release();
        peticiones.add(id);

        // Mutex buffers
        semBufferP.acquire();
        if(bufferPrimario.size() < capacidadBufferPrimario){
            bufferPrimario.add(id);
            semBufferP.release();
        }else{
            semBufferP.release();
            semBufferS.acquire();
            bufferSecundario.add(id);
            semBufferS.release();
        }
    }
    
    // ==== Impresora ====
    public int accederBuffers()throws InterruptedException{
        semImpresora.acquire();
        Object impresion = peticiones.get(impresionActual);
        int buffer = -1;

        semBufferP.acquire();
        if(bufferPrimario.contains(impresion)){
            buffer = 1;
            semBufferP.release();
        }else{
            semBufferP.release();
            semBufferS.acquire();
            buffer = 2;
            semBufferS.release();
        }
        System.out.println(Thread.currentThread().getName() + " se va a imprmir " + impresion + " del buffer "+ buffer);
        impresionActual++;
        return buffer;
    }

    public void imprimir(int buffer) throws InterruptedException{
        //Se borra del buffer 
        if(buffer == 1){
            semBufferP.acquire();
            System.out.println(Thread.currentThread().getName() + " imprimió " + bufferPrimario.remove() + ". 📄🖨️");
            semBufferP.release();
        }else {
            semBufferS.acquire();
            System.out.println(Thread.currentThread().getName() + " imprimió " + bufferSecundario.remove() + ". 📄🖨️");
            semBufferS.release();
        }

    }
}
