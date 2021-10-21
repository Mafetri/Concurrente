package ActividadObligatoria2.Punto1.Semaforos;

public class Hilo implements Runnable{
    private Compartido c;
    private int x, y, z, s;
    
    public Hilo(Compartido c, int x, int y, int z, int s) {
        this.c = c;
        this.s = s;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void run() {
        try{
            if(s == 1){
                System.out.println("El hilo" + Thread.currentThread().getName() + " está ejecutando s1.");
                c.s1(x, y);
            }else{
                System.out.println("El hilo" + Thread.currentThread().getName() + " está ejecutando s2.");
                c.s2(z);
            }
            System.out.println("El hilo" + Thread.currentThread().getName() + " terminó con su ejecucion.");
        }catch(Exception e){}
    }
}
