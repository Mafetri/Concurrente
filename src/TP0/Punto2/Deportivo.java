package TP0.Punto2;

public class Deportivo extends Barco{
    private int potencia; 

    public Deportivo(String matricula, int eslora, int ano, int potencia){
        super(matricula, eslora, ano);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia){
        this.potencia = potencia;
    }

    public int getModulo(){
        return super.getModulo() + potencia;
    }
}
