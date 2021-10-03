package TP4.Punto10MuchasSillas;

public class Main {
    public static void main(String[] args){
        int cantEmpleados = 4;
        Confiteria confiteria = new Confiteria(4);
        Thread[] empleados = new Thread[cantEmpleados];
        Thread mozo = new Thread(new Mozo(confiteria));
        mozo.start();
        for(int i = 0; i < cantEmpleados; i++){
            empleados[i] = new Thread(new Empleado(confiteria), "Empleado " + i);
            empleados[i].start();
        }
    }
}
