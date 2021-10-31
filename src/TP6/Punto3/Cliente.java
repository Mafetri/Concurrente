package TP6.Punto3;
import java.util.Random;

public class Cliente implements Runnable{
    char tipo;
    CentroImpresion c;
    public Cliente(char tipo, CentroImpresion c){
        if(tipo != 'a' || tipo != 'b'){
            switch(asignarRandom()){
                case 0: tipo = 'a'; break;
                case 1: tipo = 'b'; break;
            }
        }
        this.tipo = tipo;
        this.c = c;
    }
    public void run() {
        try{
            System.out.println("El " + Thread.currentThread().getName() + " solicita una impresion de tipo " + tipo);
            c.solicitarImpresion(this.tipo);
            System.out.println("El " + Thread.currentThread().getName() + " se fué.");
        }catch(Exception e){

        }
    }
    public int asignarRandom(){
        Random ran = new Random();
        return ran.nextInt(2);
    }
}