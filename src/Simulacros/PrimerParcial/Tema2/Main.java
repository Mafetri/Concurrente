package Simulacros.PrimerParcial.Tema2;

public class Main {
    public static void main(String[] args){
        CentroMedico c = new CentroMedico();
        Thread recepcionista = new Thread(new Recepcionista(c));
        Thread especialista = new Thread(new Especialista(c));
        Thread entrevistador = new Thread(new Entrevistador(c));
        Thread[] donadores = new Thread[6];
        recepcionista.start();
        especialista.start();
        entrevistador.start();
        for(int i = 0; i < 6; i++){
            donadores[i] = new Thread(new Donador(c), "Donador " + i);
            donadores[i].start();
        }
    }
}
