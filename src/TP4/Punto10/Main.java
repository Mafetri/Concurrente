package TP4.Punto10;

public class Main {
    public static void main(String[] args){
        int cantEmpleados = 5;
        Confiteria confiteria = new Confiteria();
        Thread[] empleados = new Thread[cantEmpleados];
        Thread mozo = new Thread(new Mozo(confiteria));
        mozo.start();
        for(int i = 0; i < cantEmpleados; i++){
            empleados[i] = new Thread(new Empleado(confiteria), "Empleado " + i);
            empleados[i].start();
        }
    }
}
