package TP6.Punto2;

public class Main {
    public static void main(String[] args) {
        Museo m = new Museo();
        Thread termometro = new Thread(new Termometro(m));
        Thread[] clientes = new Thread[200];
        Thread[] jubilados = new Thread[100];
        termometro.start();
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Thread(new Cliente(m), "Cliente " + i);
            clientes[i].start();
        }
        for (int i = 0; i < jubilados.length; i++) {
            jubilados[i] = new Thread(new Jubilado(m), "Jubilados " + i);
            jubilados[i].start();
        }
    }
}
