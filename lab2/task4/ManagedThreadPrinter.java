package lab2.task4;

class ManagedThreadPrinter implements Runnable {
  private final StringBuilder sharedString;
  private final int repetitions;
  
  public ManagedThreadPrinter(StringBuilder sharedString, int repetitions) {
      this.sharedString = sharedString;
      this.repetitions = repetitions;
  }
  
  @Override
  public void run() {
      for (int i = 0; i < repetitions; i++) {
          synchronized (sharedString) {
              sharedString.append("|\\/");
          }
          try {
              Thread.sleep(10);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}
