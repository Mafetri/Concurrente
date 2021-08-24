package TP0.Punto3;
import java.util.*;

public class Tecnico extends Empleado{
    private String titulo;
    private Date fechaObtencion;

    public Tecnico(String nombre, int dni, String direccion, Date fechaNacimiento, String sexo, String legajo, Date fechaIngreso, int salario, String titulo, Date fecha) {
        super(nombre, dni, direccion, fechaNacimiento, sexo, legajo, fechaIngreso, salario);
        this.titulo = titulo;
        this.fechaObtencion = fecha;
    }

    public String getTitulo() {
        return titulo;
    }
    public Date getFechaObtencion() {
        return fechaObtencion;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setFechaObtencion(Date fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
    public int getSueldoFinal(){
        int sueldoFinal = super.getSueldoFinal();
        if(titulo.equals("Ingeniero")){
            sueldoFinal += super.getSueldoFinal()*0.15;
        }else if(titulo.equals("Licenciado")){
            sueldoFinal += super.getSueldoFinal()*0.10;
        }else{
            sueldoFinal += super.getSueldoFinal()*0.05;
        }
        return sueldoFinal;
    }
}
