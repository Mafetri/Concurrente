package TP4.Punto10;

public class Mozo implements Runnable{

    private Confiteria confiteria;

    Mozo(Confiteria conf){
        this.confiteria = conf;
    }

    public void run(){
        trabajar();
    }

    public void trabajar(){
        while(true){
            try{
                //Atiende al empleado
                confiteria.atender();
                System.out.println("El mozo atendio a un empleado.");
                //Prepara el pollo y el cafe
                Thread.sleep(1000);
                //Le sirve (se bloquea hasta que se vaya el cliente)
                confiteria.servir();
                //Hace su hobbie
                System.out.println("El mozo ahora esta en su hobbie.");
            }catch(Exception e){
                System.out.println("F por el mozo.");
            }
        }
    }
    
}
