package lab1.lab1_task2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private int pocketedBalls = 0;
    private JTextField counterField;
    private static final int POCKET_SIZE = 40;

    public void setCounterField(JTextField field) {
        this.counterField = field;
    }

    public void add(Ball b) {
        this.balls.add(b);
        repaint();
    }

    public synchronized void removeBall(Ball b) {
        balls.remove(b);
        pocketedBalls++;
        if (counterField != null) {
            counterField.setText(String.valueOf(pocketedBalls));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        

        g2.setColor(Color.BLACK);
        // Top-left pocket
        g2.fillOval(0, 0, POCKET_SIZE, POCKET_SIZE);
        // Top-right pocket
        g2.fillOval(getWidth() - POCKET_SIZE, 0, POCKET_SIZE, POCKET_SIZE);
        // Bottom-left pocket
        g2.fillOval(0, getHeight() - POCKET_SIZE, POCKET_SIZE, POCKET_SIZE);
        // Bottom-right pocket
        g2.fillOval(getWidth() - POCKET_SIZE, getHeight() - POCKET_SIZE, POCKET_SIZE, POCKET_SIZE);
        
 
        for (Ball b : balls) {
            b.draw(g2);
        }
    }
}