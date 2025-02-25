package lab1.lab1_task5;

class SynchronizedBlockCounter extends Counter {
  @Override
  public void increment() {
      synchronized(this) {
          count++;
      }
  }
  
  @Override
  public void decrement() {
      synchronized(this) {
          count--;
      }
  }
  
  @Override
  public int getValue() {
      synchronized(this) {
          return count;
      }
  }
}
