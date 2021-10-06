package Simulacros.PrimerParcial.Tema2;

public class Especialista implements Runnable{
    public static final String color = "\u001B[34m";
    public static final String reset = "\u001B[0m";
    private CentroMedico c;
    public Especialista(CentroMedico c) {
        this.c = c;
    }
    public void run() {
        try{
            while(true){
                System.out.println("El especialista está esperando atender.");
                c.esperarPaciente();
                System.out.println(color+"El especialista está extrayendo sangre."+reset);
                Thread.sleep(2000);
                c.extraerSangre();
            }
        }catch(Exception e){}
    }
}
