package TP5.Punto5;

public class Encargado implements Runnable {
    private Toboganes toboganes;

    public Encargado(Toboganes toboganes) {
        this.toboganes = toboganes;
    }

    public void run() {
        try{
            // Mientras el universo exista
            while(true){
                // El empleado espera a algun cliente
                System.out.println("El empleado está esperando a un cliente.");
                toboganes.atender();

                System.out.println("El empleado está tomando una desicion.");
                toboganes.asignarTobogan();
            }
        }catch(Exception e){
            System.out.println(e+" al encargado no puede seguir en su puesto.");
        }
    }
}
