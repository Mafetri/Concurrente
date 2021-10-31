package TP6.Punto3;
import java.util.Random;
public class Main{
    public static void main(String[] args){
        CentroImpresion c = new CentroImpresion();
        Thread[] clientes = new Thread[20];
        Thread[] impresoras = new Thread[4];

        for(int i=0; i<clientes.length; i++){
            clientes[i] = new Thread(new Cliente(impRandom(), c), "Cliente " + i);
            clientes[i].start();
        }
        for(int i=0; i<impresoras.length; i++){
            impresoras[i] = new Thread(new Impresora(impRandom(), c), "Impresora " + i);
            impresoras[i].start();
        }

        System.out.println("🥵🤑🥶🤓 A IMPRIMIR 🥵🤑🥶🤓");
    }
    public static char impRandom() {
        char tipo;
        Random r = new Random();
        switch(r.nextInt(3)){
            case 0: tipo = 'a'; break;
            case 1: tipo = 'b'; break;
            default: tipo = 'c';
        }
        return tipo;
    }
}