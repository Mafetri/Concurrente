package TP6.Punto6;

public class Investigador implements Runnable{
    private Observatorio o;
    public Investigador(Observatorio o){
        this.o = o;
    }
    public void run(){
        try{
            System.out.println("El " + Thread.currentThread().getName() + " está esperando para entrar. 🕵️");
            o.entrarInvestigador();
            System.out.println("El " + Thread.currentThread().getName() + " entró. 🕵️");
            Thread.sleep(4000);
            o.salirInvestigador();
            System.out.println("El " + Thread.currentThread().getName() + " se fue. 🕵️");
        }catch(Exception e){}
    }
}
