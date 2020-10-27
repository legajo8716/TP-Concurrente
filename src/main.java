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

    public static void  main(String[] args)  {
        //ingreso de informacion
        System.out.println("ingrese cantida de thread");
        int cantThread=reader.nextInt();
        System.out.println("ingrese cadena a evaluar");
        String cadena  =reader.next();

        //asignacion de unidad de trabajo
        long unidadDeTrabajo = 4294967296L/cantThread;


        Buffer buffer= new Buffer(2);
        pool=new ThreadPool(cantThread,cadena,buffer) ;
        pool.run();
        for (int i=0;i<cantThread;i++){
            long inicioAux=unidadDeTrabajo*(i);
            long finAux=unidadDeTrabajo*(i+1);
            System.out.println(i + "estoy produciendo"+finAux );

            buffer.add(inicioAux, finAux);

        }


        ;









         System.out.println( "llegue wachin");

        System.out.println( "llegue wachin");







    }

}
