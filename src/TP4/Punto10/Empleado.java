package TP4.Punto10;

public class Empleado implements Runnable{
    private Confiteria confiteria;

    public Empleado(Confiteria confiteria){
        this.confiteria = confiteria;
    }

    public void run(){
        boolean exito = false;
        try{
            do{
                if(confiteria.sentarse()){
                    System.out.println(Thread.currentThread().getName() +" se sentó.");
                    confiteria.comer();
                    System.out.println(Thread.currentThread().getName() +" está comiendo.");
                    dormir(3000);
                    confiteria.dejarDeComer();
                    System.out.println(Thread.currentThread().getName() +" dejó de comer.");
                    exito = true;
                }else{
                    System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  "+Thread.currentThread().getName() +" sigue trabajando.");
                    dormir(1000);
                }
            }while(!exito);
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
