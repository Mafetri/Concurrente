package TP0.Punto3;
import java.util.*;

public class Administrativo extends Empleado{
    private int categoria;

    public Administrativo(String nombre, int dni, String direccion, Date fechaNacimiento, String sexo, String legajo, Date fechaIngreso, int salario, int categoria) {
        super(nombre, dni, direccion, fechaNacimiento, sexo, legajo, fechaIngreso, salario);
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getSueldoFinal(){
        int sueldoFinal = super.getSueldoFinal();

        if(categoria == 1){
            sueldoFinal += (sueldoFinal * 0.15);
        }else if(categoria == 2){
            sueldoFinal += (sueldoFinal * 0.20);
        }

        return sueldoFinal;
    }
} 