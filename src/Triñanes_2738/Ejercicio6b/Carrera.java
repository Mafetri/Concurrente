package Triñanes_2738.Ejercicio6b;
import java.util.concurrent.locks.*;
public class Carrera {
    private Lock testigo = new ReentrantLock();
    private boolean[] posicion;

    public Carrera(int cant){
        posicion = new boolean[cant];
        posicion[0] = true;
        for(int i = 1; i < cant; i++){
            posicion[i] = false;
        }
    }

    public boolean correr(int pos){
        boolean exito = false;
        if(testigo.tryLock()){
            if(posicion[pos] == true){
                exito = true;
            }else{
                testigo.unlock();
            }
        }
        return exito;
    }

    public void soltarTestigo(int pos){
        if(pos < posicion.length){
            posicion[pos+1] = true;
            testigo.unlock();
        }
    }
}
