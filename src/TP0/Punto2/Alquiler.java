package TP0.Punto2;
import java.util.*;

public class Alquiler {
    private Date fechaInicial;
    private Date fechaFinal; 
    private Cliente cliente; 
    private Barco barco;
    private int posAmarre;
    private long valor;

    public Alquiler(Date fechaInicial, Date fechaFinal, Cliente cliente, Barco barco, int posAmarre, long valor) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cliente = cliente;
        this.barco = barco;
        this.posAmarre = posAmarre;
        this.valor = valor;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }
    public Date getFechaFinal() {
        return fechaFinal;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Barco getBarco() {
        return barco;
    }
    public int getPosAmarre() {
        return posAmarre;
    }
    public long getValor() {
        return valor;
    }
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setBarco(Barco barco) {
        this.barco = barco;
    }
    public void setPosAmarre(int posAmarre) {
        this.posAmarre = posAmarre;
    }
    public void setValor(long valor) {
        this.valor = valor;
    }


}
