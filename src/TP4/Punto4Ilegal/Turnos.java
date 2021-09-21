package TP4.Punto4Ilegal;
import java.util.concurrent.*;
public class Turnos {
    private Semaphore sem1, sem2, sem3;
    
    public Turnos(int s1, int s2, int s3){
        this.sem1 = new Semaphore(s1);
        this.sem2 = new Semaphore(s2);
        this.sem3 = new Semaphore(s3);
    }

    public Turnos(){
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
        this.sem3 = new Semaphore(0);
    }

    public Semaphore esTurno(char letra) throws Exception {
        Semaphore sem = new Semaphore(0);

        if(letra == 'A'){
            sem1.acquire();
            sem = sem2;
        }else if(letra == 'B'){
            sem2.acquire();
            sem = sem3;
        }else if(letra == 'C'){
            sem3.acquire();
            sem = sem1;
        }

        return sem;
        
    }

}
