package lab1.lab1_task3;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball, boolean isRedBall) {
        this.b = ball;
        
        if (isRedBall) {
            this.setPriority(Thread.MAX_PRIORITY); // Priority 10
        } else {
            this.setPriority(Thread.MIN_PRIORITY); // Priority 1
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10000; i++) {
                b.move();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}