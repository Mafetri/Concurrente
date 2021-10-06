package Triñanes_2738.Ejercicio6b;

public class Corredor implements Runnable{
    private Carrera carrera;
    int pos;

    public Corredor(Carrera carrera, int pos){
        this.carrera = carrera;
        this.pos = pos;
    }

    public void run() {
        boolean exito = false;
        do{
            if(carrera.correr(pos)){
                System.out.println(Thread.currentThread().getName() + " agarró el testigo.");
                exito = true;
                correr();
                carrera.soltarTestigo(pos);
                System.out.println(Thread.currentThread().getName() + " soltó el testigo.");
            }
        }while(!exito);
        
    }
    public void correr(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    }
}
