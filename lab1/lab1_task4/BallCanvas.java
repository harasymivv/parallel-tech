package lab1.lab1_task4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private static final int POCKET_SIZE = 40;
    private BounceFrame parentFrame;  

    public BallCanvas(BounceFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void add(Ball b) {
        this.balls.add(b);
        repaint();
    }

    public void removeBall(Ball b) {
        balls.remove(b);
        repaint();

        if (balls.isEmpty()) {
            parentFrame.enableStartButton();
        }
    }

    public void clearBalls() {
        balls.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        g2.setColor(Color.BLACK);
        g2.fillOval(0, 0, POCKET_SIZE, POCKET_SIZE);
        g2.fillOval(getWidth() - POCKET_SIZE, 0, POCKET_SIZE, POCKET_SIZE);
        g2.fillOval(0, getHeight() - POCKET_SIZE, POCKET_SIZE, POCKET_SIZE);
        g2.fillOval(getWidth() - POCKET_SIZE, getHeight() - POCKET_SIZE, POCKET_SIZE, POCKET_SIZE);


        for (Ball b : balls) {
            b.draw(g2);
        }
    }
}
