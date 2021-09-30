package TP4.Punto5;

public class Usuario implements Runnable {
    private CentroImpresion impresoras;
    private char tipo;
    private String archivo;

    public Usuario(String archivo, char tipo, CentroImpresion impresoras) {
        this.tipo = tipo;
        this.impresoras = impresoras;
        this.archivo = archivo;
    }

    public void run() {
        try {
            // Imprime
            Object[] impresoraUsada = impresoras.imprimir(tipo, archivo);
            Thread.sleep(5000);

            // Deja de imprimir
            impresoras.dejarImprimir((char) impresoraUsada[0], (int) impresoraUsada[1]);

            // PARA PRUEBA
            if (tipo != 'A' && tipo != 'B') {
                System.out.println("El usuario " + Thread.currentThread().getName() + " tenia " + tipo);
            }

        } catch (Exception e) {
        }
    }

}
