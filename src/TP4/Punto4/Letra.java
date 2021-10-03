package TP4.Punto4;

public class Letra implements Runnable {
    private char letra;
    private int cantVeces;
    private Cadena cadena;

    public Letra(char letra, int cantVeces, Cadena cadena) {
        this.letra = letra;
        this.cantVeces = cantVeces;
        this.cadena = cadena;
    }

    public void run() {
        try{
            cadena.imprimir(this);
        }catch(Exception e){
            System.out.println("Error hilo " + Thread.currentThread().getName());
        }
        
    }

    public char getLetra() {
        return this.letra;
    }
    public int getCantVeces(){
        return this.cantVeces;
    }

}
