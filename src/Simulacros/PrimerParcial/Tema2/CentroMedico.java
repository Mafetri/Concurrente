package Simulacros.PrimerParcial.Tema2;
import java.util.concurrent.*;
public class CentroMedico {
    Semaphore llamada = new Semaphore(0);
    Semaphore atender = new Semaphore(0);
    Semaphore telefono = new Semaphore(0);
    Semaphore esperarEntrevista = new Semaphore(0, true);
    Semaphore entrevista = new Semaphore(0);
    Semaphore entrevistador = new Semaphore(0);
    Semaphore esperarExtraccion = new Semaphore(0);
    Semaphore extractor = new Semaphore(0);
    Semaphore extraccion = new Semaphore(0);

    // ===== Donante =====
    public void llamarRecepcion() throws InterruptedException {
        llamada.acquire();
        atender.release();
        telefono.acquire();
    }
    public void entrevista() throws InterruptedException{
        esperarEntrevista.acquire();
        entrevistador.release();
        entrevista.acquire();
    }
    public void extraccion() throws InterruptedException{
        esperarExtraccion.acquire();
        extractor.release();
        extraccion.acquire();
    }

    // ===== Recepcionista =====
    public void esperarLlamado() throws InterruptedException{
        llamada.release();
        atender.acquire();
    }
    public void cortarLlamada(){
        telefono.release();
    }

    // ==== Entrevistador ====
    public void esperarEntrevistado() throws InterruptedException{
        esperarEntrevista.release();
        entrevistador.acquire();
    }
    public void terminarEntrevista(){
        entrevista.release();
    }

    // ==== Especialista ====
    public void esperarPaciente() throws InterruptedException{
        esperarExtraccion.release();
        extractor.acquire();
    }
    public void extraerSangre(){
        extraccion.release();
    }
}
