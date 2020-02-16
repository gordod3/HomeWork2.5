public class Main {
    public static void main(String[] args) {
        Fori fori = new Fori();
        fori.start();
        try {
            fori.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автобус отправился в Ош.");
    }
}
