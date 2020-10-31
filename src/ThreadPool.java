import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadPool {

    int cantPow;
    ArrayList<PowWorker> pows;
    Buffer buffer;
    boolean noceEncontrado=false;
    Cronometro cronometro;
    int tiempo=0;

    public  ThreadPool(int cant, String cadena, Buffer b, int dificultad){
        cantPow=cant;
        pows=new ArrayList<PowWorker>(cant);
        buffer=b;
        cronometro= new Cronometro(this);
        for (int i=0;i<cantPow;i++){
            pows.add(new PowWorker( cadena,  i, b,this,dificultad));
        }

    }


    public  void run() {

     for (PowWorker p : pows){
        p.start();
     }
        cronometro.run();
    }


    public void encontreNoce() {
        this.noceEncontrado=true;
        System.out.println("Pasaron "+this.tiempo+"s para encontrar el nonce");
    }

    public void getArrayByteToHexa(byte[] cadena){
        System.out.print("El hash encontrado es: ");

        for (byte b : cadena) {
            String st = String.format("%02X", b);
            System.out.print(st);
        }
    }


    public void pasarUnSegundo() {
        tiempo++;

    }
}
