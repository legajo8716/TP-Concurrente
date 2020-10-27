import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PowWorker extends Thread{
    ArrayList<Long> barrido;
    String cadena;
    MessageDigest messageDigest;

    Buffer buffer;
    int id;
      PowWorker(String cadena, int i,Buffer b){
         this.buffer=b;
        this.cadena=cadena;
         id=i;
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
        for(long i=inicio;i<fin;i++){
            byte[] aux=(cadena+i).getBytes();
            byte[] hash=messageDigest.digest(aux);
            if(hash[0]==0 && hash[1]==0 && hash[2]==0 && hash[4]==0 ){
                System.out.println("llegue negrito soy thread numero "+this.id);
            }
        }
    }
}
