package lab2.task2;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;
    private int receivedCount = 0;
    
    public Consumer(Drop drop) {
        this.drop = drop;
    }
    
    public void run() {
        Random random = new Random();
        
        for (Integer number = drop.take(); number != -1; number = drop.take()) {
            receivedCount++;
            System.out.format("CONSUMED: %d%n", number);
            
            try {
                Thread.sleep(random.nextInt(10)); // 
            } catch (InterruptedException e) {}
        }
        
        System.out.println("Consumer finished. Total items received: " + receivedCount);
    }
}