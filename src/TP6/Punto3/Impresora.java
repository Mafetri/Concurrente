package TP6.Punto3;

public class Impresora implements Runnable{
    private CentroImpresion c;
    private char tipo;

    Impresora(char t,CentroImpresion c){
        this.c = c;
        this.tipo = t;
    }

    public void run() {
        while (true) {
            try{
                System.out.println("La "+Thread.currentThread().getName() +" esta esperando a imprimir");
                c.imprimir(tipo);
                Thread.sleep(3000);
                c.dejarImprimir(tipo);
            }catch(Exception e){}
        }
    }
}