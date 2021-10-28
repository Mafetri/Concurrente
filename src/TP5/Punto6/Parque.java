package TP5.Punto6;

import java.util.concurrent.Semaphore;

public class Parque {
    private int babuinos;                   // Se utiliza para saber la cantidad total de babuinos en el parque
    private int babuinosIzq = 0;            // Se utiliza para contar la cantidad de babuinos que pasaron a la izquierda
    private int babuinosDer = 0;            // Se utiliza para conta la cantidad de babuinos que se pasaron a la derecha
    private int babuniosEsperandoD;         // Cantidad de hilos bloqueados en el acquire de la derecha
    private int babuniosEsperandoI;         // Cantidad de hilos bloqueados en el acquire de la izquierda
    private int cantidadEnCuerda;           // Cantidad de hilos que usaron la cuerda
    private Semaphore cuerda = new Semaphore(5);            // Los babuinos no respetan ordenes de llegada
    private Semaphore ladoDerecho = new Semaphore(5);
    private Semaphore ladoIzquierdo = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    Parque(int b) {
        this.babuinos = b;
    }

    public void cruzarCuerda(char tipo) throws InterruptedException {
        if (tipo == 'd') { 
            mutex.acquire();
            babuniosEsperandoD++;
            mutex.release();
            ladoDerecho.acquire();
        } else {
            mutex.acquire();
            babuniosEsperandoI++;
            mutex.release();
            ladoIzquierdo.acquire();
        }
        mutex.acquire();
        // Cruza la cuerda si es que no hay ningun babuino en ella
        cantidadEnCuerda++;
        mutex.release();
        cuerda.acquire();
    }

    public void soltarCuerda(char lado) throws InterruptedException {
        mutex.acquire();
        // Incrementa el contador del lado destino del babuino
        incrementarContador(lado);
        cantidadEnCuerda--;
        if (cantidadEnCuerda == 0) {
            if (babuniosEsperandoD == 0) {
                ladoIzquierdo.release(babuniosEsperandoI);
            }else if(babuniosEsperandoI == 0){
                ladoDerecho.release(babuniosEsperandoD);
            }else{
                if(lado == 'd'){
                    ladoIzquierdo.release(5);
                }else{
                    ladoDerecho.release(5);
                }
            }
        }
        mutex.release();

        // Termina de cruzar la cuerda y se añade un contador al lado correspondiente
        cuerda.release();
    }

    public boolean cruzaronTodos() {
        // Retorna true si ya cruzaron todos los babuinos y false si no
        return babuinos == (babuinosDer + babuinosIzq);
    }

    public void incrementarContador(char lado) {
        // Incrementan de destino, esta accion esta protegida por un lock, se podria
        // utilizar un bloque sincronizado para hacer lo mismo
        if (lado == 'i')
            babuinosDer++;
        else
            babuinosIzq++;

    }

    public void parqueToString() {
        System.out.println("Cruzaron " + babuinosIzq + " al lado izquierdo y " + babuinosDer + " al lado derecho, cruzaron todos?: " + cruzaronTodos()); 
    }

}
