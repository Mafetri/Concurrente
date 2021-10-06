package Simulacros.PrimerParcial.Tema4;

public class Vendedor implements Runnable{
    private Tren tren;
    public Vendedor(Tren tren){
        this.tren = tren;
    }
    public void run(){
        boolean dar = true;
        try{
            while(true){
                System.out.println("Esperando al tren");
                tren.esprandoATren();
                dar = true;
                System.out.println("La venta esta abierta");
                do{
                    if(tren.darTicket()){
                        System.out.println("El vendedor dio un ticket");
                        Thread.sleep(1000);
                    }else{
                        dar = false;
                    }
                }while(dar);
                
            }
            
        }catch(Exception e){}
    }
}
