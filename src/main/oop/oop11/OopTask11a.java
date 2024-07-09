package oop11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OopTask11a {
    private static int currentSize = 20; // Default size

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton setSizeButton = new JButton("Set size");
        JTextField sizeField = new JTextField(String.valueOf(currentSize), 10);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Size:"));
        topPanel.add(sizeField);
        topPanel.add(setSizeButton);

        CirclePanel circlePanel = new CirclePanel();

        JButton addToListButton = new JButton("Add to list");
        topPanel.add(addToListButton);

        addToListButton.addActionListener(e -> {
            if (circlePanel.lastCircle != null) {
                circlePanel.circles.add(circlePanel.lastCircle);
                circlePanel.lastCircle = null;
            }
            frame.repaint();
        });
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(circlePanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    static class Circle {
        int x, y, size;

        public Circle(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static class CirclePanel extends JPanel {
        private final ArrayList<Circle> circles = new ArrayList<>();
        private Circle lastCircle = null;

        CirclePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (lastCircle == null) {
                        lastCircle = new Circle(e.getX(), e.getY(), currentSize);
                    } else {
                        lastCircle.x = e.getX();
                        lastCircle.y = e.getY();
                    }
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Circle circle : circles) {
                g.drawOval(circle.x - circle.size / 2, circle.y - circle.size / 2, circle.size, circle.size);
            }
            if (lastCircle != null) {
                g.drawOval(lastCircle.x - lastCircle.size / 2, lastCircle.y - lastCircle.size / 2, lastCircle.size, lastCircle.size);
            }
        }
    }
}