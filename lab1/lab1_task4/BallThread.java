package lab1.lab1_task4;

import java.awt.Color;

public class BallThread extends Thread {
    private Ball ball;
    private BallCanvas canvas;
    private BallThread predecessor;

    public BallThread(Ball ball, BallCanvas canvas) {
        this.ball = ball;
        this.canvas = canvas;
        this.predecessor = null;
    }

    public BallThread(Ball ball, BallCanvas canvas, BallThread predecessor) {
        this.ball = ball;
        this.canvas = canvas;
        this.predecessor = predecessor;
    }

    @Override
    public void run() {
        try {
            if (predecessor != null) {
                System.out.println(getName() + " waiting for predecessor to finish...");
                predecessor.join();
            }

            System.out.println(getName() + " started moving (" + ((ball.getColor().equals(Color.BLUE)) ? "Blue" : "Red") + " ball)");

            while (!ball.isInPocket()) {
                ball.move();
                System.out.println(getName() + " moving (" + ((ball.getColor().equals(Color.BLUE)) ? "Blue" : "Red") + " ball)");
                Thread.sleep(7); 
            }

            System.out.println(getName() + " entered pocket (" + ((ball.getColor().equals(Color.BLUE)) ? "Blue" : "Red") + " ball)");
            canvas.removeBall(ball);

        } catch (InterruptedException ex) {
            System.out.println(getName() + " thread interrupted");
            ex.printStackTrace();
        }
    }
}
