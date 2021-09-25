package TP4.Punto7;

public class Taxista implements Runnable{
    private Taxi taxi;

    public Taxista(Taxi taxi){
        this.taxi = taxi;
    }

    public void run(){
        trabajar();
    }

    public void trabajar(){
        try{
            taxi.trabajar();
        do{
            Thread.sleep(3000);
            taxi.dejarViajar();
        }while(2==2);
        
        }catch(InterruptedException e){}
    }
    

}