import java.awt.*;
import javax.swing.*;

class TYA1Q7 extends Thread {
    int y = 0;
    int speed;
    JPanel panel;

    TYA1Q7(JPanel panel, int speed) {
        this.panel = panel;
        this.speed = speed;
    }

    public void run() {
        while (true) {
            y += speed;
            if (y > 300) y = 0;
            panel.repaint();
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

public class BouncingBalls extends JFrame {
    TYA1Q7 ball1, ball2, ball3;

    public BouncingBalls() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.fillOval(50, ball1.y, 30, 30);
                g.fillOval(150, ball2.y, 30, 30);
                g.fillOval(250, ball3.y, 30, 30);
            }
        };

        add(panel);
        setVisible(true);

        
        ball1 = new TYA1Q7(panel, 5);
        ball2 = new TYA1Q7(panel, 7);
        ball3 = new TYA1Q7(panel, 9);

        ball1.start();
        ball2.start();
        ball3.start();
    }

    public static void main(String[] args) {
        new BouncingBalls();
    }
}
