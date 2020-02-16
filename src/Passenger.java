import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;

    public Passenger(Semaphore semaphore, CountDownLatch countDownLatch) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        System.out.println(getName() + " идет на кассу.");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " покупает билеты на автобус в Ош, на кассе.");
        try {
            sleep((long)(Math.random() + 6000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(getName() + " садиться в автобус.");
        semaphore.release();
    }
}
