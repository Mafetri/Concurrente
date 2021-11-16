package Simulacros.SegundoParcial.Tema4.Punto1;

public class Manguero implements Runnable{
    private Suetereria s;
    public Manguero(Suetereria s){
        this.s = s;
    }
    public void run(){
        try{
            while(true){
                s.hacerManga();
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " entregó una manga");
                s.meterMangaCesto();
            }
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + " se la puso ☠️☠️");
        }
    }
}
