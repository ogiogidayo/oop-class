package oop11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class OopTask11b {
    private static int currentSize = 20;
    private static Point pointA, pointB;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Random random = new Random();
        pointA = new Point(random.nextInt(400), random.nextInt(400));
        pointB = new Point(random.nextInt(400), random.nextInt(400));

        JButton setSizeButton = new JButton("Set size");
        JTextField sizeField = new JTextField(String.valueOf(currentSize), 10);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Size:"));
        topPanel.add(sizeField);
        topPanel.add(setSizeButton);

        CirclePanel circlePanel = new CirclePanel();

        JButton addToListButton = new JButton("Add to list");
        topPanel.add(addToListButton);

        setSizeButton.addActionListener(e -> {
            try {
                currentSize = Integer.parseInt(sizeField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid size entered. Please enter a valid number.");
            }
        });

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
        Color color;

        public Circle(int x, int y, int size, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
        }
    }

    static class CirclePanel extends JPanel {
        private final ArrayList<Circle> circles = new ArrayList<>();
        private Circle lastCircle = null;

        CirclePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Color circleColor = determineColor(e.getX(), e.getY());
                    lastCircle = new Circle(e.getX(), e.getY(), currentSize, circleColor);
                    repaint();
                }
            });
        }

        private Color determineColor(int x, int y) {
            int ax = pointA.x;
            int ay = pointA.y;
            int bx = pointB.x;
            int by = pointB.y;

            int det = (bx - ax) * (y - ay) - (by - ay) * (x - ax);

            return det >= 0 ? Color.RED : Color.BLUE;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine(pointA.x, pointA.y, pointB.x, pointB.y);

            for (Circle circle : circles) {
                g.setColor(circle.color);
                g.drawOval(circle.x - circle.size / 2, circle.y - circle.size / 2, circle.size, circle.size);
            }
            if (lastCircle != null) {
                g.setColor(lastCircle.color);
                g.drawOval(lastCircle.x - lastCircle.size / 2, lastCircle.y - lastCircle.size / 2, lastCircle.size, lastCircle.size);
            }
        }
    }
}
