package TP6.Punto7;

public class Empaquetador implements Runnable{

    private Pasteleria p;

    Empaquetador(Pasteleria p) {
        this.p = p;
    }

    public void run() {
        int peso;
        try{
            while(true){
                peso = p.empaquetar();
                Thread.sleep(1000);
                p.soltarTorta(peso);
            }
        }catch(Exception e){System.out.println("El empaquetador 💀" + e);}
    }
    
}
