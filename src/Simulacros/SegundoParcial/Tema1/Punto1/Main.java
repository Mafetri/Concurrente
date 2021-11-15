package Simulacros.SegundoParcial.Tema1.Punto1;

public class Main {
    public static void main(String[] args){
        int cantInsertores = 10;
        int cantExtractores = 10;
        Buffer b = new Buffer();
        Thread[] insertores = new Thread[cantInsertores];
        Thread[] extractores = new Thread[cantExtractores];

        for(int i = 0; i < cantInsertores; i++){
            insertores[i] = new Thread(new Insertor(b,i));
            insertores[i].start();
        }
        for(int i = 0; i < cantExtractores; i++){
            extractores[i] = new Thread(new Extractor(b));
            extractores[i].start();
        }
    }
}
