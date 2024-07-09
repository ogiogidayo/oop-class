package oop10;

import javax.swing.*;
import java.awt.*;


public class OopTask10a{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("swingサンプル");
        JLabel label=new JLabel("hello",JLabel.CENTER);
        JButton button1=new JButton("button1");
        JButton button2=new JButton("button2");
        JButton button3=new JButton("button3");
        JButton button4=new JButton("button4");
        frame.setLayout(new BorderLayout());
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.add(panel,BorderLayout.NORTH);
        JPanel panel2=new JPanel();
        frame.add(panel2,BorderLayout.CENTER);

        frame.add(new MyPanel());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w=getSize().width;
        int h=getSize().height;
        g.setColor(Color.blue);
        g.fillOval(w/2, h/2, 40, 40);

        g.drawRect(50, 50, 100, 100);

        g.drawLine(50, 50, 100, 25);
        g.drawLine(100, 25, 150, 50);

        g.drawRect(87, 125, 25, 25);

        g.drawRect(62, 75, 25, 25);
        g.drawRect(112, 75, 25, 25);

    }
}