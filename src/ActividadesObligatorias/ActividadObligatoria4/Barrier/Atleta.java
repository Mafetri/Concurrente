package ActividadesObligatorias.ActividadObligatoria4.Barrier;

import java.util.Random;

public class Atleta implements Runnable{

    private Carrera carrera;
    private int id;

    public Atleta(Carrera carrera, int id){
        this.carrera = carrera;
        this.id = id;
    }

    public void run() {
        try{
            System.out.println("🧍 El "+Thread.currentThread().getName() + " esperando 😀");
            carrera.correr(id);
            System.out.println(Thread.currentThread().getName() + " está corriendo.");
            Thread.sleep(100*random());
            System.out.println(Thread.currentThread().getName() + " dejo de correr.");
            carrera.dejarCorrer(id);
            System.out.println(Thread.currentThread().getName() + " se fue a la casa pa. 🥶🥶");
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + e+ "  F en el chat. ☠️☠️");
        }
    }
    
    public int random(){
        Random rand = new Random();
        return rand.nextInt(10)+20;
    }

}