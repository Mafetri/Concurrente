package ActividadesObligatorias.ActividadObligatoria4.Barrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Carrera {
    CyclicBarrier[] barreras;
    int cantCorredores;

    public Carrera(int cantCorredores) {
        this.cantCorredores = cantCorredores;
        barreras = new CyclicBarrier[cantCorredores];
        barreras[0] = new CyclicBarrier(1);
        for(int i = 1; i < cantCorredores; i++){
            barreras[i] = new CyclicBarrier(2);
        }
    }

    public void correr(int id) throws BrokenBarrierException, InterruptedException {
        barreras[id].await();
    }
    public void dejarCorrer(int id) throws BrokenBarrierException, InterruptedException{
        if(id != cantCorredores-1){
            barreras[id+1].await();
        }
    }
}
