package TP6.Punto6;

public class Visitante implements Runnable{
    private Observatorio o;
    public Visitante(Observatorio o){
        this.o = o;
    }
    public void run(){
        try{
            System.out.println("El " + Thread.currentThread().getName() + " está esperando para entrar. 👳‍♂️");
            o.entrarVisitante();
            System.out.println("El " + Thread.currentThread().getName() + " entró. 👳‍♂️");
            Thread.sleep(1000);
            o.salirVisitante();
            System.out.println("El " + Thread.currentThread().getName() + " se fue. 👳‍♂️");
        }catch(Exception e){
            System.out.println("El " + Thread.currentThread().getName() + "🧨🧨" + e);
        }
    }
}
