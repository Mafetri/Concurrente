package TP5.Punto1B;

public class Gestor implements Runnable{
    private Comedor comedor;
    int permisos;

    public Gestor(Comedor comedor, int permisos) {
        this.comedor = comedor;
        this.permisos = permisos;
    }

    public void run(){
        try{
            while(true){
                System.out.println("El gestor le permite a los perros.");
                comedor.comerPerros(permisos);
                System.out.println("El gestor espera que terminen los perros.");
                comedor.esperarVaciamiento();
                System.out.println("El gestor le permite a los gatos.");
                comedor.comerGatos(permisos);
                System.out.println("El gestor espera que terminen los gatos.");
                comedor.esperarVaciamiento();
            }
        }catch(Exception e){}
    }
}
