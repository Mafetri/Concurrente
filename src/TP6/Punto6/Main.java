package TP6.Punto6;

public class Main {
    public static void main(String[] args){
        Observatorio o = new Observatorio();
        Thread[] visitantes = new Thread[120];
        Thread[] lisiados = new Thread[30];
        Thread[] mantenimiento = new Thread[15];
        Thread[] investigadores = new Thread[2];
        
        for(int i = 0; i < mantenimiento.length; i++){
            mantenimiento[i] = new Thread(new Mantenimiento(o), "Limpiador " + i);
            mantenimiento[i].start();
        }

        for(int i = 0; i < lisiados.length; i++){
            lisiados[i] = new Thread(new Lisiado(o), "Lisiado " + i);
            lisiados[i].start();
        }
        
        for(int i = 0; i < visitantes.length; i++){
            visitantes[i] = new Thread(new Visitante(o), "Visitante " + i);
            visitantes[i].start();
        }
        
        for(int i = 0; i < investigadores.length; i++){
            investigadores[i] = new Thread(new Investigador(o), "Investigador " + i);
            investigadores[i].start();
        }
    }
}
