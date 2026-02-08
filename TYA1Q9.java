import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class TYA1Q9 extends JFrame {
    int x1 = 0, x2 = 0;
    Random r = new Random();

    public TYA1Q9() {
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread(() -> {
            while (true) {
                x1 += r.nextInt(10);
                x2 += r.nextInt(10);
                repaint();
                try { Thread.sleep(200); } catch (Exception e) {}
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(x1, 100, 60, 30);
        g.fillRect(x2, 160, 60, 30);
    }

    public static void main(String[] args) {
        new TYA1Q9();  
    }
}
