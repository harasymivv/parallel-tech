package lab2.task4;

import java.util.Scanner;

public class ThreadCharacterPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose output mode: 1 - Threaded, 2 - Managed Threads");
        int choice = scanner.nextInt();
        scanner.close();
        
        for (int i = 0; i < 90; i++) {
            StringBuilder sharedString = new StringBuilder();
            
            if (choice == 1) {
                // Threaded Mode
                Thread thread1 = new Thread(new CharacterPrinter(sharedString, '|', 10));
                Thread thread2 = new Thread(new CharacterPrinter(sharedString, '\\', 10));
                Thread thread3 = new Thread(new CharacterPrinter(sharedString, '/', 10));
                
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
            } else {
                // Managed Threads Mode
                Thread thread = new Thread(new ManagedThreadPrinter(sharedString, 10));
                thread.start();
                
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println(sharedString);
        }
    }
}