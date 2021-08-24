package TP0.Punto2;
import java.util.*;

public class Main {
    public static void main(String[] args) {;
        Yate barco1 = new Yate("AB183", 23, 1998, 35, 2);
        Velero barco2 = new Velero("AB183", 23, 1998, 1);
        Deportivo barco3 = new Deportivo("AB183", 23, 1998, 32);
        Cliente elUnico = new Cliente("Manuel", "Triñanes", "@", 233);
        Puerto puerto = new Puerto();
        long valor = puerto.registrarUnAlquiler(barco1, elUnico, new Date(), (new GregorianCalendar(2021, 7, 23)).getTime());
        long valor2 = puerto.registrarUnAlquiler(barco2, elUnico, new Date(), (new GregorianCalendar(2021, 7, 23)).getTime());

        System.out.println(valor);
        System.out.println(valor2);
        System.out.println((puerto.getAmarres()).toString());
    }
}
