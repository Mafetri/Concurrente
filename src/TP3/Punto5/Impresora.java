package TP3.Punto5;

public class Impresora {
    private int aes = 0;
    private int bs = 0;
    private int cs = 0;

    public synchronized boolean esTurno(){
        boolean exito = false;
        // Si el hilo actual todavia no imprimio todas sus veces, entonces imprime
        // y devuelve true
        if(Thread.currentThread().getName().equals("A") && aes < 1){
            imprimir();
            exito = true;
        }else if(Thread.currentThread().getName().equals("B") && aes == 1 && bs < 2){
            imprimir();
            exito = true;
        }else if(Thread.currentThread().getName().equals("C") &&  aes == 1 && bs == 2 && cs < 3){
            imprimir();
            exito = true;
        } else if(aes >= 1 && bs >= 2 && cs >= 3){
            // Si el limite se cumplió, se reinician las variables
            aes = 0;
            bs = 0;
            cs = 0;
        }
        return exito;
    }
    // No necesita synchronized ya que es llamado desde esTurno() y hasta que no termine el hilo actual
    // no va a soltar el lock que le dio el esTurno()
    public void imprimir(){
        System.out.print(Thread.currentThread().getName());
        switch(Thread.currentThread().getName()){
            case "A": aes++; break;
            case "B": bs++; break;
            case "C": cs++;
        }
    }
}
