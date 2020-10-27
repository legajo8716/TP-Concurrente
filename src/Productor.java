public class Productor extends Thread{
    int cantThread;
    Buffer buffer;
    double unidadDeTrabajo;
    int init;
    int finaly;
    public Productor(int cantT,Buffer b,double u)  {
        cantThread=cantT;
        buffer=b;
        unidadDeTrabajo=u;
        init = 0;
        finaly=(int) (Math.pow(2,(32))/cantThread);;


    }

    @Override
    public synchronized void run() {
        int i=0;
        while(true){
           System.out.println(i);
            double inicioAux=unidadDeTrabajo*i;

            double finAux=unidadDeTrabajo*(++i);
            buffer.add((int)inicioAux, (int)finAux);

        }

    }
}
