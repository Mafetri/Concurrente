package TP1.Punto6;

public class Main {
    public static void main(String[] args) {
        double[] x = new double[15];

        System.out.println(accesoIndice2(x, 16));
    }
    // Asi es como viene en el tp
    public static double accesoIndice(double[] x, int pos) throws RuntimeException {
        try{
            if(0 <= pos && pos <= x.length){
                return x[pos];
            }else{
                throw new RuntimeException ("El indice " + pos + " no existe en el vector");
            }
        }catch(RuntimeException e){
            throw e;
        }
    }
    // ""Mejorado"" por mi
    public static double accesoIndice2(double[] x, int pos) throws RuntimeException {
        try{
            return x[pos];
        }catch(RuntimeException e){
            throw new RuntimeException ("El indice " + pos + " no existe en el arreglo");
        }
    }
}
