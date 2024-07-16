package oop12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class OopTask12b {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Timer timer = new Timer(100, null);
        Panel3 panel3 = new Panel3(timer);
        timer.addActionListener(panel3);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (!timer.isRunning()) timer.start();
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> {
            timer.stop();
        });

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> panel3.addBall());

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(addButton);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

class Panel3 extends JPanel implements ActionListener {
    private final java.util.List<Ball> balls = new ArrayList<>();
    private final Timer timer;
    private final Random random = new Random();
    private static final int SIZE = 20;

    public Panel3(Timer timer) {
        this.timer = timer;
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void addBall() {
        int w = getWidth() - SIZE;
        int h = getHeight() - SIZE;
        double x = w / 2.0 + random.nextGaussian() * 0.05 * w / 2.0;
        double y = h / 2.0 + random.nextGaussian() * 0.05 * h / 2.0;
        double dx = random.nextGaussian() * 5;
        double dy = random.nextGaussian() * 5;
        balls.add(new Ball(Math.max(0, Math.min(w, (int) x)), Math.max(0, Math.min(h, (int) y)), dx, dy));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            g.drawOval(ball.x - SIZE / 2, ball.y - SIZE / 2, SIZE, SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int w = getWidth() - SIZE;
        int h = getHeight() - SIZE;
        for (Ball ball : balls) {
            ball.x += ball.dx;
            ball.y += ball.dy;
            ball.dx = random.nextGaussian() * 5;
            ball.dy = random.nextGaussian() * 5;

            if (ball.x < 0) {
                ball.x = 0;
                ball.dx = -ball.dx;
            } else if (ball.x > w) {
                ball.x = w;
                ball.dx = -ball.dx;
            }
            if (ball.y < 0) {
                ball.y = 0;
                ball.dy = -ball.dy;
            } else if (ball.y > h) {
                ball.y = h;
                ball.dy = -ball.dy;
            }
        }
        repaint();
    }
    static class Ball {
        int x, y;
        double dx, dy;

        Ball(int x, int y, double dx, double dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }
    }
}