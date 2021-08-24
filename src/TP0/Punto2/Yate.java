package TP0.Punto2;

public class Yate extends Barco{
    private int potencia; 
    private int camarotes;

    public Yate(String matricula, int eslora, int ano, int potencia, int camarotes){
        super(matricula, eslora, ano);
        this.potencia = potencia;
        this.camarotes = camarotes;
    }

    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia){
        this.potencia = potencia;
    }
    public int getCamarotes() {
        return camarotes;
    }
    public void setCamarotes(int camarotes){
        this.camarotes = camarotes;
    }

    public int getModulo(){
        return super.getModulo() + potencia + camarotes;
    }
}
