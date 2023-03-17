package assessment.games.baazi;

import java.util.LinkedList;

public class ProducerConsumerProcessor {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int UPPER_LIMIT = 10;
    private final int LOWER_LIMIT = 0;
    private int value = 0;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        while(true) {
            synchronized (lock) {
                while(list.size() == UPPER_LIMIT) {
                    System.out.println("waiting for items to be consumed...");
                    lock.wait();
                }
                System.out.println("adding : " + value);
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (lock) {
                while(list.size() == LOWER_LIMIT) {
                    System.out.println("waiting for items to be produced...");
                    if(value >= 1000) {
                        value = 0;
                    }
                    lock.wait();
                }
                int removedValue = list.removeFirst();
                System.out.println("removing : " + removedValue);
                lock.notify();
            }
        }
    }
}
