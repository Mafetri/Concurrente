package Simulacros.SegundoParcial.Tema1.Punto1;

public class Insertor implements Runnable{

    private Buffer buffer;
    private int i;

    public Insertor(Buffer b, int i){
        this.buffer = b;
        this.i = i;
    }

    public void run() {
        try{
            Thread.sleep(100);
            buffer.insertar(i);

        }catch(Exception e){
            System.out.println("El hilo insertor ⚰");
        }

    }
    
}
