package Simulacros.SegundoParcial.Tema1.Punto1;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.Queue;

public class Buffer {
    private Queue<Object> buffer1 = new LinkedList<Object>();
    private Queue<Object> buffer2 = new LinkedList<Object>();
    private boolean buffer1Insertar; // Oscilador
    private Semaphore insertar = new Semaphore(1);
    private Semaphore extraer = new Semaphore(1);
    private Semaphore oscilar = new Semaphore(1);

    public void insertar(Object n) throws InterruptedException {
        insertar.acquire();
        if (buffer1Insertar) {
            buffer1.add(n);
            if (buffer2.size() == 0) {
                oscilar.acquire();
                System.out.println(Thread.currentThread().getName() + " osciló los buffers");
                buffer1Insertar = false;
                oscilar.release();
            }
        } else {
            buffer2.add(n);
            if (buffer1.size() == 0) {
                oscilar.acquire();
                System.out.println(Thread.currentThread().getName() + " osciló los buffers");
                buffer1Insertar = true;
                oscilar.release();
            }
        }
        System.out.println("El buffer 1 es de insercion: " + buffer1Insertar);
        System.out.println(Thread.currentThread().getName() +", inserto " + n);
        System.out.println(buffer1.toString());
        System.out.println(buffer2.toString());
        insertar.release();
    }

    public Object extraer() throws InterruptedException {
        extraer.acquire();
        Object objeto = "😔😔";
        oscilar.acquire();
        if (buffer1Insertar) {
            if(buffer2.size() != 0) {
                objeto = buffer2.remove(); 
            }
        } else {
            if(buffer1.size() != 0){
                objeto = buffer1.remove();
            }
        }
        oscilar.release();
        System.out.println("El buffer 1 es de insercion: " + buffer1Insertar);
        System.out.println(buffer1.toString());
        System.out.println(buffer2.toString());
        extraer.release();
        return objeto;
    }
}
