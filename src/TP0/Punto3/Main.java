package TP0.Punto3;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Empleado empleado = new Empleado("Jose", 34242, "Juan B Justo", (new GregorianCalendar(1997, 7, 23)).getTime(), "Masculino", "Fai-2738", (new GregorianCalendar(2009, 7, 23)).getTime(), 33000);
        Tecnico empleado2 = new Tecnico("Jose", 34242, "Juan B Justo", (new GregorianCalendar(1997, 7, 23)).getTime(), "Masculino", "Fai-2738", (new GregorianCalendar(2016, 7, 23)).getTime(), 33000, "Ingeniero", (new GregorianCalendar(2010, 7, 23)).getTime());
        Empresa empresa = new Empresa();
        empresa.getColEmpleados().add(empleado);
        empresa.getColEmpleados().add(empleado2);

        System.out.println(empresa.listarEmpleadosAntiguos(5).toString());

        System.out.println(empleado2.getSueldoFinal());
    }
}
