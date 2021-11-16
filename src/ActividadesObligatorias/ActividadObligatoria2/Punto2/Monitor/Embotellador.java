package ActividadesObligatorias.ActividadObligatoria2.Punto2.Monitor;

public class Embotellador implements Runnable{
    private Planta p;

    public Embotellador(Planta p) {
        this.p = p;
    }

    public void run() {
        try{
            while(true){
                p.embotellar();
                meterBotellas();
                p.cajaLlena();
            }
        }catch(Exception e){
            System.out.println("Se tropezó porque tuvo un " + e);
        }
    }

    public void meterBotellas(){
        for(int i = 0; i < 10; i++){
            System.out.println("Botella agregada.");
            dormir(500);
        }
    }

    public void dormir(int ms){
        try{Thread.sleep(ms);}catch(Exception e){}
    }
}
