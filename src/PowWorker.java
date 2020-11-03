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
    int dificultad;
    boolean seguiBuscando;
      PowWorker(String cadena, int i, Buffer b, ThreadPool threadPool, int d){
         this.buffer=b;
         this.cadena=cadena;
         id=i;
         pool=threadPool;
         dificultad=d;
         seguiBuscando =true;
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
          while (i<fin && seguiBuscando){
                        byte [] aux = ByteBuffer.allocate(8).putLong(i ).array();
                        byte[] byteCadena=cadena.getBytes();
                        for(int e =0;i<4;i++){
                            aux[e]=byteCadena[e];
                         }
                        byte[] hash=messageDigest.digest(aux);
                        this.verificacionDeHash(hash,i);

                        i++;
          }
          if(i==fin){
              System.out.println("\nNo encontre el noce, Worker numero "+ this.id);
          }
    }



    private void verificacionDeHash(byte[] hash, long i) {
        if(this.cumpleConLaDificultad(hash)  ){
            System.out.println("\n----------------Informe---------------------------------");
            System.out.println("El noce es "+i+" soy el worker numero "+this.id);
            pool.encontreNoce();
            pool.getArrayByteToHexa(hash);
        }
    }


    private boolean cumpleConLaDificultad(byte[] hash) {
          Boolean resultado=true;
          for (int i=0;i<this.dificultad;i++){
              resultado=resultado && (hash[i]==0);
          }
        return resultado;
      }

    public void dejaDeBuscar() {
          this.seguiBuscando =false;
    }
}
