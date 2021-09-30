package TP4.Punto5;
import java.util.concurrent.*;

public class CentroImpresion {
    private Semaphore[] impresorasA;
    private Semaphore[] impresorasB;
    
    public CentroImpresion(int A, int B){
        this.impresorasA = new Semaphore[A];
        this.impresorasB = new Semaphore[B];
        for(int i=0; i<A; i++){
            impresorasA[i] = new Semaphore(1);
        }
        for(int i=0; i<B; i++){
            impresorasB[i] = new Semaphore(1);
        }
    }
    
    public Object[] imprimir(char tipo, String cadena){
        Object[] tupla;
        switch(tipo){
            case 'A': tupla = imprimirA(cadena);break;
            case 'B': tupla = imprimirB(cadena);break;
            default: tupla = imprimirAmbas(cadena);
        }
        return tupla;
    }

    public Object[] imprimirA(String cadena){
        boolean exito = false;
        int i = 0;

        do{
            if(impresorasA[i].tryAcquire()){
                System.out.println("El usuario " + Thread.currentThread().getName() + " ha impreso en la impresora A"+i+": " + cadena);
                exito = true;
            }
            i++;
        }while(!exito && i < impresorasA.length);

        if(!exito){
            i = -1;
        }else{
            i -= 1;
        }
        Object[] tupla = {'A', i};
        return tupla;
    }

    public Object[] imprimirB(String cadena){
        boolean exito = false;
        int i = 0;
        // Prueba con todas las impresoras
        do{
            if(impresorasB[i].tryAcquire()){
                System.out.println("El usuario " + Thread.currentThread().getName() + " ha impreso en la impresora B"+i+": " + cadena);
                exito = true;
            }
            i++;
        }while(!exito && i < impresorasB.length);

        // Si no tuvo exito, devuelve -1, sino, devuelve que impresora utilizó
        if(!exito){
            i = -1;
        }else{
            i -= 1;
        }

        Object[] tupla = {'B', i};
        return tupla;
    }

    public Object[] imprimirAmbas(String cadena){
        boolean exito = false;
        int i = 0;
        int j = 0;
        Object[] tupla = {'C', -1};
        do{
            if(impresorasA[i].tryAcquire()){
                System.out.println("El usuario " + Thread.currentThread().getName() + " ha impreso en la impresora A"+i+": " + cadena);
                tupla[0] = 'A';
                tupla[1] = i;
                exito = true;
            }else if(impresorasB[j].tryAcquire()){
                System.out.println("El usuario " + Thread.currentThread().getName() + " ha impreso en la impresora B"+i+": " + cadena);
                exito = true;
                tupla[0] = 'B';
                tupla[1] =j;
            }
            i++;
            j++;
        }while(!exito && i < impresorasA.length && j < impresorasB.length);

        return tupla;
    }

    public void dejarImprimir(char tipo, int impresora){
        if(tipo == 'A'){
            impresorasA[impresora].release();
            System.out.println(Thread.currentThread().getName() + " dejó la impresora A" + impresora);
        }else{
            impresorasB[impresora].release();
            System.out.println(Thread.currentThread().getName() + " dejó la impresora B" + impresora);
        }
    }
}