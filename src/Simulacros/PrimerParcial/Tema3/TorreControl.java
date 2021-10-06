package Simulacros.PrimerParcial.Tema3;

public class TorreControl implements Runnable{
    private Pista pista;

    public TorreControl(Pista pista){
        this.pista = pista;
    }

    public void run(){
        try{
            while(true){
                System.out.println("El controlador espera trafico.");
                pista.esperarAviones();
                System.out.println("El controlador se comunica con avion.");
                pista.controlar();
            }
        }catch(Exception e){}
    }
}
