package Simulacro2do.Tema2.Punto1;
import java.util.*;
public class Usuario implements Runnable{

    private CentroImpresion centroImpresion;
    private char impresion;
    
    public Usuario(CentroImpresion c, char imp){
        this.centroImpresion = c;
        this.impresion = imp;
    }

    public void run(){
        try{
            Thread.sleep(random());
            System.out.println(Thread.currentThread().getName() + " registra impresion " + this.impresion);
            centroImpresion.registrarPeticion(this.impresion);
        }catch(InterruptedException e){
            System.out.println("Se murio el usuario ");
        }
    }

    public static int random(){
        Random ran = new Random();
        return ran.nextInt(9) * 1000;
    }
    
}
