package ActividadObligatoria3.Punto1;

import java.util.concurrent.locks.*;
import java.util.*;

public class Carpinteria {
    private Lock mutex = new ReentrantLock();
    private Condition tipo1 = mutex.newCondition(), tipo2 = mutex.newCondition(), tipo3 = mutex.newCondition(),
            ensamblador = mutex.newCondition(), esperarEnsamblaje = mutex.newCondition();
    private int cantMueblesMax;
    private int cantMueblesActual = 0;
    private int piezasSolicitadas1 = 0;
    private int piezasSolicitadas2 = 0;
    private int piezasSolicitadas3 = 0;
    private int piezasFabricadas1 = 0;
    private int piezasFabricadas2 = 0;
    private int piezasFabricadas3 = 0;
    ArrayList piezas1 = new ArrayList();
    ArrayList piezas2 = new ArrayList();
    ArrayList piezas3 = new ArrayList();
    ArrayList piezasEnsambladas = new ArrayList();

    public Carpinteria(int cantMueblesMax) {
        this.cantMueblesMax = cantMueblesMax;
    }

    // ===== Carpintero =====
    public boolean fabricar(int tipo, int id) throws InterruptedException {
        mutex.lock();
        boolean terminar = false;
        try {
            switch (tipo) {
            case 1:
                while (cantMueblesActual < cantMueblesMax && piezasFabricadas1 >= piezasSolicitadas1) {
                    System.out.println(Thread.currentThread().getName() + " esta esperando para trabajar.");
                    tipo1.await();
                }
                piezasFabricadas1++;
                break;
            case 2:
                while (cantMueblesActual < cantMueblesMax && piezasFabricadas2 >= piezasSolicitadas2) {
                    System.out.println(Thread.currentThread().getName() + " esta esperando para trabajar.");
                    tipo2.await();
                }
                piezasFabricadas2++;
                break;
            case 3:
                while (cantMueblesActual < cantMueblesMax && piezasFabricadas3 >= piezasSolicitadas3) {
                    System.out.println(Thread.currentThread().getName() + " esta esperando para trabajar.");
                    tipo3.await();
                }
                piezasFabricadas3++;
                break;
            }
            if (cantMueblesActual >= cantMueblesMax) {
                terminar = true;
            }
        } finally {
            mutex.unlock();
        }

        return terminar;
    }

    public void entregar(int tipo, int id) throws InterruptedException {
        mutex.lock();
        System.out.println(Thread.currentThread().getName() + " acaba de terminar de hacer una pieza.");
        try {
            switch (tipo) {
            case 1:
                piezas1.add(id);
                ensamblador.signal();
                while (!piezasEnsambladas.contains((Integer) id)) {
                    esperarEnsamblaje.await();
                }
                break;

            case 2:
                piezas2.add(id);
                ensamblador.signal();
                while (!piezasEnsambladas.contains((Integer) id)) {
                    esperarEnsamblaje.await();
                }
                break;

            case 3:
                piezas3.add(id);
                ensamblador.signal();
                while (!piezasEnsambladas.contains((Integer) id)) {
                    esperarEnsamblaje.await();
                }
                break;
            }
        } finally {
            mutex.unlock();
        }
    }

    // ===== Ensamblador =====
    public int[] ensamblar() throws InterruptedException {
        mutex.lock();
        int[] idUtilizados = new int[3];
        try {
            piezasSolicitadas1++;
            tipo1.signal();
            piezasSolicitadas2++;
            tipo2.signal();
            piezasSolicitadas3++;
            tipo3.signal();
            while (piezas1.size() <= 0 || piezas2.size() <= 0 || piezas3.size() <= 0) {
                System.out.println(Thread.currentThread().getName() +" esta esperando a ensamblar🛵🪓");
                ensamblador.await();
            }
            idUtilizados[0] = (int) piezas1.remove(0);
            idUtilizados[1] = (int) piezas2.remove(0);
            idUtilizados[2] = (int) piezas3.remove(0);
        } finally {
            mutex.unlock();
        }
        return idUtilizados;
    }

    public boolean liberarCarpinteros(int[] carpinterosUtilizados) {
        mutex.lock();
        boolean terminar = false;
        try{
            System.out.println(Thread.currentThread().getName() +" libera carpinteros🛵🪓");
            cantMueblesActual++;
            if(cantMueblesActual >= cantMueblesMax) {
                terminar = true;
                tipo1.signalAll();
                tipo2.signalAll();
                tipo3.signalAll();
            }
            piezasEnsambladas.add(carpinterosUtilizados[0]);
            piezasEnsambladas.add(carpinterosUtilizados[1]);
            piezasEnsambladas.add(carpinterosUtilizados[2]);
            esperarEnsamblaje.signalAll();
        }finally{
            mutex.unlock();
        }
        return terminar;
    }
}
