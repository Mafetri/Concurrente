package TP3.Punto2;

public class Bot implements Runnable{
    private Heroe heroe;

    public Bot(Heroe heroe){
        this.heroe = heroe;
    }

    public void run(){
        // Mientras que el heroe este vivo
        while(heroe.getVida() > -1 && heroe.getVida() < 15){
            // Si el hilo del Bot es un Curandero, este va a aumentar la vida cada 1.5seg, 
            // sino quita 3 cada 1seg
            if(Thread.currentThread().getName().equals("Curandero")){
                heroe.alterarVida(3);
                System.out.println("> El heroe esta siendo curado: " + heroe.getVida());
                try{ Thread.sleep(1500);}catch(InterruptedException e){}
            }else{
                heroe.alterarVida(-3);
                System.out.println("> El heroe esta siendo atacado: " + heroe.getVida());
                try{Thread.sleep(1000);}catch(InterruptedException e){}
            }
        }
    }
}
