package lab1.lab1_task1;

public class BallThread extends Thread {
  private Ball b;

  public BallThread(Ball ball) {
      this.b = ball;
  }

  @Override
  public void run() {
      try {
          for (int i = 1; i < 10000; i++) {
              b.move();
              System.out.println("Thread name = " + Thread.currentThread().getName());
              Thread.sleep(5);
          }
      } catch (InterruptedException ex) {
          ex.printStackTrace();
      }
  }
}
