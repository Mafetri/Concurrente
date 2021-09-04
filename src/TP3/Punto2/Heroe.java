package TP3.Punto2;

public class Heroe {
    private int vida = 10;

    public Heroe() {}

    public int getVida() {
        return vida;
    }

    public synchronized void alterarVida(int hp) {
        vida += hp;
    }
}
