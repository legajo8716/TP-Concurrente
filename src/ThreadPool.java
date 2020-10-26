import java.util.ArrayList;

public class ThreadPool {

    int cantPow;
    ArrayList<Integer> barrido;
    ArrayList<PowWorker> pows;
    Buffer buffer;
    public  ThreadPool(int cant, Integer dificultad,Buffer b){
        cantPow=cant;
        pows=new ArrayList<PowWorker>(cant);
        buffer=b;
        for (int i=0;i<cantPow;i++){
            barrido=this.buffer.getUnidadesDeTrabajo();

            pows.add(new PowWorker(barrido,"hola",i));

            this.buffer.generarUnidadesDeTrabajo();

        }
    }


    public  void run() {
     this.pows.get(0).start();
     this.pows.get(1).start();
     this.pows.get(2).start();
    }
}
