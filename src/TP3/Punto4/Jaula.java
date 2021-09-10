package TP3.Punto4;

public class Jaula {
    private Hamster plato;
    private Hamster rueda;
    private Hamster hamaca; 

    public synchronized void setPlato(Hamster plato){
        this.plato = plato;
        System.out.println("> El hamster " + Thread.currentThread().getName() + " esta en el plato.");
        if(plato == null){
            System.out.println(Thread.currentThread().getName());
        }
    }
    public Hamster getPlato() {
        return plato;
    }
    public synchronized void setRueda(Hamster rueda){
        this.rueda = rueda;
        System.out.println("> El hamster " + Thread.currentThread().getName() + " esta en la rueda.");
    }      
    public Hamster getRueda() {
        return rueda;
    }
    public synchronized void setHamaca(Hamster hamaca){
        this.hamaca = hamaca;
        System.out.println("> El hamster " + Thread.currentThread().getName() + " esta en la hamaca.");
    }
    public Hamster getHamaca() {
        return hamaca;
    }
}
