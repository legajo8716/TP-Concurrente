import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public  class main{
    private static int dimension;

    private static BitSet bit;
    private static ThreadPool pool;

    public static void  main(String[] args) throws NoSuchAlgorithmException {


         


        Buffer buffer= new Buffer(5,3);
         System.out.println( "llegue wachin");

        pool=new ThreadPool(3,  2,buffer) ;
        System.out.println( "llegue wachin");

        pool.run();






    }

}
