package parcial2_Triñanes_2738.Punto1;
import java.util.Random;
public class Acrobata implements Runnable{
    private Salon s;

    public Acrobata(Salon s){
        this.s = s;
    }

    public void run() {
        int primeraActividad = random();
        int segundaActividad = random();
        try{
            System.out.println(Thread.currentThread().getName() + " solicita turno para la actividad " + primeraActividad);
            if(s.solicitarTurno(primeraActividad)){
                System.out.println(Thread.currentThread().getName() + " terminó la actividad " + primeraActividad);
                segundaActividad = s.segundaActividad(primeraActividad, segundaActividad);
                System.out.println(Thread.currentThread().getName() + " terminó la actividad " + segundaActividad);
                s.salirSalon(segundaActividad);
            }else{
                System.out.println(Thread.currentThread().getName() + " no tuvo lugar para la actividad " + primeraActividad);
            }
            System.out.println(Thread.currentThread().getName() + " se fue para la casa.");
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + " murio.");
        }
    }

    public int random(){
        Random rand = new Random();
        return rand.nextInt(3)+1;
    }
}
