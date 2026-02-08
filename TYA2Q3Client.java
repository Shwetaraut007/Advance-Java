import java.io.*;
import java.net.*;

public class TYA2Q3Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hi");
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
