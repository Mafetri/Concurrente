package TP4.Punto9;
import java.util.concurrent.locks.*;

public class Jaula {
    private Lock plato = new ReentrantLock();;
    private Lock rueda = new ReentrantLock();;
    private Lock hamaca = new ReentrantLock();; 

    public void obtenerPlato(){
        plato.lock();
    }
    
    public void soltarPlato(){
        plato.unlock();
    }
    
    public void obtenerRueda(){
        rueda.lock();
    }
    public void soltarRueda(){
        rueda.unlock();
    }
    
    public void obtenerHamaca(){ 
        hamaca.lock();
    }

    public void soltarHamaca(){
        hamaca.unlock();
    }
}
