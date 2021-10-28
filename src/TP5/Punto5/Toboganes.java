package TP5.Punto5;

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
    // Se agregó este semaforo generico para el aviso de tobogan libre
    Semaphore toboganLibre = new Semaphore(2);

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
        toboganLibre.release();
    }

    // ==== Encargado ====
    public void atender() throws InterruptedException {
        // Permite a cualquier cliente esperando que le hable
        esperarASerAtendido.release();
        // Espera mientras el cliente le hable
        despertarEncargado.acquire();
    }

    public void asignarTobogan() throws InterruptedException{
        toboganLibre.acquire();
        
        // Chequea si el tobogan 1 esta libre
        if (tobogan1.tryAcquire()) {
            // Si esta libre, asigna el tobogan 1 al cliente esperando
            toboganABajar = 1;
            tobogan1.release();
            esperarDecision.release();
        } else if (tobogan2.tryAcquire()) {
            // Si esta libre, asigna el tobogan 2 al cliente esperando
            toboganABajar = 2;
            tobogan2.release();
            esperarDecision.release();
        }
    }
}
