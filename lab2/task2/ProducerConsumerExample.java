package lab2.task2;

public class ProducerConsumerExample {
    public static void main(String[] args) {

        int arraySize = 100; // test different sizes
        
        System.out.println("Starting Producer-Consumer test with array size: " + arraySize);
        
        Drop drop = new Drop();
        (new Thread(new Producer(drop, arraySize))).start();
        (new Thread(new Consumer(drop))).start();
    }
}