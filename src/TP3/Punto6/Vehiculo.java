package TP3.Punto6;

public class Vehiculo{
    private int kmFaltantesParaElService;
    private String patente;
    private String modelo;
    private String marca;

    // constructor
    public Vehiculo(int kmFaltantesParaElService, String patente, String modelo, String marca) {
        this.kmFaltantesParaElService = kmFaltantesParaElService;
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }


    public int getKmFaltantesParaElService() {
        return kmFaltantesParaElService;
    }

    public void setKmFaltantesParaElService(int kmFaltantesParaElService) {
        this.kmFaltantesParaElService = kmFaltantesParaElService;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    
}
