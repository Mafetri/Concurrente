package TP6.Punto6;

public class Mantenimiento implements Runnable{

    private Observatorio observatorio;

    Mantenimiento(Observatorio observatorio) {
        this.observatorio = observatorio;
    }

    public void run(){
        String nombre = Thread.currentThread().getName();
        try{
            System.out.println("El "+nombre+" 🧹 esta esperando a entrar");
            observatorio.entrarMantenimiento();
            System.out.println("El " +nombre+" 🧹 entro");
            Thread.sleep(3000);
            System.out.println("El " +nombre+" 🧹 salio");
            observatorio.salirMantenimiento();
        }catch(Exception e){}
    }
    
}
