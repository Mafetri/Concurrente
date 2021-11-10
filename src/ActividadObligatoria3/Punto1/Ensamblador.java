package ActividadObligatoria3.Punto1;

public class Ensamblador implements Runnable{

    private Carpinteria carpinteria;

    Ensamblador(Carpinteria c){
        this.carpinteria = c;
    }

    public void run(){
        int[] idUtilizados = new int[3];
        boolean terminar = false;
        try{
            while(!terminar){
                idUtilizados = carpinteria.ensamblar();
                System.out.println(Thread.currentThread().getName() +" esta ensamblando. 🛠️🛠️");
                Thread.sleep(2000);
                terminar = carpinteria.liberarCarpinteros(idUtilizados);
            }
            System.out.println(Thread.currentThread().getName() +" se fue a la casita. 🏠🏠");
        }catch(InterruptedException e){
            System.out.println(e.toString() + Thread.currentThread().getName() + " se fue a mimir por mucho tiempo. 🩸👻👻");
        }
    }
    
}
