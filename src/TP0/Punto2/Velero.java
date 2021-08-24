package TP0.Punto2;

public class Velero extends Barco{
    private int cantMastiles;

    public Velero(String matricula, int eslora, int ano, int cantMastiles){
        super(matricula, eslora, ano);
        this.cantMastiles = cantMastiles;
    }
    public int getCantMastiles(){
        return cantMastiles;
    }
    public void setCantMastiles(int cantMastiles){
        this.cantMastiles = cantMastiles;
    }

    public int getModulo(){
        return super.getModulo() + cantMastiles;
    }
}
