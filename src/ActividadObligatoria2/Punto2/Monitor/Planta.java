package ActividadObligatoria2.Punto2.Monitor;

public class Planta {
    public synchronized void embotellar() throws InterruptedException {
        this.wait();
    }
    public synchronized void cajaLlena(){
        this.notify();
    }
    public synchronized void adquiereCaja() throws InterruptedException{
        this.wait();
    }
    public synchronized void darCaja(){
        this.notify();
    }
}
