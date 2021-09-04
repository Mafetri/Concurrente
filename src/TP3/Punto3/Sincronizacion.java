package TP3.Punto3;

public class Sincronizacion {
    public static void main(String[] args) {
        /*
        Respuestas:
        A)  El metodo sumMatriz al no ser sincronizado, cuando un hilo entra a hacer su suma, interrumpe la del otro   
            haciendo que se mezcle el contador que llevaban
        B)  Los joins no cambian nada de la ejecucion, ya que al estar ambos dentro del try de main,
            ambos tienen que terminar para que continue el main, pero no afecta a ninguno de los dos hilos del try.
        C)  
            Cambio 1: (Metodo sincronizado)
                Clase: SumaMatriz
                    int sumMatriz(int nums[]){...}  ====> synchronized int sumMatriz(int nums[]){...}
            Cambio 2: (Bloque sincronizado)
                Clase: SumaMatriz
                    Metodo: sumMatriz
                        ...
                        synchronized(this){
                            for(...){...}
                        }
                        ...
            Cambio 3: (Bloque sincronizado)
                Clase SumaMatriz
                    Metodo: sumMatriz
                        ...
                        for(...){
                            synchronized(this){
                                sum += nums[i];
                                System.out.println("Total acumulado de "+Thread.currentThread().getName()+"es "+sum);
                            }
                            ....
                        }
            Cambio 4: (el que mejor me resultó) (Bloque sincronizado)
                Clase: MiHilo
                    Metodo: run()
                        ...
                        synchronized(MiHilo.class){
                            resp=sumaM.sumMatriz(arr);
                            System.out.println("Suma para "+hilo.getName()+ " es "+resp);
                            System.out.println(hilo.getName()+ " terminado.");
                        }
            Cambio 5: (parecido al 4, es como un join, espera a que un hilo termine antes de empezar el otro) (Metodo sincronizado)
                Clase: MiHilo
                    public void run(){...} ====> public synchronized void run(){...}

        }

             
        */
        int arr[] = { 1, 2, 3, 4, 5 };// puede utilizar distintos valores para ver los cambios con otros valores.
        MiHilo mh1 = MiHilo.creaEInicia("#1", arr);
        MiHilo mh2 = MiHilo.creaEInicia("#2", arr);
        
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        
        
    }
}
