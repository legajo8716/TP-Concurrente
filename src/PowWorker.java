import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PowWorker extends Thread{
    ArrayList<Long> barrido;
    String cadena;
    MessageDigest messageDigest;
    ThreadPool pool;
    Buffer buffer;
    int id;
      PowWorker(String cadena, int i, Buffer b, ThreadPool threadPool){
         this.buffer=b;
        this.cadena=cadena;
         id=i;
         pool=threadPool;
     }
     @Override
    public synchronized void run()  {
        barrido=buffer.pop();
        long inicio= barrido.get(0);
       long  fin=barrido.get(1);
       System.out.println("thread numero "+this.id+" inicio "+inicio+"fin "+fin);
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        buscar(inicio, fin);
    }
        public synchronized   void buscar(long inicio, long fin){
          long i=inicio;
          while (i<fin && pool.noceEncontrado==false){

            byte [] aux = ByteBuffer.allocate(8).putLong(i ).array();
            byte[] byteCadena=cadena.getBytes();
            for(int e =0;i<4;i++){
                aux[e]=byteCadena[e];
            }
            byte[] hash=messageDigest.digest(aux);
           // System.out.println("Thread numero "+this.id+"buscando en posicion numero "+i);
            if(hash[0]==0 && hash[1]==0 && hash[2]==0  ){
                System.out.println("El noce es "+i+" soy el worker numero "+this.id);
                pool.encontreNoce();
                pool.getArrayByteToHexa(hash);
            }
            i++;
          }
    }
}
