import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Fori extends Thread {
    private Semaphore semaphore = new Semaphore(4, true);
    public CountDownLatch countDownLatch = new CountDownLatch(100);
    @Override
    public synchronized void run(){
        Passenger[] passengers = new Passenger[100];
        for (int i = 0; i < 100; i++) {
            passengers[i] = new Passenger(semaphore, countDownLatch);
            passengers[i].setName(passengers[i].getClass().getSimpleName() + "№" + (i + 1));
        }
        for (int i = 0; i < 100; i++) {
            passengers[i].start();
            try {
                sleep((long)(Math.random() + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
