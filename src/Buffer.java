import java.util.ArrayList;

public class Buffer {
    private ArrayList<Integer> cola;
    private int cantDatos=0;
    private int dimension;
    private int cantThread;

    public Buffer(int dimension,int cantThread) {
        this.cola= new ArrayList<Integer>(dimension);
        this.cola.add( 0);
        this.cola.add((int) Math.pow(2,(32-cantThread)));
        this.dimension=dimension;
        this.cantThread=cantThread;
    }
    synchronized ArrayList<Integer> getUnidadesDeTrabajo() {
        while (this.cola.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
        }
        notifyAll();
        ArrayList<Integer> colaAux=new ArrayList<>(2);
        colaAux.add(this.cola.get(0));
        colaAux.add(this.cola.get(1));

                this.cola.clear();
        System.out.println(colaAux.get(0));
        System.out.println(colaAux.get(1));

        return colaAux;
    }

    synchronized void generarUnidadesDeTrabajo() {
        while (!cola.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
        }
        notifyAll();

        this.cola.add((int) Math.pow(2,(32-cantThread)));
        this.cola.add((int) Math.pow(2,(32-(--cantThread))));




        }


}
