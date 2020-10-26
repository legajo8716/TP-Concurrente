import java.util.ArrayList;

public class Buffer extends Thread{
    private ArrayList<Integer> cola;
    private int cantDatos=0;
    private int dimension;
    private int cantThread;

    public Buffer() {
        this.cola= new ArrayList<Integer>(dimension);


    }
    synchronized ArrayList<Integer> pop() {
        while (this.cola.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
        }
        ArrayList<Integer> colaAux=new ArrayList<>(2);
        colaAux.add(this.cola.get(0));
        colaAux.add(this.cola.get(1));

        this.cola.clear();
        notifyAll();

        System.out.println(colaAux.get(0));
        System.out.println(colaAux.get(1));

        return colaAux;
    }

    synchronized void add(int init,int finaly) {
        while (!cola.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
        }
        this.cola.add(init);
        this.cola.add(finaly);
        notifyAll();






        }


}
