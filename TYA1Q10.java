import java.awt.*;
import javax.swing.*;

public class TYA1Q10 extends JFrame {
    JTextField tf = new JTextField(20);
    String str = "Hello Java";

    public TYA1Q10() {
        setLayout(new FlowLayout());
        add(tf);
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread(() -> {
            try {
                for (int i = 0; i < str.length(); i++) {
                    tf.setText(tf.getText() + str.charAt(i));
                    Thread.sleep(1000);
                }
            } catch (Exception e) {}
        }).start();
    }

    public static void main(String[] args) {
        new TYA1Q10();  
    }
}
