import java.util.ArrayList;

public class ThreadPool {

    int cantPow;
    ArrayList<PowWorker> pows;
    Buffer buffer;
    boolean noceEncontrado=false;
    public  ThreadPool(int cant,String cadena,Buffer b){
        cantPow=cant;
        pows=new ArrayList<PowWorker>(cant);
        buffer=b;
        for (int i=0;i<cantPow;i++){
            pows.add(new PowWorker( cadena,  i, b,this));
        }
    }


    public  void run() {

     for (PowWorker p : pows){
        p.start();
     }
    }

    public void encontreNoce() {
        this.noceEncontrado=true;
    }

    public void getArrayByteToHexa(byte[] cadena){
        System.out.print("El hash encontrado es: ");

        for (byte b : cadena) {
            String st = String.format("%02X", b);
            System.out.print(st);
        }
    }



}
