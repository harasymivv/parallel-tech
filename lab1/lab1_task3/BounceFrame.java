package lab1.lab1_task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private JTextField blueCountField;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Priority Ball Demonstration");
        this.canvas = new BallCanvas();

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        blueCountField = new JTextField("10", 5);
        JLabel countLabel = new JLabel("Blue Balls Count: ");

        JButton buttonStart = new JButton("Start Experiment");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExperiment();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(countLabel);
        buttonPanel.add(blueCountField);
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void startExperiment() {

        canvas.removeAllBalls();
        
        int blueCount = Integer.parseInt(blueCountField.getText());
        
        int startX = WIDTH / 2;
        int startY = HEIGHT / 2;
        
        Ball redBall = new Ball(canvas, Color.RED, startX, startY, 1);
        canvas.add(redBall);
        BallThread redThread = new BallThread(redBall, true);
        redThread.start();

        for (int i = 0; i < blueCount; i++) {
            Ball blueBall = new Ball(canvas, Color.BLUE, startX, startY, 1);
            canvas.add(blueBall);
            BallThread blueThread = new BallThread(blueBall, false);
            blueThread.start();
        }
    }
}