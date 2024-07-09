package oop10;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class OopTask10b {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Lissajous().setVisible(true);
        });
    }
}

class Lissajous extends JFrame {

    public Lissajous() {
        setSize(280, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.translate(width / 2, height / 2);

        g2d.scale(1, -1);

        double scale = 100;

        g2d.setColor(Color.BLUE);
        drawLissajous(g2d,
                t -> Math.cos(5 * t) * scale,
                t -> Math.sin(4 * t + Math.PI / 4) * scale
        );
    }

    private void drawLissajous(Graphics2D g2d, java.util.function.Function<Double, Double> xFunc, java.util.function.Function<Double, Double> yFunc) {
        Path2D path = new Path2D.Double();
        boolean first = true;
        for (double t = 0; t <= 2 * Math.PI; t += 0.01) {
            double x = xFunc.apply(t);
            double y = yFunc.apply(t);
            if (first) {
                path.moveTo(x, y);
                first = false;
            } else {
                path.lineTo(x, y);
            }
        }
        g2d.draw(path);
    }
}