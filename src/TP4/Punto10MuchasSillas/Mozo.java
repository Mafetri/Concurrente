package TP4.Punto10MuchasSillas;

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
                System.out.println("El mozo ahora esta en su hobbie.");
                confiteria.atender(); // Se bloquea esperando a que un cliente entre
                //Atiende al empleado
                System.out.println("El mozo atendió a un empleado.");
                //Prepara el pollo y el cafe
                Thread.sleep(1000);
                //Le sirve la comida
                confiteria.servir(); // Sin bloqueo, libera al cliente para que coma
            }catch(Exception e){
                System.out.println("F por el mozo.");
            }
        }
    }
    
}
