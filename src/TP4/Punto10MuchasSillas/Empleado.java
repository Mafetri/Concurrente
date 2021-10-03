package TP4.Punto10MuchasSillas;

public class Empleado implements Runnable{
    private Confiteria confiteria;

    public Empleado(Confiteria confiteria){
        this.confiteria = confiteria;
    }

    public void run(){
        int sillaUsada = -1;
        try{
            do{
                sillaUsada = confiteria.sentarse();
                if(sillaUsada != -1){
                    System.out.println(Thread.currentThread().getName() +" se sentó en la silla " + sillaUsada);
                    confiteria.comer();
                    System.out.println(Thread.currentThread().getName() +" está comiendo.");
                    dormir(3000);
                    confiteria.dejarDeComer(sillaUsada);
                    System.out.println(Thread.currentThread().getName() +" dejó de comer.");
                }else{
                    System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "+Thread.currentThread().getName() +" sigue trabajando.");
                    dormir(1000);
                }
            }while(sillaUsada == -1);
        }catch(Exception e){
            System.out.println("F por el empleado x.");
        }
    }
    public void dormir(int i){
        try{
            Thread.sleep(i);
        }catch(Exception e){}
    }

}
