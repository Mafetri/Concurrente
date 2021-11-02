package TP6.Punto6;

public class Lisiado implements Runnable{
    private Observatorio o;
    public Lisiado(Observatorio o){
        this.o = o;
    }
    public void run(){
        try{
            System.out.println("El " + Thread.currentThread().getName() + " está esperando para entrar. 👨‍🦽");
            o.entrarLisiado();
            System.out.println("El " + Thread.currentThread().getName() + " entró. 👨‍🦽");
            Thread.sleep(1000);
            o.salirLisiado();
            System.out.println("El " + Thread.currentThread().getName() + " se fue. 👨‍🦽");
        }catch(Exception e){
            System.out.println("El " + Thread.currentThread().getName() + "🦼🦼" + e);
        }
    }
}
