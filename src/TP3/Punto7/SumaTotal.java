package TP3.Punto7;

public class SumaTotal {
    private int total = 0;

    public synchronized void sumar(int num) {
        total += num;
    }

    public int getTotal() {
        return total;
    }
}
