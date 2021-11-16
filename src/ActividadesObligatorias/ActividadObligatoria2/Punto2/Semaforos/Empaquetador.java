package ActividadesObligatorias.ActividadObligatoria2.Punto2.Semaforos;

public class Empaquetador implements Runnable{
    private Planta p;

    public Empaquetador(Planta p) {
        this.p = p;
    }

    public void run() {
        try{
            while(true){
                System.out.println("El empaquetador esta esperando a que se llene la caja");
                p.adquiereCaja();
                System.out.println("El empaquetador esta sellando la caja");
                Thread.sleep(3000);
                System.out.println("El empaquetador da una caja nueva al embotellador");
                p.darCaja();

            }

        }catch(Exception e){}
    }
}
