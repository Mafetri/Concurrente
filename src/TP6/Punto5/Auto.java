package TP6.Punto5;

public class Auto implements Runnable {
    
    private char direccion;
    private Puente puente;

    Auto(char direccion, Puente puente) {
        this.direccion = direccion;
        this.puente = puente;
    }

    public void run() {
        String auto = Thread.currentThread().getName();
        try{
            if(this.direccion == 's'){
                puente.entrarCocheDelSur();
                Thread.sleep(1000);
                System.out.println("El "+auto+ " cruzo");
                puente.salirCocheDelSur();
            }else{
                puente.entrarCocheDelNorte();
                Thread.sleep(1000);
                System.out.println("El "+auto+ " cruzo");
                puente.salirCocheDelNorte();
            }
            System.out.println("El "+auto+ " 🧨");
        }catch(Exception e){
            System.out.println("El "+auto+ " se tiro del puente");
        }
    }
}
