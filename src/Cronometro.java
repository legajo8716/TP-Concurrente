import java.util.TimerTask;
import java.util.Timer;

public class Cronometro extends TimerTask {
    ThreadPool pool;
    Timer timer;

     Cronometro(ThreadPool p){
        this.pool=p;
        this.timer=new Timer();

    }
    @Override
    public void run() {
        this.pool.pasarUnSegundo();
        timer.schedule(new Cronometro(pool), 1000);


    }


}
