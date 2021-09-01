package TP2.Punto3;

public class Main {
    // A) Si lo ejecuta varias veces, que sucede?
    // Lo que sucede es que hay veces que Maria empieza, y/o termina, antes que Jose,
    // pero hay veces que sucede a la inversa, depende de quien tome timepo de cpu antes.
    public static void main(String[] args){
        new ThreadEjemplo("José").start();
        new ThreadEjemplo("Maria").start();

        System.out.println("Termina main");
    }
}
