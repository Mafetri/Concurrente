package Simulacros.SegundoParcial.Tema1.Punto2;

public class ControlFerry implements Runnable{

    private Ferry ferry;

    public ControlFerry(Ferry ferry){
        this.ferry = ferry;
    }

    public void run() {
        
        
        try{
            while(true){
                System.out.println("El ferry está esperando autos");
                ferry.llenar();
                System.out.println("El ferry está viajando");
                Thread.sleep(1000);
                System.out.println("El ferry llego a destino");
                ferry.llegarDestino();
                Thread.sleep(1000);
            }
        }catch(Exception e){
             System.out.println("El ferry exploto");
        }
        
    }   
    
}
