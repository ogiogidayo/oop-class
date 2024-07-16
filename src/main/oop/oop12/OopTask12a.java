package oop12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OopTask12a {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Timer timer = new Timer(100, null);
        Panel2 panel2 = new Panel2(timer);
        timer.addActionListener(panel2);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e ->{
            panel2.startMoving();
            if (!timer.isRunning()) timer.start();
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e ->{
            panel2.stopMoving();
            timer.stop();
        });

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

class Panel2 extends JPanel implements ActionListener {
    private int x = 100, y = 100;
    private int vx = 5, vy = 5;
    private final int SIZE = 20;
    private Timer timer;
    private boolean moving = false;

    public Panel2(Timer timer) {
        this.timer = timer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moving) {
            if (x <= 0 || x + SIZE >= getWidth()) vx = -vx;
            if (y <= 0 || y + SIZE >= getHeight()) vy = -vy;

            x += vx;
            y += vy;

            repaint();
        }
    }

    public void startMoving() {
        moving = true;
    }

    public void stopMoving() {
        moving = false;
    }
}