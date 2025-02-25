package lab1.lab1_task2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private static final int POCKET_SIZE = 40;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private boolean inPocket = false;
    private String pocketHit = "";

    public Ball(Component c) {
        this.canvas = c;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public boolean isInPocket() {
        return inPocket;
    }

    public String getPocketHit() {
        return pocketHit;
    }

    private boolean checkPocketCollision(int pocketX, int pocketY, String pocketName) {
        int ballCenterX = x + XSIZE/2;
        int ballCenterY = y + YSIZE/2;
        int pocketCenterX = pocketX + POCKET_SIZE/2;
        int pocketCenterY = pocketY + POCKET_SIZE/2;
        
        double distance = Math.sqrt(
            Math.pow(ballCenterX - pocketCenterX, 2) + 
            Math.pow(ballCenterY - pocketCenterY, 2)
        );
        
        if (distance < POCKET_SIZE/2) {
            inPocket = true;
            pocketHit = pocketName;
            return true;
        }
        return false;
    }

    public void move() {
        x += dx;
        y += dy;
        
        if (checkPocketCollision(0, 0, "Top-Left") ||
            checkPocketCollision(canvas.getWidth() - POCKET_SIZE, 0, "Top-Right") ||
            checkPocketCollision(0, canvas.getHeight() - POCKET_SIZE, "Bottom-Left") ||
            checkPocketCollision(canvas.getWidth() - POCKET_SIZE, canvas.getHeight() - POCKET_SIZE, "Bottom-Right")) {
            return;
        }

        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }
}
