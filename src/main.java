import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public  class main{
    private  static Scanner reader = new Scanner(System.in);
    private static BitSet bit;
    private static ThreadPool pool;
    private int cantThread;

    public static void  main(String[] args) throws NoSuchAlgorithmException {
        //ingreso de informacion
        System.out.println("ingrese cantida de thread");
        int cantThread=reader.nextInt();;
        System.out.println("ingrese cadena a evaluar");
        String cadena  =reader.nextLine();

        //asignacion de unidad de trabajo
        int unidadDeTrabajo= (int) (Math.pow(2,(32-cantThread))/4);
        int init=0;
        int finaly=unidadDeTrabajo;
        Buffer buffer=new Buffer();
        
        for(int i=0;i<cantThread-1;i++){
            buffer.add(init,finaly);
           init=finaly;
           finaly=finaly+unidadDeTrabajo;
        }



         System.out.println( "llegue wachin");

        pool=new ThreadPool(3,  2,buffer) ;
        System.out.println( "llegue wachin");

        pool.run();






    }

}
