package TP6.Punto7;

import java.util.Queue;
import java.util.concurrent.locks.*;
import java.util.LinkedList;
import java.util.*;

public class Pasteleria {
    private int cantEmpaquetadores;
    private int cantidadChequeados;
    private int pesoCajaMax;
    private int tamañoMostrador;
    private int pesoA;
    private int pesoB;
    private int pesoC;
    private Queue<Character> mostrador;
    private int pesoCajaActual;
    private Lock mutex = new ReentrantLock();
    private Condition hayLugarMostrador = mutex.newCondition(), hayTortas = mutex.newCondition(),
            hayLugarCaja = mutex.newCondition(), hayCajaParaRetirar = mutex.newCondition();

    public Pasteleria(int pesoMax, int tamañoMostrador, int pesoA, int pesoB, int pesoC, int cantEmpaquetadores) {
        this.pesoCajaMax = pesoMax;
        this.tamañoMostrador = tamañoMostrador;
        this.pesoA = pesoA;
        this.pesoB = pesoB;
        this.pesoC = pesoC;
        mostrador = new LinkedList<Character>();
        this.cantEmpaquetadores = cantEmpaquetadores;
    }

    // ==== Horno ====
    public void esperarMostrador() throws InterruptedException {
        mutex.lock();
        try {
            while (mostrador.size() >= tamañoMostrador) {
                System.out.println("El " + Thread.currentThread().getName() + " espera espacio en el mostrador.");
                hayLugarMostrador.await();
            }
        } finally {
            mutex.unlock();
        }
    }
    public void ponerPastel(char tipo) {
        mutex.lock();
        try {
            System.out.println("El "+ Thread.currentThread().getName() + " puso un pastel tipo "+tipo+"🐢");
            mostrador.add(tipo);
            hayTortas.signalAll();
        } finally {
            mutex.unlock();
        }
    }

    // ==== Empaquetador ====
    public int empaquetar() throws InterruptedException{
        mutex.lock();
        char tipoTorta;
        int pesoTorta = 0;
        try{
            while(mostrador.size() == 0) {
                System.out.println("El "+ Thread.currentThread().getName() + " espera a que hayan tortas en el mostrador");
                hayLugarMostrador.signalAll();
                hayTortas.await();
            }
            tipoTorta = mostrador.remove();
            hayLugarMostrador.signal();
            switch(tipoTorta){
                case 'a': pesoTorta = pesoA; break;
                case 'b': pesoTorta = pesoB; break;
                case 'c': pesoTorta = pesoC; break;
            }
            System.out.println("El " + Thread.currentThread().getName() + " agarró una torta tipo " + tipoTorta + "📦");
            return pesoTorta;
        }finally {mutex.unlock();}
    }
    public void soltarTorta(int peso) throws InterruptedException{
        mutex.lock();
        boolean yaChequee = false;
        try{
            while(pesoCajaActual + peso > pesoCajaMax){
                if(cantidadChequeados >= cantEmpaquetadores){
                    cantidadChequeados = 0;
                    hayCajaParaRetirar.signal();
                }else if (!yaChequee){
                    cantidadChequeados++;
                    yaChequee = true;
                    hayLugarCaja.signal();
                }
                hayLugarCaja.await();
            }
            pesoCajaActual = pesoCajaActual + peso;
        }finally {mutex.unlock();}
    }

    // ==== Brazo ====
    public void retirarCaja() throws InterruptedException{
        mutex.lock();
        try{
            System.out.println("El "+ Thread.currentThread().getName()+ " espera a que se llene la caja. 📦📦📦");
            hayCajaParaRetirar.await();
            System.out.println("El "+ Thread.currentThread().getName()+ " se lleva la caja. 📦📦📦");
        }finally{mutex.unlock();}
    }
    public void reponeCaja() throws InterruptedException {
        mutex.lock();
        try{
            pesoCajaActual = 0;
            System.out.println("El "+ Thread.currentThread().getName()+ " repuso la caja. 📦📦📦");
            hayLugarCaja.signalAll();
        }finally {mutex.unlock();}
    }
}
