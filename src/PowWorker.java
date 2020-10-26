import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class PowWorker extends Thread{
    int barrido;
    String cadena;
    MessageDigest messageDigest;
    Integer inicio;
    Integer fin;
    int id;
     PowWorker(ArrayList<Integer> barrido, String cadena, int i){
         inicio= barrido.get(0);
         fin=barrido.get(1);
        this.cadena=cadena;
         id=i;

    }
    //[0, 2^29), [2^29, 2^30), [2^30, 2^31) y [2^31, 2^32)


    @Override
    public synchronized void run()  {
        super.run();
        System.out.println(id);

        cadena = "Hola";

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        buscar();
    }
        public  void buscar(){
        for(Integer i=this.inicio;i<this.fin;i++){
            byte[] aux=(cadena+i).getBytes();
            byte[] hash=messageDigest.digest(aux);
            if(hash[0]==0 && hash[1]==0 && hash[2]==0  ){
                System.out.println( hash[0]+"thread"+ "   "+inicio+"    "+fin );
            }
        }
    }
}
