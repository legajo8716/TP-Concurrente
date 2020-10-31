import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadPool {

    int cantPow;
    ArrayList<PowWorker> pows;
    Buffer buffer;
    boolean noceEncontrado=false;
    TimerTask cronometro;
    int tiempo=0;
    boolean run=true;

    public  ThreadPool(int cant, String cadena, Buffer b, int dificultad){
        cantPow=cant;
        pows=new ArrayList<PowWorker>(cant);
        cronometro=new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                if (run) {
                    tiempo++;
                }
                else{

                    cancel();
                }
            }
        };








        buffer=b;
        for (int i=0;i<cantPow;i++){
            pows.add(new PowWorker( cadena,  i, b,this,dificultad));
        }

    }


    public  void run() {
            System.out.println("\n-------------- Asignando unidades de trabajos-------------------");
             for (PowWorker p : pows){
                p.start();
             }
             cronometro.run();

    }


    public void encontreNoce() {
        this.noceEncontrado=true;
        System.out.println("Pasaron "+this.tiempo+"s para encontrar el nonce");
        for(PowWorker p :pows){
            p.dejaDeBuscar();

        }
        run=false;

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
