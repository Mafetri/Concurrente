package Triñanes_2738.Ejercicio1;

import java.util.concurrent.*;

public class Toboganes {
    // Esta variable guarda el tobogan asignado al cliente
    private int toboganABajar = 0;
    // Este semaforo bloquea a los hilos para que sean atendidos de a uno
    // no tiene cola de acquiere asi hay mas competencia entre hilos
    Semaphore esperarASerAtendido = new Semaphore(0);
    // Este semaforo permite que el encargado quede bloquado esperando a un cliente
    Semaphore despertarEncargado = new Semaphore(0);
    // Este semaforo controla el tobogan 1
    Semaphore tobogan1 = new Semaphore(1);
    // Este semaforo controla el tobogan 2
    Semaphore tobogan2 = new Semaphore(1);
    // Este semaforo sincroniza que el cliente no se pueda bajar por un tobogan
    // hasta que el empleado asigne uno.
    Semaphore esperarDecision = new Semaphore(0, true);

    // ==== Cliente ====
    public void solicitarBajar() throws InterruptedException {
        // Espera a que sea su turno
        esperarASerAtendido.acquire();
        // Despierta al empleado
        despertarEncargado.release();
    }

    public int bajar() throws InterruptedException {
        // Espera a que el encargado designe por que tobogan debe bajar
        esperarDecision.acquire();

        // Se tira por el tobogan asignado
        switch (toboganABajar) {
            case 1:
                tobogan1.acquire();
                break;
            case 2:
                tobogan2.acquire();
        }

        return toboganABajar;
    }

    public void salirTobogan(int tobogan) {
        // Libera el tobogan usado
        switch (tobogan) {
            case 1:
                tobogan1.release();
                break;
            case 2:
                tobogan2.release();
        }
    }

    // ==== Encargado ====
    public void atender() throws InterruptedException {
        // Permite a cualquier cliente esperando que le hable
        esperarASerAtendido.release();
        // Espera mientras el cliente le hable
        despertarEncargado.acquire();
    }

    public boolean asignarTobogan() {
        boolean exito = false;

        // Chequea si el tobogan 1 esta libre
        if (tobogan1.tryAcquire()) {
            // Si esta libre, asigna el tobogan 1 al cliente esperando
            toboganABajar = 1;
            exito = true;
            tobogan1.release();
        } else if (tobogan2.tryAcquire()) {
            // Si esta libre, asigna el tobogan 2 al cliente esperando
            toboganABajar = 2;
            exito = true;
            tobogan2.release();
        }
        // Si habia un tobogan libre 
        if (exito) {
            // Permite al cliente que esta esperando usar el asignado
            esperarDecision.release();
        }
        
        return exito;
    }
}
