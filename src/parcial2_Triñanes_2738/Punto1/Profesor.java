package parcial2_Triñanes_2738.Punto1;

public class Profesor implements Runnable{
    private Salon s;
    public Profesor(Salon s){
        this.s = s;
    }
    public void run() {
        try{
            while(true){
                System.out.println("El profesor espera que se llenen los cupos");
                s.iniciarClase();
                System.out.println("👩‍🏫👩‍🏫👩‍🏫👩‍🏫 El profesor inicia la clase 👩‍🏫👩‍🏫👩‍🏫👩‍🏫");
                Thread.sleep(3000);
                System.out.println("El profesor terminó la clase");
                s.terminarClase();
            }
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName() + " murio.");
        }
    }
}
