package Simulacros.PrimerParcial.Tema4;

public class ControlTren implements Runnable{
    private Tren tren;
    public ControlTren(Tren tren) {
        this.tren = tren;
    }
    public void run() {
        try{
            while(true){
                System.out.println("El tren está en la estacion");
                tren.viajar();
                System.out.println("El tren está a la viajando");
                Thread.sleep(3000);
                tren.enEstacion();
            }
        }catch(Exception e){}
    }
}
