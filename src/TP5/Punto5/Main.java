package TP5.Punto5;

public class Main{
    public static void main(String[] args){
        // === CANTIDAD DE CLIENTES MODIFICABLE ===
        int cantClientes = 15;

        Toboganes t = new Toboganes();

        // Hilos a usar
        Thread encargado = new Thread(new Encargado(t));
        Thread[] clientes = new Thread[cantClientes];

        // Inicializacion y start de los hilos
        encargado.start();
        for(int i=0; i<clientes.length; i++){
            clientes[i] = new Thread(new Cliente(t), "Cliente " + i);
            clientes[i].start();
        }
    }
}