package Simulacros.PrimerParcial.Tema2;

public class Donador implements Runnable{
    private CentroMedico centroMedico;
    public static final String rojo = "\u001B[33m";
    public static final String reset = "\u001B[0m";

    public Donador(CentroMedico centroMedico) {
        this.centroMedico = centroMedico;
    }

    public void run(){
        try{
            System.out.println("El cliente " + Thread.currentThread().getName() + " esta llamando.");
            centroMedico.llamarRecepcion();
            System.out.println("El cliente " + Thread.currentThread().getName() + " esta en la entrevista.");
            centroMedico.entrevista();
            System.out.println("El cliente " + Thread.currentThread().getName() + " esta en la extraccion.");
            centroMedico.extraccion();
            System.out.println(rojo+"El cliente " + Thread.currentThread().getName() + " se va a desayunar."+reset);
        }catch(Exception e){

        }
    }
}
