package TP6.Punto8;

public class Centro {
    private int revistas;
    private int camillas;
    private int turnoActual = 0;
    private int turnoFinal = 0;

    public Centro (int revistas, int camillas){
        this.revistas = revistas;
        this.camillas = camillas;
    }

    public synchronized void entrarSala() throws InterruptedException{
        boolean tieneRevista = false;
        int turno = turnoFinal;
        turnoFinal++;
        while(camillas <= 0 || turno != turnoActual){
            if(!tieneRevista && revistas > 0){
                tieneRevista = true;
                revistas--;
                System.out.println("El " + Thread.currentThread().getName() + " agarró una revista. 📰📰");
            }else if(!tieneRevista){
                System.out.println("El " + Thread.currentThread().getName() + " esta mirando tele. 📺📺");
            }
            wait();
        }
        if(tieneRevista){
            revistas++;
        }
        turnoActual++;
        camillas--;
        notifyAll();
    }

    public synchronized void irse(){
        camillas++;
        System.out.println("El " + Thread.currentThread().getName() + " liberó una camilla. 🛏️🛏️");
        notifyAll();
    }
}
