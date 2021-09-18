package TP3.Punto6;

public class Gasolinera {
    private Auto surtidor;

    public synchronized boolean cargar(Auto auto){
        boolean exito = false;
        if(auto == null){
            System.out.println("> " + Thread.currentThread().getName() + " ha terminado de cargar.");
            surtidor = null;
        }else if(surtidor == null){
            System.out.println("> " + Thread.currentThread().getName() + " ha empezado a cargar.");
            this.surtidor = auto;
            exito = true;
        }
        return exito;
    }
}
