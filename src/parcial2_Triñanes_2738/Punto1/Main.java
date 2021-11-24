package parcial2_Triñanes_2738.Punto1;

public class Main {
    public static void main(String[] args){
        Salon s = new Salon(4, 12);
        Thread[] acrobatas = new Thread[36];
        Thread profesor = new Thread(new Profesor(s));
        profesor.start();
        for (int i = 0; i < acrobatas.length; i++){
            acrobatas[i] = new Thread(new Acrobata(s), "Acrobata " + i);
            acrobatas[i].start();
        }
    }
}
