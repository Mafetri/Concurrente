package Simulacros.PrimerParcial.Tema2;

public class Entrevistador implements Runnable{
    private CentroMedico c;
    public static final String color = "\u001B[35m";
    public static final String reset = "\u001B[0m";
    public Entrevistador(CentroMedico c) {
        this.c = c;
    }
    public void run() {
        try{
            while(true){
                System.out.println("El entrevistador está esperando atender.");
                c.esperarEntrevistado();
                System.out.println(color+"El entrevistador está entrevistando."+reset);
                Thread.sleep(1000);
                c.terminarEntrevista();
            }
        }catch(Exception e){}
    }
}
