package TP0.Punto2;

public class Barco {
    private String matricula;
    private int eslora;
    private int anoFabricacion;
    private static int valorBase = 200;

    public Barco(String matricula, int eslora, int ano){
        this.matricula = matricula;
        this.eslora = eslora;
        this.anoFabricacion = ano;
    }

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }
    public int getEslora() {
        return eslora;
    }
    public int anoFabricacion() {
        return anoFabricacion;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setEslora(int eslora){
        this.eslora = eslora;
    }
    public void setAnoFabricacion(int ano){
        this.anoFabricacion = ano;
    }

    // De aplicacion
    public int getModulo(){
        return eslora * 10;
    }
    public long calcularValorAlquiler(long cantDias){
        return (cantDias * getModulo()) + valorBase;
    }
}
