package ActividadesObligatorias.ActividadObligatoria4.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        CentroImpresion c = new CentroImpresion(5, 5, 5);
        Thread[] clientes = new Thread[10];
        Thread[] impresoras = new Thread[3];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Thread(new Cliente(i % 3, c, i), "Cliente " + i);
            clientes[i].start();
        }

        for (int i = 0; i < impresoras.length; i++) {
            impresoras[i] = new Thread(new Impresora(c, i % 2), "Impresora "+ i);
            impresoras[i].start();
        }

        try{
            for (int i = 0; i < clientes.length; i++) {
                clientes[i].join();
            }
        }catch (InterruptedException e) {}
        System.out.println("Los clientes se fueron 👁️👄👁️");

    }
}
