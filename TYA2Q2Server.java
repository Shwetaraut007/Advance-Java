import java.io.*;
import java.net.*;

public class TYA2Q2Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            int num = din.readInt();
            int temp = num, sum = 0, r;

            while (temp > 0) {
                r = temp % 10;
                sum = sum + (r * r * r);
                temp = temp / 10;
            }

            if (sum == num)
                dout.writeUTF("It is an Armstrong number.");
            else
                dout.writeUTF("It is NOT an Armstrong number.");

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
