package Simulacros.SegundoParcial.Tema1.Punto2;

public class Auto implements Runnable {
    Ferry f;
    public Auto(Ferry f) {
        this.f = f;
    }
    public void run() {
        try{
            f.subirAlFerry();
            f.bajar();
        }catch(Exception e){}
    }
}
