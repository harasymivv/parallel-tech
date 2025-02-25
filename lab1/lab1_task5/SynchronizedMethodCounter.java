package lab1.lab1_task5;

class SynchronizedMethodCounter extends Counter {
  @Override
  public synchronized void increment() {
      count++;
  }
  
  @Override
  public synchronized void decrement() {
      count--;
  }
  
  @Override
  public synchronized int getValue() {
      return count;
  }
}
