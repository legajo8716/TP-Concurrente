import java.util.ArrayList;

public class Buffer {
    private ArrayList<Long> cola;

    public Buffer(int dimension) {
        this.cola= new ArrayList<Long>(dimension);
    }
    public synchronized ArrayList<Long> pop() {
        while (this.cola.isEmpty() ) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
        }
        ArrayList<Long> colaAux=new ArrayList<Long>(2);
        colaAux.add(cola.get(0));
        colaAux.add(cola.get(1));
        this.cola.clear();
        notifyAll();
        return colaAux;
    }

    public  synchronized void add(long init,long finaly) {
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
