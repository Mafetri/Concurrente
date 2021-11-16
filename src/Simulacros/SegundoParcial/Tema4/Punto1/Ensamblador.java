package Simulacros.SegundoParcial.Tema4.Punto1;

public class Ensamblador implements Runnable{
    private Suetereria s;
    public Ensamblador(Suetereria s){
        this.s = s;
    }
    public void run(){
        try{
            while(true){
                System.out.println(Thread.currentThread().getName()+" espera por materiales");
                s.esperarMateriales();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " entrega el sueter");
                if(s.entregarSueter()){
                    System.out.println("Se llenó la caja 📦📦📦");
                }
            }
        }catch(Exception e){

        }
    }
}
