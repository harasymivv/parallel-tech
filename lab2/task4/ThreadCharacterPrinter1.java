package lab2.task4;

public class ThreadCharacterPrinter1 {
  public static void main(String[] args) {

      int lineCount = 90;

      for (int line = 0; line < lineCount; line++) {
          Thread thread1 = new Thread(new PrinterChar('|', 10));
          Thread thread2 = new Thread(new PrinterChar('\\', 10));
          Thread thread3 = new Thread(new PrinterChar('/', 10));

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

          System.out.println();
      }
  }
}
