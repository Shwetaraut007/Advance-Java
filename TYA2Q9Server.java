import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TYA2Q9Server extends JFrame {
    JTextArea ta;
    JTextField tf;
    ServerSocket ss;
    Socket s;
    BufferedReader in;
    PrintWriter out;

    public TYA2Q9Server() {
        setTitle("Server Chat");
        setSize(400, 400);
        setLayout(new BorderLayout());

        ta = new JTextArea();
        tf = new JTextField();

        add(new JScrollPane(ta), BorderLayout.CENTER);
        add(tf, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            ss = new ServerSocket(1234);
            ta.append("Server started...\n");
            s = ss.accept();
            ta.append("Client connected...\n");

            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);

            tf.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    out.println(tf.getText());
                    ta.append("Server: " + tf.getText() + "\n");
                    tf.setText("");
                }
            });

            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        String msg;
                        while ((msg = in.readLine()) != null) {
                            ta.append("Client: " + msg + "\n");
                        }
                    } catch (Exception ex) {
                    }
                }
            });
            t.start();

        } catch (Exception e) {
            ta.append("Error: " + e);
        }
    }

    public static void main(String[] args) {
        new TYA2Q9Server();
    }
}
