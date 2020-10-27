import java.util.ArrayList;

public class ThreadPool {

    int cantPow;
    ArrayList<PowWorker> pows;
    Buffer buffer;
    public  ThreadPool(int cant,String cadena,Buffer b){
        cantPow=cant;
        pows=new ArrayList<PowWorker>(cant);
        buffer=b;
        for (int i=0;i<cantPow;i++){
            pows.add(new PowWorker( cadena,  i, b));
        }
    }


    public  void run() {

     for (PowWorker p : pows){
        p.start();
     }
    }
}
