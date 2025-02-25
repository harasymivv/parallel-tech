package lab1.lab1_task5;

public class CounterSynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Testing WITHOUT synchronization ===");
        Counter unsyncCounter = new Counter();
        testCounter(unsyncCounter);

        System.out.println("\n=== Testing synchronized methods ===");
        Counter counter1 = new SynchronizedMethodCounter();
        testCounter(counter1);
        
        System.out.println("\n=== Testing synchronized blocks ===");
        Counter counter2 = new SynchronizedBlockCounter();
        testCounter(counter2);
        
        System.out.println("\n=== Testing object lock ===");
        Counter counter3 = new ReentrantLockCounter();
        testCounter(counter3);
    }
    
    private static void testCounter(Counter counter) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });
        
        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }
        });
        

        incrementThread.start();
        decrementThread.start();
        
        incrementThread.join();
        decrementThread.join();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        
        System.out.println("Final counter value: " + counter.getValue());
        System.out.println("Time elapsed: " + elapsedTime + " ms");
    }
}

