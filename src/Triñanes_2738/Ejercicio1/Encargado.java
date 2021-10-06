package Triñanes_2738.Ejercicio1;

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

                // Toma la decision de que tobogan debe usar el cliente chequeando cada 100ms
                System.out.println("El empleado está tomando una desicion.");
                while(!toboganes.asignarTobogan()){
                    Thread.sleep(100);
                }
            }
        }catch(Exception e){
            System.out.println(e+" al encargado no puede seguir en su puesto.");
        }
    }
}
