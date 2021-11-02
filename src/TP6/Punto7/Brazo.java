package TP6.Punto7;

public class Brazo implements Runnable{

    private Pasteleria p;

    Brazo(Pasteleria p) {
        this.p = p;
    }

    public void run() {
        try{
            while(true){
                p.retirarCaja();
                Thread.sleep(5000);
                p.reponeCaja();
            }
        }catch(Exception e){System.out.println("El brazo 💀");}
    }
    
    
}
