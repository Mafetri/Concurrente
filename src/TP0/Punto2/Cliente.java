package TP0.Punto2;

public class Cliente {
    private String nombre;
    private String apellido;
    private int nroCelular;
    private String email;

    public Cliente(String nombre, String apellido, String email, int nroCelular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nroCelular = nroCelular;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getEmail(){
        return email;
    }
    public int getNroCelular(){
        return nroCelular;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setNroCelular(int nro){
        this.nroCelular = nro;
    }
}
