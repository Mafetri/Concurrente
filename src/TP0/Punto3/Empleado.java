package TP0.Punto3;
import java.util.*;

public class Empleado extends Persona{
    private String legajo;
    private Date fechaIngreso;
    private int salario;

    public Empleado(String nombre, int dni, String direccion, Date fechaNacimiento, String sexo, String legajo, Date fechaIngreso, int salario) {
        super(nombre, dni, direccion, fechaNacimiento, sexo);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;        
    }

    public String getLegajo() {
        return legajo;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public int getSalario() {
        return salario;
    }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }

    public boolean verificarAntiguedad(int cantAnios){
        boolean aRetornar = false;
        if((new Date().getTime() - fechaIngreso.getTime())/1000/60/60/24/365 >= cantAnios){
            aRetornar = true;
        }
        return aRetornar;
    }
    public int getSueldoFinal(){
        return salario;
    }
}
