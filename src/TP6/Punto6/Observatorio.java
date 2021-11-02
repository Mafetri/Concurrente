package TP6.Punto6;

public class Observatorio {
    private int capacidadMax = 50;
    private int cantidadOcupantes = 0;
    private int cantidadVisitantes = 0;
    private int cantidadLisiados = 0;
    private boolean investigador = false;

    // ==== Visitante ====
    public synchronized void entrarVisitante() throws InterruptedException{
        while(cantidadOcupantes >= capacidadMax || investigador != false){
            wait();
        }
        System.out.println(Thread.currentThread().getName() +" -> " +cantidadOcupantes);
        cantidadOcupantes++;
        cantidadVisitantes++;
    }
    public synchronized void salirVisitante() throws InterruptedException{
        cantidadOcupantes--;
        cantidadVisitantes--;
        notifyAll();
    }

    // ==== Liciado ====
    public synchronized void entrarLisiado() throws InterruptedException{
        while(cantidadOcupantes >= capacidadMax || investigador != false){
            wait();
        }
        System.out.println("Cambio la capacidad a 30 ");
        capacidadMax = 30;
        cantidadVisitantes++;
        cantidadOcupantes++;
        cantidadLisiados++;
    }
    public synchronized void salirLisiado() throws InterruptedException{
        cantidadOcupantes--;
        cantidadVisitantes--;
        cantidadLisiados--;
        if(cantidadLisiados == 0){
            capacidadMax = 50;
        }
        System.out.println("Cambio la capacidad a 50 ");
        notifyAll();
    }

    // ==== Investigador ====
    public synchronized void entrarInvestigador() throws InterruptedException{
        while(cantidadOcupantes != 0){
            wait();
        }
        investigador = true;
        cantidadOcupantes++;
    }
    public synchronized void salirInvestigador() throws InterruptedException{
        investigador = false;
        cantidadOcupantes--;
        notifyAll();
    }

    // ==== Mantenimiento ====
    public synchronized void entrarMantenimiento() throws InterruptedException{
        while(cantidadVisitantes != 0 || investigador ||cantidadOcupantes >= capacidadMax){
            wait();
        }
        cantidadOcupantes++;
    }
    public synchronized void salirMantenimiento() throws InterruptedException{
        cantidadOcupantes--;
        notifyAll();
    }
}
