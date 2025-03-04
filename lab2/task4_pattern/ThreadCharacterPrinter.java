package lab2.task4_pattern;

public class ThreadCharacterPrinter {
    public static void main(String[] args) {
        for (int lineCount = 0; lineCount < 90; lineCount++) {

            Object lock = new Object();
            
            StringBuilder sharedString = new StringBuilder();

            Thread thread1 = new Thread(new SequentialCharacterPrinter(lock, '|', 0, 3, sharedString));
            Thread thread2 = new Thread(new SequentialCharacterPrinter(lock, '\\', 1, 3, sharedString));
            Thread thread3 = new Thread(new SequentialCharacterPrinter(lock, '/', 2, 3, sharedString));

            thread1.start();
            thread2.start();
            thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(sharedString);
        }
    }
}