package TP0.Punto3;
import java.util.*;

public class Persona {
    private String nombre;
    private int dni; 
    private String direccion;
    private Date fechaNacimiento;
    private String sexo;

    public Persona(String nombre, int dni, String direccion, Date fechaNacimiento, String sexo){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getDni(){
        return this.dni;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public Date getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public String getSexo(){
        return this.sexo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDni(int dni){
        this.dni = dni;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
}
