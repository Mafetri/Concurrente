package Simulacros.SegundoParcial.Tema2.Punto2;

import java.util.concurrent.locks.*;

public class Espacio {
    char[] agua = new char[3];
    private int oHaciendoAgua = 0;
    private int hHaciendoAgua = 0;
    private int cantH;
    private int cantO;
    private int hPasados;
    private int oPasados;
    private int cantH2O;
    private int capacidadActualRecipiente;
    Lock mutex = new ReentrantLock();
    Condition oListo = mutex.newCondition(), hListo = mutex.newCondition(), contenedorLleno = mutex.newCondition(), hacerAgua = mutex.newCondition();

    // ==== Atomo ====
    public void entrarAProceso(char tipo) throws InterruptedException {
        mutex.lock();
        try {
            if (tipo == 'O') {
                while (oHaciendoAgua > 0) {
                    oListo.await();
                }
                oHaciendoAgua++;
                hListo.signalAll(); 
            } else {
                while (hHaciendoAgua > 1) {
                    hListo.await();
                }
                hHaciendoAgua++;
                oListo.signal();
            }
        } finally {
            mutex.unlock();
        }
    }

    public boolean esperarOtrosAtomos(char tipo) throws InterruptedException {
        mutex.lock();
        boolean soyElUltimo = false;
        try {
            if (hHaciendoAgua < 2 || oHaciendoAgua <= 0) {
                System.out.println(Thread.currentThread().getName() + " está esperando a otros atomos.");
                hacerAgua.await();
            } else{
                soyElUltimo = true;
            }
        } finally {
            mutex.unlock();
        }
        return soyElUltimo;
    }
    public void hacerAgua(){
        mutex.lock();
        try{
            hacerAgua.signalAll();
            oHaciendoAgua = 0;
            hHaciendoAgua = 0;
            oListo.signal();
            System.out.println(Thread.currentThread().getName() + " se hizo agua.");
        }finally{mutex.unlock();}
    }
}
