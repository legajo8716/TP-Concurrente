import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public  class main{
    private  static Scanner reader = new Scanner(System.in);
    private  static Scanner reader1 = new Scanner(System.in);
    private  static Scanner reader2 = new Scanner(System.in);

    private static BitSet bit;
    private static ThreadPool pool;
    private int cantThread;
    private Timer timer;


    public static void  main(String[] args) {


        //ingreso de informacion
        System.out.println("ingrese cantida de thread");
        int cantThread = reader.nextInt();
        System.out.println("ingrese dificultad");

        int dificultad =  reader2.nextInt();

        System.out.println("ingrese cadena a evaluar");
        String cadena =  reader1.nextLine();
        if(cadena.isEmpty()){
            cadena=" ";
        }





        //asignacion de unidad de trabajo
        long unidadDeTrabajo = 4294967296L / cantThread;


        Buffer buffer = new Buffer(2);

        pool = new ThreadPool(cantThread, cadena, buffer,dificultad);

        pool.run();
        for (int i = 0; i < cantThread; i++) {
            long inicioAux = unidadDeTrabajo * (i);
            long finAux = unidadDeTrabajo * (i + 1);
            if (i == cantThread) {
                buffer.add(inicioAux, 4294967295L);
            } else {
                buffer.add(inicioAux, finAux);
            }
        }
    }
}
