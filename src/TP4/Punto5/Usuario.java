package TP4.Punto5;

public class Usuario implements Runnable{
    private CentroImpresion impresoras;
    private char tipo;
    private String archivo;

    public Usuario(String archivo, char tipo, CentroImpresion impresoras){
        this.tipo = tipo;
        this.impresoras = impresoras;
        this.archivo = archivo;
    }

    public void run() {
        Object[] impresoraUsada = impresoras.imprimir(tipo, archivo);

        if((int) impresoraUsada[1] != -1){
            try{Thread.sleep(5000);}catch(InterruptedException e){}
            impresoras.dejarImprimir((char)impresoraUsada[0], (int)impresoraUsada[1]);
            if(tipo != 'A' && tipo != 'B'){
                System.out.println("El usuario " + Thread.currentThread().getName() + " tenia " + tipo);
            }
        }else{
            System.out.println("El usuario " + Thread.currentThread().getName() + " se fué por falta de impresoras libres.");
        }
    }

    
}
