package Simulacros.SegundoParcial.Tema2.Punto2;

public class Atomo implements Runnable{

    private char tipo;
    private Espacio espacio;

    public Atomo(Espacio e, char tipo) {
        this.tipo = tipo;
        this.espacio = e;
    }

    public void run() {
        try{
            espacio.entrarAProceso(tipo);
            if(espacio.esperarOtrosAtomos(tipo)){
                Thread.sleep(1000);
                espacio.hacerAgua();
            }
            //System.out.println(Thread.currentThread().getName() + " 🤙🤙.");
        }catch(Exception e){}
    }
    
}
