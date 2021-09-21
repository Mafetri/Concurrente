package TP4.Punto4;
import java.util.concurrent.*;
public class Cadena {
    private Semaphore sem1, sem2, sem3;
    
    public Cadena(int s1, int s2, int s3){
        this.sem1 = new Semaphore(s1);
        this.sem2 = new Semaphore(s2);
        this.sem3 = new Semaphore(s3);
    }

    public Cadena(){
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
        this.sem3 = new Semaphore(0);
    }

    public void imprimir(Letra letra) throws InterruptedException{
        if(letra.getLetra() == 'A'){
            sem1.acquire();
            imprimirLetras(letra.getCantVeces(), letra.getLetra());
            sem2.release();
        }else if(letra.getLetra() == 'B'){
            sem2.acquire();
            imprimirLetras(letra.getCantVeces(), letra.getLetra());
            sem3.release();
        }else if(letra.getLetra() == 'C'){
            sem3.acquire();
            imprimirLetras(letra.getCantVeces(), letra.getLetra());
            sem1.release();
        }
    }

    public void imprimirLetras(int cantVeces, char letra){
        for(int i=0; i<cantVeces; i++){
            System.out.print(letra);
        }
    }
}
