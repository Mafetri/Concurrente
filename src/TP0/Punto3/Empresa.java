package TP0.Punto3;
import java.util.*;

public class Empresa {
    // Deberia tener mas atributos pero no me dio ganas de ponercelos :D
    private ArrayList colEmpleados;

    public Empresa() {
        colEmpleados = new ArrayList();
    }

    public ArrayList getColEmpleados() {
        return colEmpleados;
    }
    public void setColEmpleados(ArrayList colEmpleados) {
        this.colEmpleados = colEmpleados;
    }

    public ArrayList listarEmpleadosAntiguos(int cantAnios){
        ArrayList colAntiguos = new ArrayList();

        for (int i = 0; i < colEmpleados.size(); i++) {
            if(((Empleado) colEmpleados.get(i)).verificarAntiguedad(cantAnios)){
                colAntiguos.add(colEmpleados.get(i));
            }
        }

        return colAntiguos;
    }
}
