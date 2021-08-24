package TP1;

public class Punto7 {
    public static void main(String[] args){
        // Punto A)
        // No habria ninguna exepcion  

        // Punto B)
        // Tira NumberFormatException porque se hace un parseint de una W
        // entonces lo catchea y suma 1 a i, despues hace el finally y lo que le sigue

        try{
            System.out.println(b());
        }catch(Exception e){    
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("======================");

        // Punto C)
        // Al cometer otra excepcion de NumerFormatException, y no hay catch que le siga para
        // la excepcion, ejecuta lo que esta en finally pero al terminar corta la ejecicion y no sigue
        try{
            System.out.println(c());
        }catch(Exception e){    
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static int b(){
        int i = 0;
        try{
            i += 1;
            i += Integer.parseInt("W");
            i += 1;
            System.out.println("Valor try:" + i);       
        }catch(NumberFormatException e){
            i += Integer.parseInt("42");
            System.out.println("Valor catch:" + i);          
        }finally{
            i += 1;
            System.out.println("Valor finally:" + i);
        }
        i += 1;
        System.out.println("Valor return:" + i);
        return i;
    }

    public static int c(){
        int i = 0;
        try{
            i += 1;
            i += Integer.parseInt("W");
            i += 1;
            System.out.println("Valor try:" + i);       
        }catch(NumberFormatException e){
            i += Integer.parseInt("W");
            System.out.println("Valor catch:" + i);          
        }finally{
            i += 1;
            System.out.println("Valor finally:" + i);
        }
        i += 1;
        System.out.println("Valor return:" + i);
        return i;
    }
}
