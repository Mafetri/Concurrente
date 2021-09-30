package TP4.Punto5;

import java.util.concurrent.*;
import java.util.Random;

public class CentroImpresion {
    private Semaphore[] impresorasA;
    private Semaphore[] impresorasB;

    public CentroImpresion(int A, int B) {
        this.impresorasA = new Semaphore[A];
        this.impresorasB = new Semaphore[B];
        for (int i = 0; i < A; i++) {
            impresorasA[i] = new Semaphore(1);
        }
        for (int i = 0; i < B; i++) {
            impresorasB[i] = new Semaphore(1);
        }
    }

    public Object[] imprimir(char tipo, String cadena) throws InterruptedException{
        Object[] tupla = {'C', -1};
        if(tipo != 'A' && tipo != 'B'){
            Random r = new Random();
            tipo = (char)(r.nextInt(2) + 65);
        }
        switch (tipo) {
            case 'A':
                tupla = imprimirA(cadena);
                break;
            case 'B':
                tupla = imprimirB(cadena);
                break;
        }
        return tupla;
    }

    private Object[] imprimirA(String cadena) throws InterruptedException {
        int i = asignarImpresora('A');
        System.out.println("El usuario " + Thread.currentThread().getName() + " esta esperando la impresora A" + i);
        impresorasA[i].acquire();
        System.out.println("El usuario " + Thread.currentThread().getName() + " está imprimiendo en la impresora A"+i+" "+ cadena);
        Object[] tupla = { 'A', i };
        return tupla;
    }

    private Object[] imprimirB(String cadena) throws InterruptedException{
        int i = asignarImpresora('B');
        System.out.println("El usuario " + Thread.currentThread().getName() + " esta esperando la impresora B" + i);
        impresorasB[i].acquire();
        System.out.println("El usuario " + Thread.currentThread().getName() + " está imprimiendo en la impresora B"+i+" "+ cadena);
        Object[] tupla = { 'B', i };
        return tupla;
    }

    private int asignarImpresora(char tipo) {
        Random r = new Random();
        int posicion;

        if (tipo == 'A') {
            posicion = r.nextInt(impresorasA.length);
        } else {
            posicion = r.nextInt(impresorasB.length);
        }

        return posicion;
    }

    public void dejarImprimir(char tipo, int impresora) {
        if (tipo == 'A') {
            impresorasA[impresora].release();
            System.out.println(Thread.currentThread().getName() + " dejó la impresora A" + impresora);
        } else {
            impresorasB[impresora].release();
            System.out.println(Thread.currentThread().getName() + " dejó la impresora B" + impresora);
        }
    }
}