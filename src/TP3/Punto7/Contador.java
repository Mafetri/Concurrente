package TP3.Punto7;

public class Contador implements Runnable{
    private SumaTotal sumaTotal;
    private int[] arreglo;
    private int inicio;
    private int fin;

    public Contador(int[] arreglo, SumaTotal sumaTotal, int inicio, int fin){
        this.arreglo = arreglo;
        this.sumaTotal = sumaTotal;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run() {
        for(int i = inicio; i < fin; i++){
            sumaTotal.sumar(arreglo[i]);
        }
    }
}
