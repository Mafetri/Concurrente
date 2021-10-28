package TP5.Punto4;

public class Torre implements Runnable{

    private Pista pista;

    Torre(Pista pista){
        this.pista = pista;
    }

    public void run(){
        while(true){
            try{
            System.out.println("Esperando a un nuevo avion.");
            pista.esperarAvion();
            System.out.println("Se comunica con avion.");
            pista.darOrden();
            }catch(Exception e){
                System.out.println("La torre se prendio fuego");
            }
        }
    }
}
