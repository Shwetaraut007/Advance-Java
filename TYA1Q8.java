import java.awt.*;
import javax.swing.*;

public class TYA1Q8 extends JFrame {

    public TYA1Q8() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 50; i <= 250; i += 50) {
            g.drawLine(i, 50, i, 300);  // vertical lines
        }
    }

    public static void main(String[] args) {
        new TYA1Q8();  
    }
}
