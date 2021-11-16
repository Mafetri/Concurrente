package ActividadesObligatorias.ActividadObligatoria2.Punto2.Semaforos;

public class Main {
    public static void main(String[] args){
        Planta p = new Planta();
        Thread embotellador = new Thread(new Embotellador(p));
        Thread empaquetador = new Thread(new Empaquetador(p));
        
        embotellador.start();
        empaquetador.start();
    }
}
