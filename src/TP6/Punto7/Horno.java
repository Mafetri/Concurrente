package TP6.Punto7;

public class Horno implements Runnable{
    private Pasteleria p;
    private char tipoPastel;
    public Horno(Pasteleria p, char tipoPastel) {
        this.p = p;
        this.tipoPastel = tipoPastel;
    }
    public void run(){
        try{
            while(true){
                p.esperarMostrador();
                System.out.println("El " + Thread.currentThread().getName() + " está haciendo un pastel tipo " + tipoPastel);
                Thread.sleep(1000);
                p.ponerPastel(tipoPastel);
            }
        }catch(Exception e){
            System.out.println("El Horno 💀" + e);
        }
    }
}
