package ActividadesObligatorias.ActividadObligatoria4.Barrier;

public class Main {
    public static void main(String[] args){
        int cantidadAtletas=15;
        Carrera carrera=new Carrera(cantidadAtletas);
        Thread atletas[] = new Thread[cantidadAtletas];
        for (int i = 0; i < cantidadAtletas; i++) {
            atletas[i] = new Thread(new Atleta(carrera, i), "Atleta " + i);
            atletas[i].start();
        }
    }
}
