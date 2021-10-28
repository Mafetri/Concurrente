package TP5.Punto3;

public class Vendedor implements Runnable {
    private Tren tren;

    public Vendedor(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while(true){
            try{
                System.out.println("El vendedor esta esperando un cliente");
                tren.esperarCliente();
                Thread.sleep(500);
                System.out.println("El vendedor vendio un ticket");
                tren.venderTicket();
            }catch(Exception e){
                System.out.println("El vendedor se pegó un tiro.");
            }
        }

    }
}
