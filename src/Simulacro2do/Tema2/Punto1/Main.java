package Simulacro2do.Tema2.Punto1;

public class Main {
    public static void main(String[] args){
        CentroImpresion c = new CentroImpresion(2);
        Thread[] usuarios = new Thread[7];
        Thread impresora = new Thread(new Impresora(c));
        impresora.start();
        for(int i = 0; i < usuarios.length; i++){
            usuarios[i] = new Thread(new Usuario(c, (char)(i+65)), "Usuario " + i);
            usuarios[i].start();
        }
    }
}
