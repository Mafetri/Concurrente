package ActividadesObligatorias.ActividadObligatoria2.Punto1.Joins;

public class Compartido {
    private int a, b, c, w;

    public void s1(int x, int y){
        a = x+y;
    }
    public void s2(int z){
        b = z - 1;
    }

    public void s3(){
        c = a - b;
    }
    public int s4(){
        w = c + 1;
        return w;
    }

}
