package TP3.Punto6;

public class Auto extends Vehiculo implements Runnable{
    private Gasolinera estacion;
    private int kmRestantes;
    public  Auto(int kmFaltantesParaElService, String patente, String modelo, String marca, Gasolinera estacion, int kmRestantes) {
        super(kmFaltantesParaElService, patente, modelo, marca);
        this.estacion = estacion;
        this.kmRestantes = kmRestantes;
    }
    public void run() {
        do{
            if(kmRestantes < 5){
                // Intenta cargar, si el logró cargar entonces
                if(estacion.cargar(this)){
                    // Carga nafta, se le suman kms, duerme un tiempito hasta que le llenen el tanque
                    // y una vez lleno libera el surtidor
                    kmRestantes = 100;
                    try{Thread.sleep(1000);}catch(InterruptedException e){}
                    estacion.cargar(null);
                }else{
                    // Si no pudo cargar es porque el surtidor estaba lleno, asi que espera un ratito
                    try{Thread.sleep(50);}catch(InterruptedException e){}
                }   
            }else{
                // Si le quedan km de tanque, entonces recorre un km mas, lo que le tarda 50ms
                System.out.println(Thread.currentThread().getName() + " ->  " + kmRestantes);
                recorrer(1);
                try{Thread.sleep(50);}catch(InterruptedException e){}
            }
        }while(2==2);
    }
    public void recorrer(int km){
        kmRestantes -= km;
    }
}
