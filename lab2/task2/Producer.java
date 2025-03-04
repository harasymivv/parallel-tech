package lab2.task2;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;
    private int arraySize;
    
    public Producer(Drop drop, int arraySize) {
        this.drop = drop;
        this.arraySize = arraySize;
    }
    
    public void run() {
        Random random = new Random();
    
        for (int i = 0; i < arraySize; i++) {
            int number = random.nextInt(100);
            drop.put(number);
            System.out.format("PRODUCED: %d%n", number);
            
            try {
                Thread.sleep(random.nextInt(10)); 
            } catch (InterruptedException e) {}
        }
        
        drop.put(-1); 
    }
}