package ActividadObligatoria2.Punto2.Semaforos;

public class Embotellador implements Runnable{
    private Planta p;

    public Embotellador(Planta p) {
        this.p = p;
    }

    public void run() {
        try{
            while(true){
                p.embotellar();
                p.meterBotella();
                System.out.println("Botella agregada.");
                Thread.sleep(500);
            }
        }catch(Exception e){}
    }
}
