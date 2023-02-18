import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws InterruptedException {



        Thread t1 = new Thread(()->{
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            consumer();
        });

        t1.start();
        t2.start();

//        Thread.sleep(30000);


    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {//loop indefinitely
            queue.put(random.nextInt(100));//if queue is full (10) waits
        }
    }

    private static void consumer(){
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(100);
                if (random.nextInt(10) == 0) {
                    Integer value = queue.take();//if queue is empty waits
                    System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
