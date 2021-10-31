package TP6.Punto3;

public class CentroImpresion{
    int idClienteA = 0;
    int idClienteB = 0;
    int impresionesA = 0;
    int impresionesB = 0;

    // ==== Cliente ====
    public synchronized int solicitarImpresion(char tipo) throws InterruptedException{
        int id;
        if(tipo == 'a'){
            idClienteA++;
            id = idClienteA;
            System.out.println("El " + Thread.currentThread().getName() + " en cola " + id);
            notifyAll();
            while(id > impresionesA){
                wait();
            }
        }else{
            idClienteB++;
            id = idClienteB;
            System.out.println("El " + Thread.currentThread().getName() + " en cola " + id);
            notifyAll();
            while(id > impresionesB){
                wait();
            }
        }
        return id;
    }
    
    // ==== Impresoras ==== 
    public synchronized void imprimir(char tipo) throws InterruptedException{
        if(tipo == 'a'){
            while(impresionesA > idClienteA){
                wait();
            }
        }else{
            while(impresionesB > idClienteB){
                wait();
            }
        }
    }
    public synchronized void dejarImprimir(char tipo) throws InterruptedException{
        if(tipo == 'a'){
            impresionesA++;
            System.out.println("La " + Thread.currentThread().getName() + "A ha impreso la impresion " + impresionesA);
        }else{
            impresionesB++;
            System.out.println("La " + Thread.currentThread().getName() + "B ha impreso la impresion " + impresionesB);
        }
        notifyAll();
    }

}