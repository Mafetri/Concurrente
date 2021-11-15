package Simulacros.SegundoParcial.Tema2.Punto1;

public class Impresora implements Runnable{
    private CentroImpresion c;
    public Impresora(CentroImpresion c){
        this.c = c;
    }
    public void run(){
        try{
            while(true){
                int buffer = c.accederBuffers();
                Thread.sleep(2000);
                c.imprimir(buffer);
            }
        }catch(Exception e){System.out.println("");}
    }
}
