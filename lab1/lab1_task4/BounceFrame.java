package lab1.lab1_task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private JButton startButton;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Thread join() Method Demonstration");
        this.canvas = new BallCanvas(this);  

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetDemo();  // Reset before starting
                startJoinDemo();
                startButton.setEnabled(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        content.add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void startJoinDemo() {
        System.out.println("Starting new simulation...");


        Ball blueBall = new Ball(canvas, Color.BLUE);
        canvas.add(blueBall);
        BallThread blueThread = new BallThread(blueBall, canvas);

        Ball redBall = new Ball(canvas, Color.RED);
        canvas.add(redBall);
        BallThread redThread = new BallThread(redBall, canvas, blueThread);

        blueThread.start();
        redThread.start();
    }

    public void resetDemo() {
        canvas.clearBalls();
        startButton.setEnabled(true);
    }

    public void enableStartButton() {
        startButton.setEnabled(true);
        System.out.println("Simulation complete! Press Start to restart.");
    }
}
