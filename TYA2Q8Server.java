import java.io.*;
import java.net.*;

public class TYA2Q8Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            int num = din.readInt();
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    dout.writeInt(i);
                    Thread.sleep(2000); // 2 seconds delay
                }
            }
            dout.writeInt(-1); // End signal

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
