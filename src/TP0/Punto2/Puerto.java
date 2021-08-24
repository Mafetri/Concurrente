package TP0.Punto2;
import java.util.*;

public class Puerto{
    private ArrayList colAmarres;

    public Puerto(){
        colAmarres = new ArrayList();
    }
    public ArrayList getAmarres(){
        return colAmarres;
    }
    public void setAmarres(ArrayList colAmarres) {
        this.colAmarres = colAmarres;
    }

    public long registrarUnAlquiler(Barco unBarco, Cliente unCliente, Date desde, Date hasta){
        long valor = unBarco.calcularValorAlquiler((hasta.getTime() - desde.getTime()) / 1000 / 60 / 60 / 24 + 2);
        colAmarres.add(new Alquiler(desde, hasta, unCliente, unBarco, colAmarres.size(), valor));
        return valor;
    }
}