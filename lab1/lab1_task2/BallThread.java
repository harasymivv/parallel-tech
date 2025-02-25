package lab1.lab1_task2;

public class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;

    public BallThread(Ball ball, BallCanvas canvas) {
        this.b = ball;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        try {
            while (!b.isInPocket()) {
                b.move();
                System.out.println("Thread " + Thread.currentThread().getName() + " is moving ball");
                Thread.sleep(5);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + 
                             " ball entered " + b.getPocketHit() + " pocket - thread terminating");
            canvas.removeBall(b);
        } catch (InterruptedException ex) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
            ex.printStackTrace();
        }
    }
}