package ActividadesObligatorias.ActividadObligatoria3.Punto1;
import java.util.*;
public class Main {
    public static void main(String[] args){
        // Cantidad de actores
        int cantidadMueblesMax=3, carpinteros=20, ensambladores = 1;

        // Declaracion
        Carpinteria carpinteria=new Carpinteria(cantidadMueblesMax);
        Thread tCarpinteros[]=new Thread[carpinteros];
        Thread tEnsamblador[]=new Thread[ensambladores];

        // Inicializacion e start de hilos
        tCarpinteros[0]= new Thread(new Carpintero(carpinteria, 1, 0), "Carpintero "+0);
        tCarpinteros[1]= new Thread(new Carpintero(carpinteria, 2, 1), "Carpintero "+1);
        tCarpinteros[2]= new Thread(new Carpintero(carpinteria, 3, 2), "Carpintero "+2);
        for(int i=3;i<carpinteros;i++){
            int tipo = random();
            tCarpinteros[i]= new Thread(new Carpintero(carpinteria, tipo, i), "Carpintero "+ tipo + " id:"+i);
            tCarpinteros[i].start();
        }
        for(int i=0;i<ensambladores;i++){
            tEnsamblador[i]= new Thread(new Ensamblador(carpinteria), "Ensamblador "+i);
            tEnsamblador[i].start();
        }
    }
    public static int random(){
        Random r = new Random();
        return r.nextInt(3)+1;
    }
}
