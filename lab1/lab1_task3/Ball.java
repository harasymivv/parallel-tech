package lab1.lab1_task3;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private Color color;

    public Ball(Component c, Color color, int startX, int startY, int direction) {
        this.canvas = c;
        this.color = color;
        this.x = startX;
        this.y = startY;
        
        if (direction == 1) {
            dx = 2;
            dy = 2;
        } else if (direction == 2) {
            dx = -2;
            dy = 2;
        } else if (direction == 3) {
            dx = 2;
            dy = -2;
        } else {
            dx = -2;
            dy = -2;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() {
        x += dx;
        y += dy;
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
