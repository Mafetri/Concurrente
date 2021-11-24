package parcial2_Triñanes_2738.Punto1;

import java.util.concurrent.*;

public class Salon {
    private Semaphore mutexAcrobatas = new Semaphore(1);    // Para exclucion mutua de acrobatas
    private Semaphore semTurno;     // Para controlar la gente que puede ingresar a un turno
    private Semaphore semA1;        // Para controlar la gente de un sola actividad
    private Semaphore semA2;
    private Semaphore semA3;
    private Semaphore iniciarActividad = new Semaphore(0);
    private Semaphore finActividad = new Semaphore(0);
    private int personasMaxTurno;

    public Salon(int cantMaxActividad, int cantMaxTurno) {
        semA1 = new Semaphore(cantMaxActividad);
        semA2 = new Semaphore(cantMaxActividad);
        semA3 = new Semaphore(cantMaxActividad);
        personasMaxTurno = cantMaxTurno;
        semTurno = new Semaphore(cantMaxTurno);
    }

    // ==== Acrobata ====
    public boolean solicitarTurno(int actividad) throws InterruptedException {
        boolean realizaActividad = true;
        semTurno.acquire();
        // Intenta hacer la actividad que queria, si no puede se va a la casa
        switch (actividad) {
        case 1:
            if (!semA1.tryAcquire()) {
                realizaActividad = false;
                semTurno.release();
            }
            break;
        case 2:
            if (!semA2.tryAcquire()) {
                realizaActividad = false;
                semTurno.release();
            }
            break;
        case 3:
            if (!semA3.tryAcquire()) {
                realizaActividad = false;
                semTurno.release();
            }
        }

        // Si pudo hacer la actividad espera que termine
        if (realizaActividad) {
            iniciarActividad.release();
            finActividad.acquire();
            switch (actividad) {
                case 1:
                    semA1.release();
                    break;
                case 2:
                    semA2.release();
                    break;
                case 3:
                    semA3.release();
                    break;
                }
        }
        return realizaActividad;
    }

    public int segundaActividad(int actividad1, int actividad2) throws InterruptedException {
        mutexAcrobatas.acquire();
        System.out.println(Thread.currentThread().getName() + " hizo act1:" + actividad1 + " ahora quiere la " + actividad2);
        // Prueba con la activida de que quiere, intentando no repetir la primera
        switch (actividad1) {
        case 1:
            switch (actividad2) {
            case 2:
                if (!semA2.tryAcquire()) {
                    if (!semA3.tryAcquire()) {
                        actividad2 = 1;
                        semA1.acquire();
                    }else{
                        actividad2 = 3;
                    }
                }
                break;
            case 3:
                if (!semA3.tryAcquire()) {
                    if (!semA2.tryAcquire()) {
                        actividad2 = 1;
                        semA1.acquire();
                    }else{
                        actividad2 = 2;
                    }
                }
                break;
            default:
                if (!semA1.tryAcquire()) {
                    if (!semA2.tryAcquire()) {
                        actividad2 = 3;
                        semA3.acquire();
                    }else{
                        actividad2 = 2;
                    }
                }
                break;
            }
            break;
        case 2:
            switch (actividad2) {
            case 1:
                if (!semA1.tryAcquire()) {
                    if (!semA3.tryAcquire()) {
                        actividad2 = 2;
                        semA2.acquire();
                    }else{
                        actividad2 = 3;
                    }
                }
                break;
            case 3:
                if (!semA3.tryAcquire()) {
                    if (!semA1.tryAcquire()) {
                        actividad2 = 2;
                        semA2.acquire();
                    }else{
                        actividad2 = 1;
                    }
                }
                break;
            default:
                if (!semA2.tryAcquire()) {
                    if (!semA3.tryAcquire()) {
                        actividad2 = 1;
                        semA1.acquire();
                    }else{
                        actividad2 = 3;
                    }
                }
                break;
            }
            break;
        case 3:
            switch (actividad2) {
            case 1:
                if (!semA1.tryAcquire()) {
                    if (!semA2.tryAcquire()) {
                        actividad2 = 3;
                        semA3.acquire();
                    }else{
                        actividad2 = 2;
                    }
                }
                break;
            case 2:
                if (!semA2.tryAcquire()) {
                    if (!semA1.tryAcquire()) {
                        actividad2 = 3;
                        semA3.acquire();
                    }else{
                        actividad2 = 1;
                    }
                }
                break;
            default:
                if (!semA3.tryAcquire()) {
                    if (!semA2.tryAcquire()) {
                        actividad2 = 1;
                        semA1.acquire();
                    }else{
                        actividad2 = 2;
                    }
                }
                break;
            }
            break;
        }
        mutexAcrobatas.release();
        iniciarActividad.release();
        finActividad.acquire();
        return actividad2;
    }

    public void salirSalon(int actividad2) {
        switch (actividad2) {
        case 1:
            semA1.release();
            break;
        case 2:
            semA2.release();
            break;
        case 3:
            semA3.release();
            break;
        }
        semTurno.release();
    }

    // ==== Profesor ====
    public void iniciarClase() throws InterruptedException {
        iniciarActividad.acquire(personasMaxTurno);
    }
    public void terminarClase() throws InterruptedException {
        finActividad.release(personasMaxTurno);
    }

}
