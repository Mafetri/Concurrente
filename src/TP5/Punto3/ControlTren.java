package TP5.Punto3;

public class ControlTren implements Runnable{
    private Tren tren;

    public static final String verde = "\u001B[32m";
    public static final String naranja = "\u001B[33m";
    public static final String reset = "\u001B[0m";

    public ControlTren(Tren tren){
        this.tren = tren;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(verde+"El tren está esperando que se llene."+reset);
                tren.esperarLlenado();
                System.out.println(naranja+"El tren está yendo a la estacion."+reset);
                Thread.sleep(6000);
                System.out.println(verde+"El tren llego a destino"+reset);
                tren.destino();
            }
        } catch (Exception e) {
            System.out.println("El tren descarrilo.");
        }
    }
}
