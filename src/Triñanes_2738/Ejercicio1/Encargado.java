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

                // Chequea  que tobogan se liberó para asignarselo al proximo cliente chequeando cada 100ms
                // (es una espera activa, pero es la unica forma que encontré para que los clientes puedan
                // usar el tobogan que se desocupe "primero" sin hacer fila en los toboganes sino que el
                // empleado se los asigne cuando sepa cual fue el primero en liberarse)
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
