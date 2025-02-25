package lab1.lab1_task5;

class ObjectLockCounter extends Counter {
  private final Object lock = new Object();
  
  @Override
  public void increment() {
      synchronized(lock) {
          count++;
      }
  }
  
  @Override
  public void decrement() {
      synchronized(lock) {
          count--;
      }
  }
  
  @Override
  public int getValue() {
      synchronized(lock) {
          return count;
      }
  }
}
